package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BrowserUtils {
    public static WebDriver driver;


    /**
     * Open maximized Chrome browser instance and set implicit wait 10 seconds
     */
    public static void openBrowser() {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Instantiate the ChromeDriver

        // Configure browser settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    /**
     * Quits the browser and all windows created of it
     */
    public static void quit() {
        driver.quit();
    }
}
