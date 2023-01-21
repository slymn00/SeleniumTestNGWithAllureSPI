package bases.exceptions;

import org.openqa.selenium.By;

public class ElementNotVisible extends Exception {
    private static final String message = "Element Görünür Değil! -> Element: %s";

    public ElementNotVisible(Exception e) {
        super(e);
    }

    public ElementNotVisible(By by, Exception e) {
        super(String.format(message, by), e);
    }
}
