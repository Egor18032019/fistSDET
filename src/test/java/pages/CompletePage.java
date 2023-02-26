package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.PageBase;

public class CompletePage extends PageBase {
    public CompletePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div//h2")
    public WebElement successPurchase;


}
