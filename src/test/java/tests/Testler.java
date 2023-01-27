package tests;

import TestMethods.AmazonHomePageMethos;
import bases.utilities.TestListeners;
import org.testng.annotations.Test;

public class Testler extends TestListeners {




    @Test
    public void controlTest(){
        startTest(new AmazonHomePageMethos(getDriver("chrome")))
                .checkSearch();
    }
}
