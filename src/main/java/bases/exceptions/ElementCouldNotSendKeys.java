package bases.exceptions;

public class ElementCouldNotSendKeys extends Exception {
    private static final String message = "Elemente Text Girilemedi! -> Girilecek Text: %s";

    public ElementCouldNotSendKeys(Exception e) {
        super(e);
    }

    public ElementCouldNotSendKeys(String text, Exception e) {
        super(String.format(message, text), e);
    }
}
