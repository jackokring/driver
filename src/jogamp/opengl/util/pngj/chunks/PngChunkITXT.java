package jogamp.opengl.util.pngj.chunks;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import jogamp.opengl.util.pngj.ImageInfo;
import jogamp.opengl.util.pngj.PngHelper;
import jogamp.opengl.util.pngj.PngjException;


/**
 * UNTESTED!
 */
public class PngChunkITXT extends PngChunkTextVar {

	private boolean compressed = false;
	private String langTag = "";
	private String translatedTag = "";

	// http://www.w3.org/TR/PNG/#11iTXt
	public PngChunkITXT(ImageInfo info) {
		super(ChunkHelper.iTXt, info);
	}

	@Override
	public ChunkRaw createChunk() {
		if (val.isEmpty() || key.isEmpty())
			return null;
		try {
			ByteArrayOutputStream ba = new ByteArrayOutputStream();
			ba.write(key.getBytes(PngHelper.charsetLatin1));
			ba.write(0); // separator
			ba.write(compressed ? 1 : 0);
			ba.write(0); // compression method (always 0)
			ba.write(langTag.getBytes(PngHelper.charsetUTF8));
			ba.write(0); // separator
			ba.write(translatedTag.getBytes(PngHelper.charsetUTF8));
			ba.write(0); // separator
			byte[] textbytes = val.getBytes(PngHelper.charsetUTF8);
			if (compressed) {
				textbytes = ChunkHelper.compressBytes(textbytes, true);
			}
			ba.write(textbytes);
			byte[] b = ba.toByteArray();
			ChunkRaw chunk = createEmptyChunk(b.length, false);
			chunk.data = b;
			return chunk;
		} catch (IOException e) {
			throw new PngjException(e);
		}
	}

	@Override
	public void parseFromChunk(ChunkRaw c) {
		int nullsFound = 0;
		int[] nullsIdx = new int[3];
		for (int i = 0; i < c.data.length; i++) {
			if (c.data[i] != 0)
				continue;
			nullsIdx[nullsFound] = i;
			nullsFound++;
			if (nullsFound == 1)
				i += 2;
			if (nullsFound == 3)
				break;
		}
		if (nullsFound != 3)
			throw new PngjException("Bad formed PngChunkITXT chunk");
		key = new String(c.data, 0, nullsIdx[0], PngHelper.charsetLatin1);
		int i = nullsIdx[0] + 1;
		compressed = c.data[i] == 0 ? false : true;
		i++;
		if (compressed && c.data[i] != 0)
			throw new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
		langTag = new String(c.data, i, nullsIdx[1] - i, PngHelper.charsetLatin1);
		translatedTag = new String(c.data, nullsIdx[1] + 1, nullsIdx[2] - nullsIdx[1] - 1, PngHelper.charsetUTF8);
		i = nullsIdx[2] + 1;
		if (compressed) {
			byte[] bytes = ChunkHelper.compressBytes(c.data, i, c.data.length - i, false);
			val = new String(bytes, PngHelper.charsetUTF8);
		} else {
			val = new String(c.data, i, c.data.length - i, PngHelper.charsetUTF8);
		}
	}

	@Override
	public void cloneDataFromRead(PngChunk other) {
		PngChunkITXT otherx = (PngChunkITXT) other;
		key = otherx.key;
		val = otherx.val;
		compressed = otherx.compressed;
		langTag = otherx.langTag;
		translatedTag = otherx.translatedTag;
	}

	public boolean isCompressed() {
		return compressed;
	}

	public void setCompressed(boolean compressed) {
		this.compressed = compressed;
	}

	public String getLangtag() {
		return langTag;
	}

	public void setLangtag(String langtag) {
		this.langTag = langtag;
	}

	public String getTranslatedTag() {
		return translatedTag;
	}

	public void setTranslatedTag(String translatedTag) {
		this.translatedTag = translatedTag;
	}
}
