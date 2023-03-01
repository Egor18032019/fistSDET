package cases.base;

import cons.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static cons.Cons.urlMain;

public class BaseCase {

    public static WebDriver driver;
//    public static WebDriverWait wait;

    /*
     */
    @BeforeSuite
    public void openURL() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver = Utils.getWebDriver(Utils.Browser.CHROME);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver.manage().window().maximize();
        //Задержка выполнения теста
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(22));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
        driver.navigate().to(urlMain);
    }

    @AfterSuite()
    public void closeBrowser() {
        driver.quit();
    }

}
