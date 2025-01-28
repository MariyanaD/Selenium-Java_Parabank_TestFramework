package pages.positive;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.components.RegisterNewUser;
import pages.components.UserLogin;

import java.util.Random;
import java.util.UUID;

public class RegisterNewUserTest extends BaseTest {
    @Test
    public void successfulRegistration() {

        String firstName = getRandomFirstName();
        String lastName = getRandomLastName();
        String address = getRandomAddress();
        String city = "Sofia";
        String country = "Bulgaria";
        String postalCode = getRandomPostalCode();
        String phone = getRandomPhoneNumber();
        String ssn = getRandomSSN();
        String username = getRandomUsername();
        String password = getRandomPassword();

        RegisterNewUser.goToRegisterLink();

        RegisterNewUser.register(firstName, lastName, address, city, country,
                postalCode, phone, ssn, username, password, password);
    }

    private String getRandomFirstName() {
        String[] firstNames = {"Ivan", "Maria", "Petar", "Georgi", "Nikolay", "Anna"};
        return firstNames[new Random().nextInt(firstNames.length)];
    }

    private String getRandomLastName() {
        String[] lastNames = {"Petkov", "Ivanov", "Georgieva", "Dimitrov", "Stoyanova", "Nikolova"};
        return lastNames[new Random().nextInt(lastNames.length)];
    }

    private String getRandomAddress() {
        String[] streets = {"Karlovo str.", "Shipka str.", "Vitosha Blvd.", "Dragan Tsankov Blvd.", "Rakovski str."};
        return streets[new Random().nextInt(streets.length)];
    }

    private String getRandomPostalCode() {
        return String.valueOf(1000 + new Random().nextInt(9000));
    }

    private String getRandomPhoneNumber() {
        return "+359" + (800000000 + new Random().nextInt(99999999));
    }

    private String getRandomSSN() {
        return String.valueOf(1000 + new Random().nextInt(9000));
    }

    private String getRandomUsername() {
        return "user" + UUID.randomUUID().toString().substring(0, 5);
    }

    private String getRandomPassword() {
        return "pass" + (1000 + new Random().nextInt(9000));
    }
}
