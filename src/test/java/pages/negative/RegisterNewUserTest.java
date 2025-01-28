package pages.negative;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.components.RegisterNewUser;

public class RegisterNewUserTest extends BaseTest{
        @Test
        public void unsuccessfulRegistration() {
            RegisterNewUser.goToRegisterLink();
            RegisterNewUser.register("Ivan", "Petkov", "Karlovo str.", "Sofia", "Bulgaria",
                    "1574", "+369854453", "1234", "ivanP", "pass123", "pass123");



        }
}
