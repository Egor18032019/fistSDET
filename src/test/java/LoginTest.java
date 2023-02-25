import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    String username = "standard_user";
    String password = "secret_sauce";

    @Test(priority = 1, alwaysRun = true)
    public void userCanLoginSuccessfully() {
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(username, password);
    }

}