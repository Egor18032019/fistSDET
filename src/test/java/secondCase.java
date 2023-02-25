import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

 public class secondCase extends TestBase {
    LoginPage loginPage;
    String username = "test";
    String password = "test";

    @Test(priority = 1, alwaysRun = true)
    public void userCanLoginSuccessfully() {
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(username, password);
        Assert.assertTrue(loginPage.errorMsgTxt.getText().contains("Epic sadface: Username and password do not match any user in this service"));

    }
}
