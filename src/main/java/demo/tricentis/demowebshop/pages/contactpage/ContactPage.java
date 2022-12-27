package demo.tricentis.demowebshop.pages.contactpage;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import demo.tricentis.demowebshop.common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class ContactPage extends BasePageActions {
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    @FindBy(id = "FullName")
    @CacheLookup
    private WebElement fullName;

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "Enquiry")
    @CacheLookup
    private WebElement enquiry;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[3]/input")
    @CacheLookup
    private WebElement submitButton;


    public ContactPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
        initElement(driver, this);
    }

    public void fillData(){
        fillField(fullName, faker.artist().name());
        fillField(email, fakeValuesService.bothify("????##@gmail.com"));
        fillField(enquiry, "mensaje");
    }

    public void clickSubmit(){
        clickOnElement(submitButton);
    }

    public String messageSent(){
        By messageLocator = By.className("result");
        WebElement message = waiElement(messageLocator);
        return getTextFromElement(message);
    }

    public String messageField(){
        By errorMessageLocator = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[2]/div[1]/div[1]/span/span");
        WebElement message = waiElement(errorMessageLocator);
        return getTextFromElement(message);
    }
}
