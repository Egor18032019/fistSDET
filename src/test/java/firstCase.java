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

    @Test(priority = 1, alwaysRun = true)
    public void userCanLoginSuccessfully() {
        loginPage = new LoginPage(driver);
        loginPage.UserLogin(username, password);

    }
//TODO если предыдущий не выполнился следующий не запускается
    @Test(priority = 2, alwaysRun = false)
    public void chooseProduct() {
        productsPage = new ProductsPage(driver);
        System.out.println("продукт ");
        productsPage.addInCart();
        System.out.println("добавили в корзину");
        productsPage.goToCart();

    }

    @Test(priority = 3)
    public void cartClickCheckout() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckout();
    }

    @Test(priority = 4)
    public void fillCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutStep("test", "test", "test");
    }

    @Test(priority = 5)
    public void overviewClickFinish() {
        overviewPage = new OverviewPage(driver);
        overviewPage.clickFinish();
    }

    @Test(priority = 6)
    public void checkComplete() {
        completePage = new CompletePage(driver);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html");

        Assert.assertTrue(completePage.successPurchase.getText().contains("THANK YOU FOR YOUR ORDER"));
    }
}
