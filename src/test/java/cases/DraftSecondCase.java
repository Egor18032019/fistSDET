//package cases;
//
//import cases.base.BaseCase;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//
//public class TestSecondCase extends BaseCase {
//
//    LoginPage loginPage;
//    String username = "test";
//    String password = "test";
//
//    @Test(priority = 1, alwaysRun = true)
//    public void userNoCanLoginSuccessfully() {
//        loginPage = new LoginPage(driver);
//        loginPage.UserLogin(username, password);
//        Assert.assertTrue(loginPage.errorMsgTxt.getText().contains("Epic sadface: Username and password do not match any user in this service"));
//    }
//}
//
//
