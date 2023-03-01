package cons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {


    public static WebDriver getWebDriver(Browser en) {

        switch (en) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
            default:
                return new ChromeDriver();
        }
    }

    public enum Browser {
        CHROME, FIREFOX
    }


}

