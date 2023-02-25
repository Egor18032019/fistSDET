import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class firstCase extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    CompletePage completePage;
    String username = "standard_user";
    String password = "secret_sauce";
    boolean canNextTest = true;

    @Test(priority = 1, alwaysRun = true)
    public void userCanLoginSuccessfully() {
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(username, password);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
    }

    //TODO вынести все урлы в отдельный енум ? класс?
    @Test(priority = 2, alwaysRun = false, dependsOnMethods = {"userCanLoginSuccessfully"})
    public void chooseProduct() {
        productsPage = new ProductsPage(driver);
        System.out.println("продукт ");
        productsPage.addInCart();
        System.out.println("добавили в корзину");
        productsPage.goToCart();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/cart.html");
    }

    @Test(priority = 3, dependsOnMethods = {"chooseProduct"})
    public void cartClickCheckout() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test(priority = 4, dependsOnMethods = {"cartClickCheckout"})
    public void fillCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutStep("test", "test", "test");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test(priority = 5, dependsOnMethods = {"fillCheckout"})
    public void overviewClickFinish() {
        overviewPage = new OverviewPage(driver);
        overviewPage.clickFinish();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html");
    }

    @Test(priority = 6, dependsOnMethods = {"overviewClickFinish"})
    public void checkComplete() {
        completePage = new CompletePage(driver);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertTrue(completePage.successPurchase.getText().contains("THANK YOU FOR YOUR ORDER"));
    }
}
