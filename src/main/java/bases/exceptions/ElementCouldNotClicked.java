package bases.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementCouldNotClicked extends Exception {
    private static final String message = "Element tıklanamadı! -> Element: %s";

    public ElementCouldNotClicked(Exception e) {
        super(e);
    }

    public ElementCouldNotClicked(String text, Exception e) {
        super(String.format(message, text), e);
    }
    public ElementCouldNotClicked(By by, Exception e) {
        super(String.format(message, by), e);
    }

    public ElementCouldNotClicked(WebElement element, Exception e) {
        super(String.format(message, element.getAccessibleName()), e);
    }
}
