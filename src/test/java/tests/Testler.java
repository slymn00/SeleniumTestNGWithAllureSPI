package tests;

import TestMethods.TrendyolHomePageMethos;
import bases.utilities.TestListeners;
import org.testng.annotations.Test;

public class Testler extends TestListeners {




    @Test
    public void controlTest(){
        startTest(new TrendyolHomePageMethos(getDriver("chrome")))
                .checkSearch();
    }
}
