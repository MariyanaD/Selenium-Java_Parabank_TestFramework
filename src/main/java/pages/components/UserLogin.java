package pages.components;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BrowserUtils;

public class UserLogin {
    public final static String homePageUrl = "https://parabank.parasoft.com/parabank/index.htm";
    private static final By USERNAME_INPUT_FIELD = By.cssSelector("input[name='username']");
    private static final By PASSWORD_INPUT_FIELD = By.cssSelector("input[name='password']");
    private static final By LOGIN_BUTTON = By.cssSelector("input[class='button']");
    private static final By LOGIN_FORM_VALIDATION_MESSAGE = By.cssSelector("p[class='smallText']");
    private static final By LOGIN_FORM_VALIDATION_ERROR_MESSAGE =
            By.xpath(("//h1[contains(text(), 'Error!')]"));

    /**
     * Opens the login area of www.parabank.parasoft.com/
     */

    public static void open (){
        BrowserUtils.driver.get(homePageUrl);
    }
    /**
     * Logs in into the login area with the provided credentials (it also clicks the LOGIN button).
     * @param username the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void login (String username, String password){
        BrowserUtils.driver.findElement(USERNAME_INPUT_FIELD).sendKeys(username);
        BrowserUtils.driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        BrowserUtils.driver.findElement(LOGIN_BUTTON).click();
    }

    /**
     * Assert that the shown validation message is as expected
     * @param expectedLoginFormValidationMessage the login form validation message you expect
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */
    public static void verifyLoginFormValidationMessage (String expectedLoginFormValidationMessage, String messageOnFailure){
        String actualLoginFormValidationMessage =
                BrowserUtils.driver.findElement(LOGIN_FORM_VALIDATION_MESSAGE).getText();
        Assert.assertTrue(actualLoginFormValidationMessage.contains(expectedLoginFormValidationMessage),
                messageOnFailure);
    }
    public static void verifyLoginFormErrorMessage (String expectedLoginFormErrorMessage, String messageOnFailure){
        String actualLoginFormErrorMessage = BrowserUtils.driver.findElement(LOGIN_FORM_VALIDATION_ERROR_MESSAGE).getText();
        Assert.assertTrue(actualLoginFormErrorMessage.contains(expectedLoginFormErrorMessage));
    }
}
