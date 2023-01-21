package TestMethods;

import bases.utilities.BaseGetData;
import bases.utilities.DataFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AllPages;

public class TrendyolHomePageMethos extends AllPages {


    public TrendyolHomePageMethos(WebDriver driver){
        PageFactory.initElements(driver, this);
        driver.manage().deleteAllCookies();
    }

    public void checkSearch(){
        lib.navigateTo(BaseGetData.Url.AMAZON_URL);
        lib.Control(trendyolHomePageElements().btnAutoComplete.isDisplayed(),"autoComplete butonu goruntulendi.","autocomplete butonu goruntulenemedi.");

    }
}
