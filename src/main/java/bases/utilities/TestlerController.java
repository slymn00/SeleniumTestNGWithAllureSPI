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
            Terminal.runCommand("C:\\Program Files\\allure-2.19.0\\bin\\allure.bat generate allure-results -o C:\\Users\\wkkod\\IdeaProjects\\TestNGProject\\allure-results --clean");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void openAllureReport() {
        Terminal.runCommand("cmd /c allure serve -h localhost");
    }

}
