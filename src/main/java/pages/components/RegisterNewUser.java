package pages.components;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BrowserUtils;

public class RegisterNewUser {
    public final static String homePageUrl = "https://parabank.parasoft.com/parabank/index.htm";
    private static final By REGISTER_LINK = By.cssSelector("a[href='register.htm']");
    public final static String registerPageUrl = "https://parabank.parasoft.com/parabank/register.htm";

    private  static final By FIRST_NAME_FIELD = By.cssSelector("input[id='customer.firstName']");
    private  static final By LAST_NAME_FIELD = By.cssSelector("input[id='customer.lastName']");
    private  static final By ADDRESS_FIELD = By.cssSelector("input[id='customer.address.street']");
    private  static final By CITY_FIELD = By.cssSelector("input[id='customer.address.city']");
    private  static final By STATE_FIELD = By.cssSelector("input[id='customer.address.state']");
    private  static final By ZIP_CODE_FIELD = By.cssSelector("input[id='customer.address.zipCode']");
    private  static final By PHONE_FIELD = By.cssSelector("input[id='customer.phoneNumber']");
    private  static final By SSN_FIELD = By.cssSelector("input[id='customer.ssn']");
    private  static final By USERNAME_FIELD = By.cssSelector("input[id='customer.username']");
    private  static final By PASSWORD_FIELD = By.cssSelector("input[id='customer.password']");
    private  static final By CONFIRM_FIELD = By.cssSelector("input[id='repeatedPassword']");
    private  static final By REGISTER_BUTTON = By.cssSelector("input[type='submit'][value='Register']");
    private static final By REGISTER_FORM_VALIDATION_MESSAGE = By.cssSelector("h1[class='title']");
    private static final By REGISTER_FORM_VALIDATION_ERROR_MESSAGE =
            By.cssSelector(("button[class='error-button']"));

    public static void open (){
        BrowserUtils.driver.get(homePageUrl);
        BrowserUtils.driver.get(registerPageUrl);
    }
    public static void goToRegisterLink(){
        BrowserUtils.driver.findElement(REGISTER_LINK);
    }
    /**
     * Fill in the register area with the provided credentials (it also clicks the Register button).
     * @param firstName the first name you would like to register with
     * @param lastName the last name you would like to register with
     * @param address the address you would like to register with
     * @param city the city you would like to register with
     * @param state the state you would like to register with
     * @param zipCode the zipCode you would like to register with
     * @param phoneNumber the phoneNumber you would like to register with
     * @param ssn the ssn you would like to register with
     * @param username the ssn you would like to register with
     * @param password the password you would like to register with
     * @param repeatPassword the password you would like to register with
     */
    public static void register (String firstName, String lastName, String address, String city, String state,
                                 String zipCode, String phoneNumber, String ssn, String username, String password,
                                 String repeatPassword){
        BrowserUtils.driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        BrowserUtils.driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        BrowserUtils.driver.findElement(ADDRESS_FIELD).sendKeys(address);
        BrowserUtils.driver.findElement(CITY_FIELD).sendKeys(city);
        BrowserUtils.driver.findElement(STATE_FIELD).sendKeys(state);
        BrowserUtils.driver.findElement(ZIP_CODE_FIELD).sendKeys(zipCode);
        BrowserUtils.driver.findElement(PHONE_FIELD).sendKeys(phoneNumber);
        BrowserUtils.driver.findElement(SSN_FIELD).sendKeys(ssn);
        BrowserUtils.driver.findElement(USERNAME_FIELD).sendKeys(username);
        BrowserUtils.driver.findElement(PASSWORD_FIELD).sendKeys(password);
        BrowserUtils.driver.findElement(CONFIRM_FIELD).sendKeys(repeatPassword);
        BrowserUtils.driver.findElement(REGISTER_BUTTON).click();
    }

    /**
     * Assert that the shown validation message is as expected
     * @param expectedRegisterFormValidationMessage the register form validation message you expect
     * @param messageOnFailure the message that will appear in your reports in case of assert failure
     */
    public static void verifyRegisterFormValidationMessage (String expectedRegisterFormValidationMessage, String messageOnFailure){
        String actualRegisterFormValidationMessage =
                BrowserUtils.driver.findElement(REGISTER_FORM_VALIDATION_MESSAGE).getText();
        Assert.assertTrue(actualRegisterFormValidationMessage.contains(expectedRegisterFormValidationMessage),
                messageOnFailure);
    }
    public static void verifyRegisterFormErrorMessage (String expectedRegisterFormErrorMessage, String messageOnFailure){
        String actualRegisterFormErrorMessage = BrowserUtils.driver.findElement(REGISTER_FORM_VALIDATION_ERROR_MESSAGE).getText();
        Assert.assertTrue(actualRegisterFormErrorMessage.contains(expectedRegisterFormErrorMessage));
    }
}
