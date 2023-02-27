package cases.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static cons.Cons.urlMain;

public class BaseCase {

    public static WebDriver driver;

    /*
     */
    @BeforeSuite
    public void openURL() {
        driver = new ChromeDriver();
        //Определение пути до драйвера и его настройка для виндовс
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver.manage().window().maximize();
        //Задержка выполнения теста
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(22));
        driver.navigate().to(urlMain);
    }

    @AfterSuite( )
    public void closeBrowser() {
        driver.quit();
    }

}
