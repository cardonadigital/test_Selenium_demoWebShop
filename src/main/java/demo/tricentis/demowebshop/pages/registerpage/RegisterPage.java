package demo.tricentis.demowebshop.pages.registerpage;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import demo.tricentis.demowebshop.common.BasePageActions;
import demo.tricentis.demowebshop.model.LoginUser;
import demo.tricentis.demowebshop.model.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;
import java.util.Objects;

public class RegisterPage extends BasePageActions{
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    @FindBy(id = "gender-male")
    @CacheLookup
    private WebElement selectorMale;

    @FindBy(id = "gender-female")
    @CacheLookup
    private WebElement selectorFemale;

    @FindBy(id = "FirstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "LastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    @CacheLookup
    private WebElement registerButton;

    @FindBy(className = "result")
    @CacheLookup
    private WebElement registerMessage;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")
    @CacheLookup
    private WebElement continueButton;


    public RegisterPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
        initElement(driver, this);
        //System.out.println(faker.dog().gender() + faker.name().firstName() + fakeValuesService.bothify("????##@gmail.com") + fakeValuesService.regexify("[a-z1-9]{10}"));
    }

    public LoginUser registerPerson(){
        Person person = createPerson();
        selectGender(person.getGender());
        fillField(firstName, person.getFirstName());
        fillField(lastName, person.getLastName());
        fillField(email, person.getEmail());
        fillField(password, person.getPassword());
        fillField(confirmPassword, person.getPassword());
        return new LoginUser(person.getEmail(), person.getPassword());
    }

    public String sendRegisterForm(){
        clickOnElement(registerButton);
        String message = getTextFromElement(registerMessage);
        clickOnElement(continueButton);
        return message;
    }
 //////
    public String sendRegisterForm(String field){
        clickOnElement(registerButton);
        String locator = String.format("//*[ contains (text(), '%s is required')]", field);
        WebElement requiredMessage = driver.findElement (By.xpath (locator));
        return getTextFromElement(requiredMessage);
    }

    public void clearField(String field){
        switch (field){
            case "First name":
                clearField(firstName);
                break;
            case "Last name":
                clearField(lastName);
                break;
            case "Email":
                clearField(email);
                break;
            case "Password":
                clearField(password);
                break;
            default:
                break;
        }
    }



    private Person createPerson(){
        return new Person(
                faker.dog().gender(),
                faker.name().firstName(),
                faker.name().lastName(),
                fakeValuesService.bothify("????##@gmail.com"),
                fakeValuesService.regexify("[a-z1-9]{10}")
        );
    }

    private void selectGender(String gender){
        if (Objects.equals(gender, "female")){
            clickOnElement(selectorFemale);
        }else {
            clickOnElement(selectorMale);
        }
    }

}
