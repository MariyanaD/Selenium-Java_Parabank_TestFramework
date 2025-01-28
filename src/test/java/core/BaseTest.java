package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.components.RegisterNewUser;
import pages.components.UserLogin;
import utils.BrowserUtils;

public class BaseTest {
    @BeforeMethod
    public void setup (){
        BrowserUtils.openBrowser();
        UserLogin.open();
        RegisterNewUser.open();
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.quit();
    }
}
