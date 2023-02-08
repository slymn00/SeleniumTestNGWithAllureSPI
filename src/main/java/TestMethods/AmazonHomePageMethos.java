package TestMethods;

import bases.utilities.BaseGetData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AllPages;

public class AmazonHomePageMethos extends AllPages {


    public AmazonHomePageMethos(WebDriver driver){
        PageFactory.initElements(driver, this);
        driver.manage().deleteAllCookies();
    }

    public void checkSearch(){
        lib.navigateTo(BaseGetData.Url.AMAZON_URL);
        lib.control(lib.isDisplayed(amazonHomePageElements().btnAutoComplete),"autoComplete butonu goruntulendi.","autocomplete butonu goruntulenemedi.");
    }
}
