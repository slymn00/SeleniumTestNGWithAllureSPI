package bases.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CouldNotScrollToElement extends Exception {
    private static final String message = "Could Not Scrool to Element! -> Element: %s";

    public CouldNotScrollToElement(Exception e) {
        super(e);
    }

    public CouldNotScrollToElement(By by, Exception e) {
        super(String.format(message, by), e);
    }

    public CouldNotScrollToElement(WebElement element, Exception e) {
        super(String.format(message, element.getAccessibleName()), e);
    }
}
