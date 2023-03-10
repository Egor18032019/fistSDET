package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.PageBase;

public class CartPage extends PageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "checkout")
    WebElement checkout;

    public void clickCheckout() {
        PageBase.clickButton(checkout);
    }
}
