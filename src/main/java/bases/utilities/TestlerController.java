package bases.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.Objects;

@Listeners({TestListeners.class})
public class TestlerController {

    public <T> T startTest(T page){
        ThreadLocal<T> tl = new ThreadLocal<>();
        tl.set(page);
        return tl.get();
    }

    public WebDriver getDriver(String browser) {
        Driver.setUp(browser);

        return Driver.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }

    @BeforeSuite(alwaysRun = true)
    public void removeReportHistory() {
        if (Objects.equals(DataFinder.getValue("config", "deleteHistory"), "true")) {
            Terminal.runCommand("allure generate --clean --output allure-results");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void openAllureReport() {
        Terminal.runCommand("allure serve -h localhost");
    }
}
