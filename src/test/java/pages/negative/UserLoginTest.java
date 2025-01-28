package pages.negative;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.components.UserLogin;

public class UserLoginTest extends BaseTest {
    @Test
    public void unsuccessfulLogin(){
        UserLogin.login("", "pass123");
        UserLogin.verifyLoginFormErrorMessage("Error!"
                ,"The expected validation message when logging in with the wrong credentials " +
                        "was not present");
    }
    @Test
    public void unsuccessfulLoginWithALotNumberOfLoginAttempts(){
        UserLogin.login("", "pass123!");
        UserLogin.verifyLoginFormErrorMessage("Too long tries for login",
                " Warning: Your account has exceeded allowed number of login attempts. Please try " +
                        "again in 1 hour or reset password.");
    }
}
