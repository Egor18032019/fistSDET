package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ProductsPage extends PageBase {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".pricebar .btn_primary")
    WebElement addCartButton;
    @FindBy(id = "shopping_cart_container")
    WebElement cart;

    public void addInCart() {
        clickButton(addCartButton);
    }

    public void goToCart() {
        clickButton(cart);
    }
}
