package bases.utilities;

public class Terminal {

    public static void runCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            Log.fail("Terminal kodu çalışırken hata çıktı. Command: " + command, e);
        }
    }
}
