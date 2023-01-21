package bases.exceptions;

import org.openqa.selenium.WebElement;

public class CouldNotMoveToElement extends Exception {
    private static final String message = "Fare Belirtilen Elementin Üstüne Kaydırılamadı -> Element: %s";

    public CouldNotMoveToElement(Exception e) {
        super(e);
    }

    public CouldNotMoveToElement(WebElement element, Exception e) {
        super(String.format(message, element.getAccessibleName()), e);
    }
}
