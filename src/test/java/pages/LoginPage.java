package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.PageBase;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(css = ".form_group #password")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginBtn;
    @FindBy(xpath = "//div//h3")
    public WebElement errorMsgTxt;
    public void UserLogin(String username, String password) {
        PageBase.setTextElementText(userName, username);
        PageBase.setTextElementText(passwordInput, password);
        PageBase.clickButton(loginBtn);

    }
}