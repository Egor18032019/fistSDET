package cases;

import cases.base.BaseCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static cons.Cons.urlMain;

public class TestSecondCase extends BaseCase {

    LoginPage loginPage;
    String username = "test";
    String password = "test";

    @Test( alwaysRun = true, groups = "second Case")
    public void userNoCanLoginSuccessfully() {
        driver.navigate().to(urlMain);
        loginPage = new LoginPage(driver);
        loginPage.authorizationOldUser(username, password);
        Assert.assertTrue(loginPage.errorMsgTxt.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }
}


