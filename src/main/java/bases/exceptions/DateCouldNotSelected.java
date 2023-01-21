package bases.exceptions;

public class DateCouldNotSelected extends Exception {
    private static final String message = "Tarih Seçimi Yapılamadı! -> Seçilecek Tarih: %s";

    public DateCouldNotSelected(Exception e) {
        super(e);
    }

    public DateCouldNotSelected(String date, Exception e) {
        super(String.format(message, date), e);
    }
}
