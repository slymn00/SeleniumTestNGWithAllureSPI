package bases.exceptions;

import org.openqa.selenium.By;

public class ElementNotFound extends Exception {
    private static final String message = "Element bulunamad─▒! %s";

    public ElementNotFound(Exception e) {
        super(e);
    }

    public ElementNotFound(By by, Exception e) {
        super(String.format(message, by), e);
    }
}
