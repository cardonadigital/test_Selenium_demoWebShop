package demo.tricentis.demowebshop.pages.homepage;

import demo.tricentis.demowebshop.common.BasePageActions;
import demo.tricentis.demowebshop.pages.loginpage.LoginPage;
import demo.tricentis.demowebshop.pages.registerpage.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageActions {
    @FindBy(className = "ico-register")
    @CacheLookup
    private WebElement register;

    @FindBy(className = "ico-logout")
    @CacheLookup
    private WebElement logOut;

    @FindBy(className = "ico-login")
    @CacheLookup
    private WebElement logIn;

    public HomePage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
        initElement(driver, this);
    }

    public RegisterPage clickFormAuth() {
        clickOnElement(register);
        return new RegisterPage(driver, 10);
    }

    public LoginPage clickLogin(){
        clickOnElement(logIn);
        return new LoginPage(driver, 10);
    }

    public void clickLogOut(){
        clickOnElement(logOut);
    }
}
