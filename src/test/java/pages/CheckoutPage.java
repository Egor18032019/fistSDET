package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.PageBase;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    WebElement first;
    @FindBy(css = ".form_group #last-name")
    WebElement last;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postal;
//OVERVIEW
    @FindBy(id = "continue")
    WebElement continueBtn;

    public void checkoutStep(String firstName, String lastName, String postalCode) {
        PageBase.setTextElementText(first, firstName);
        PageBase.setTextElementText(last, lastName);
        PageBase.setTextElementText(postal, postalCode);
        PageBase.clickButton(continueBtn);
    }
}
