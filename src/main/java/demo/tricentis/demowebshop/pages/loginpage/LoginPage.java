package demo.tricentis.demowebshop.pages.loginpage;

import demo.tricentis.demowebshop.common.BasePageActions;
import demo.tricentis.demowebshop.model.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageActions {
    @FindBy(id = "Email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement password;

    @FindBy(className = "button-1 login-button")
    @CacheLookup
    private WebElement loginButton;

    WebElement myAccount = driver.findElement(By.className("account"));

    public LoginPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
        initElement(driver, 10);
    }

    public void loginUser(LoginUser user){
        fillField(email, user.getEmail());
        fillField(email, user.getPassword());
        clickOnElement(loginButton);
    }

    public String accountEmail(){
        return getTextFromElement(myAccount);
    }
}
