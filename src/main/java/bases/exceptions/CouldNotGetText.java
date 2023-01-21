package bases.exceptions;

import org.openqa.selenium.By;

public class CouldNotGetText extends Exception {
    private static final String message = "Text Alınamadı! -> Element: %s";

    public CouldNotGetText(By by) {
        super(String.format(message, by));
    }

    public CouldNotGetText(Exception e) {
        super(String.format(message, ""), e);
    }

    public CouldNotGetText(By by, Exception e) {
        super(String.format(message, by), e);
    }
}
