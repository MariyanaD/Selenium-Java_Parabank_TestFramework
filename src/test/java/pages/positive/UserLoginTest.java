package pages.positive;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.components.UserLogin;
import utils.ApiUtils;
import utils.DatabaseUtils;

public class UserLoginTest extends BaseTest {

        @Test
        public void successfulLogin() {
            String[] user = DatabaseUtils.getRandomUser();
            String username = user[0];
            String password = user[1];

            // Perform login
            UserLogin.login(username, password);

            // Verify login success
            UserLogin.verifyLoginFormValidationMessage("Welcome", "You are now logged in!");
        }
}

