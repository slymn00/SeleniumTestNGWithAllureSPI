package bases.utilities;

import bases.exceptions.PageCouldNotLoaded;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumBase {

    public final WebDriver driver = Driver.getDriver();

    public final JavascriptExecutor js = (JavascriptExecutor) driver;

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(BaseGetData.DEFAULT_WAIT));
    public final Actions actions;
    public SeleniumBase() {
        actions = new Actions(Driver.getDriver());
    }

    public SeleniumBase(WebDriver driver) {
        actions = new Actions(driver);
    }

    /**
     * Control statement
     *
     * @param onTrue  Expected result message
     * @param onFalse False result message
     */
    public void control(boolean statement, String onTrue, String onFalse) {

        if (statement) {
            Log.pass(onTrue);
        } else {
            Log.fail(onFalse);
        }

    }

    /**
     * Default Wait Method
     */
    public void wait(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateTo(Enum<?> url) {
        try {
            driver.get(DataFinder.getValue(url));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(BaseGetData.DEFAULT_WAIT_LOADERBOX));
            Log.pass("Web application launched");
        } catch (Exception e) {
            Log.error(new PageCouldNotLoaded(DataFinder.getValue(url.name()), e));
        }
    }


    public boolean isDisplayed(WebElement dispEle){
        return dispEle.isDisplayed();
    }

}
