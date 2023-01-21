package bases.utilities;

public class Terminal {

    public static void runCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            Log.fail(e);
        }
    }
}
