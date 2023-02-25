package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends PageBase {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    WebElement continueBtn;
    public void clickFinish() {
        PageBase.clickButton(continueBtn);
    }

}
