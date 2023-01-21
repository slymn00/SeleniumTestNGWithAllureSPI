package pages;

import bases.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrendyolHomePageElements {

    public TrendyolHomePageElements(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "twotabsearchtextbox")
    public WebElement btnAutoComplete;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucuElementi;


}
