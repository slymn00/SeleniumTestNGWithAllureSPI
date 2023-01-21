package bases.exceptions;

public class PageCouldNotLoaded extends Exception {
    private static final String message = "Sayfa Yüklenemedi! -> Yüklenmesi Beklenen Url: %s";

    public PageCouldNotLoaded(Exception e) {
        super(e);
    }
    public PageCouldNotLoaded(String message) {
        super(message);
    }

    public PageCouldNotLoaded(String url, Exception e) {
        super(String.format(message, url), e);
    }
}
