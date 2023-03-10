package cases.base;

import cons.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static cons.Cons.urlMain;

public class BaseCase {

    public static WebDriver driver;

    @BeforeSuite
    public void openURL() {
        driver = Utils.getWebDriver(Utils.Browser.CHROME);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
        driver.navigate().to(urlMain);
    }

    @AfterSuite()
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

}
