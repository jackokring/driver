#ifdef GL_ES
precision mediump float;
precision mediump int;
#endif

varying   vec4    varying_Color;
uniform   sampler2D     uniform_Texture;

void main (void)
{
	gl_FragColor = varying_Color;
}
