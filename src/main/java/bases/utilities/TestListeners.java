package bases.utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class TestListeners implements TestLifecycleListener {



    public void beforeTestStop(TestResult result) {

        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            if (Driver.getDriver() != null)
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }

    }

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
            Terminal.runCommand("cmd /c allure generate --clean --output allure-results");
            //can be use underline command too
            //Terminal.runCommand("C:\\Program Files\\allure-2.19.0\\bin\\allure.bat generate allure-results -o C:\\Users\\wkkod\\IdeaProjects\\TestNGProject\\allure-results --clean");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void openAllureReport() {
        Terminal.runCommand("cmd /c allure serve -h localhost");
    }
}
