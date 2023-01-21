package bases.exceptions;

import org.openqa.selenium.By;

public class ElementDoesNotDisappear extends Exception {
    private static final String message = "Element Sayfadan Yok Olmadı! -> Element: %s";

    public ElementDoesNotDisappear(Exception e) {
        super(e);
    }

    public ElementDoesNotDisappear(By by, Exception e) {
        super(String.format(message, by), e);
    }
}
