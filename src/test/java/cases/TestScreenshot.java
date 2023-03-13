package cases;

import cases.base.BaseCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static cons.Cons.urlMain;

public class TestScreenshot extends BaseCase {
    LoginPage loginPage;


    @Test(priority = 8, alwaysRun = true, groups = "screenshot case")
    public void screenshotLogin() throws IOException, InterruptedException {
        driver.navigate().to(urlMain);
        loginPage = new LoginPage(driver);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("originScreenshots\\" + "screenshotLogin" + ".jpg"));
        File file = new File("C:\\Hobby\\Git\\SDET\\fistSDET\\originScreenshots\\screenshotLogin.jpg");
        BufferedImage original = ImageIO.read(file);
        BufferedImage image = ImageIO.read(scrFile);

        int columns = original.getWidth();
        int rows = image.getHeight();
        if (columns != image.getWidth() || rows != image.getHeight()) {
            Assert.fail();
            return;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int rgb = original.getRGB(col, row);
                int rgb2 = image.getRGB(col, row);

                if (rgb != rgb2) {
                    Assert.fail();
                    return;
                }
            }

        }
        Assert.assertTrue(true);
    }
}
