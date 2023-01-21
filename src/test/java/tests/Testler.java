package tests;

import TestMethods.TrendyolHomePageMethos;
import bases.utilities.TestlerController;
import org.testng.annotations.Test;
import pages.TrendyolHomePageElements;

public class Testler extends TestlerController {




    @Test
    public void controlTest(){
        startTest(new TrendyolHomePageMethos(getDriver("chrome")))
                .checkSearch();
    }
}
