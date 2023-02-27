package cases;

import cases.base.BaseCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static cons.Cons.*;

public class TestCase extends BaseCase {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    CompletePage completePage;
    final String username = "standard_user";
    final String password = "secret_sauce";
    final String testWrongUsername = "test";
    final String testWrongPassword = "test";

    @Test(priority = 1, alwaysRun = true)
    public void userCanLoginSuccessfully() {
        loginPage = new LoginPage(BaseCase.driver);
        loginPage.authorizationOldUser(username, password);
        String url = BaseCase.driver.getCurrentUrl();
        Assert.assertEquals(url, urlInventory);
    }

    @Test(priority = 2, dependsOnMethods = {"userCanLoginSuccessfully"}, groups = "fistCase")
    public void chooseProduct() {
        productsPage = new ProductsPage(BaseCase.driver);
        System.out.println("продукт ");
        productsPage.addInCart();
        System.out.println("добавили в корзину");
        productsPage.goToCart();
        String url = BaseCase.driver.getCurrentUrl();
        Assert.assertEquals(url, urlCart);
    }

    @Test(priority = 3, dependsOnMethods = {"chooseProduct"}, groups = "fistCase")
    public void cartClickCheckout() {
        cartPage = new CartPage(BaseCase.driver);
        cartPage.clickCheckout();
        String url = BaseCase.driver.getCurrentUrl();
        Assert.assertEquals(url, urlStepOne);
    }

    @Test(priority = 4, dependsOnMethods = {"cartClickCheckout"}, groups = "fistCase")
    public void fillCheckout() {
        checkoutPage = new CheckoutPage(BaseCase.driver);
        checkoutPage.checkoutStep("test", "test", "test");
        String url = BaseCase.driver.getCurrentUrl();
        Assert.assertEquals(url, urlStepTwo);
    }

    @Test(priority = 5, dependsOnMethods = {"fillCheckout"}, groups = "fistCase")
    public void overviewClickFinish() {
        overviewPage = new OverviewPage(BaseCase.driver);
        overviewPage.clickFinish();
        String url = BaseCase.driver.getCurrentUrl();
        Assert.assertEquals(url, urlCheckout);
    }

    @Test(priority = 6, dependsOnMethods = {"overviewClickFinish"}, groups = "fistCase")
    public void checkComplete() {
        completePage = new CompletePage(BaseCase.driver);
        String url = BaseCase.driver.getCurrentUrl();
        Assert.assertEquals(url, urlCheckout);
        Assert.assertTrue(completePage.successPurchase.getText().contains("THANK YOU FOR YOUR ORDER"));
    }

    @Test(priority = 7, alwaysRun = true, groups = "second Case")
    public void userNoCanLoginSuccessfully() {
        driver.navigate().to(urlMain);
        loginPage = new LoginPage(driver);
        loginPage.authorizationOldUser(testWrongUsername, testWrongPassword);
        Assert.assertTrue(loginPage.errorMsgTxt.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }
}
