package demo.tricentis.demowebshop.pages.loginpage;

import demo.tricentis.demowebshop.common.BasePageActions;
import demo.tricentis.demowebshop.model.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageActions {
    @FindBy(xpath = "//*[@id=\"Email\"]")
    @CacheLookup
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(className = "login-button")
    @CacheLookup
    private WebElement loginButton;


    public LoginPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
        initElement(driver, this);
    }

    public void loginUser(LoginUser user){
        fillField(emailInput, user.getEmail());
        fillField(passwordInput, user.getPassword());
        clickOnElement(loginButton);
    }

    public void loginUser(String email, String password){
        fillField(emailInput, email);
        fillField(passwordInput, password);
        clickOnElement(loginButton);
    }

    public String getAccountEmail(){
        By myAccountLocator = By.className("account");
        WebElement myAccount = waiElement(myAccountLocator);
        return getTextFromElement(myAccount);
    }

    public String getErrorLogin(){
        By errorLocator = By.className("validation-summary-errors");
        WebElement errorElement = waiElement(errorLocator);
        return getTextFromElement(errorElement);
    }
}
