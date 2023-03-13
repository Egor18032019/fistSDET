package cases.base;

import cons.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static cons.Cons.urlMain;

public class BaseCase {

    public static WebDriver driver;
//    public static WebDriverWait wait;

    @BeforeSuite
    public void openURL() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
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

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + ".jpg"));
//                    "-"+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }

}
