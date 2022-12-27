package stepdefinitions;

import base.BaseTest;
import demo.tricentis.demowebshop.model.LoginUser;
import demo.tricentis.demowebshop.pages.homepage.HomePage;
import demo.tricentis.demowebshop.pages.loginpage.LoginPage;
import demo.tricentis.demowebshop.pages.registerpage.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private static HomePage homePage;
    private static RegisterPage registerPage;
    private static LoginPage loginPage;
    private static LoginUser user;

    @Given("que el cliente entre al modulo de logueo")
    public void queElClienteEntreALaPaginaWeb() {
        try {
            setUp();
            setUpLog4j2();
            homePage = new HomePage(driver, 10);
            registerPage = homePage.clickFormAuth();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @When("ingrese los datos correctos para el logeo")
    public void ingreseLosDatosCorrectosParaElLogeo() {
        try {
            user = registerPage.registerPerson();
            registerPage.sendRegisterForm();
            homePage.clickLogOut();
            loginPage = homePage.clickLogin();
            loginPage.loginUser(user);
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @Then("podra ingresar a la cuenta")
    public void podraIngresarALaCuenta() {
        try {
            Assertions.assertEquals(loginPage.getAccountEmail(), user.getEmail());
            close();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }




    @Given("que el cliente ingrese al modulo de logueo")
    public void queElClienteIngreseALaPaginaWeb() {
        try {
            setUp();
            setUpLog4j2();
            homePage = new HomePage(driver, 10);
            registerPage = homePage.clickFormAuth();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @When("ingrese los datos que no pertenezcan a ninguna cuenta registrada")
    public void ingreseLosDatosQueNoPertenezcanANingunaCuentaRegistrada() {
        try {
            user = registerPage.registerPerson();
            registerPage.sendRegisterForm();
            homePage.clickLogOut();
            loginPage = homePage.clickLogin();
            loginPage.loginUser("meloassd12@gmail.com", "1234");
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @Then("no podra ingresar a la cuenta")
    public void noPodraIngresarALaCuenta() {
        try {
            Assertions.assertNotNull(loginPage.getErrorLogin());
            close();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }



}
