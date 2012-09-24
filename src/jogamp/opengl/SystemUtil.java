package jogamp.opengl;

public class SystemUtil {

    private static volatile boolean getenvSupported = true;
    /** Wrapper for System.getenv(), which doesn't work on platforms
        earlier than JDK 5 */
    public static String getenv(String variableName) {
        if (getenvSupported) {
            try {
                return System.getenv(variableName);
            } catch (Error e) {
                getenvSupported = false;
            }
        }
        return null;
    }
}
