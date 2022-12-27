package stepdefinitions;

import base.BaseTest;
import demo.tricentis.demowebshop.model.LoginUser;
import demo.tricentis.demowebshop.pages.homepage.HomePage;
import demo.tricentis.demowebshop.pages.registerpage.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class RegisterStepDefinition extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private static HomePage homePage;
    private static RegisterPage registerPage;

    @Given("que el cliente entro a la pagina de registro")
    public void queElClienteEntroALaPaginaDeRegistro() {
        try {
            setUp();
            setUpLog4j2();
            homePage = new HomePage(driver, 10);
            registerPage = homePage.clickFormAuth();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @When("llene el formulario correctamente")
    public void lleneElFormularioCorrectamente() {
        try {
            registerPage.registerPerson();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @Then("recibira el siguiente mensaje {string}")
    public void recibiraElSiguienteMensaje(String message) {
        try {
            Assertions.assertEquals(registerPage.sendRegisterForm(), message);
            close();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }



    @Given("que el cliente entra a la pagina de registro")
    public void queElClienteEntraALaPaginaDeRegistro() {
        try {
            setUp();
            setUpLog4j2();
            homePage = new HomePage(driver, 10);
            registerPage = homePage.clickFormAuth();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @When("no llene el campo: {string}")
    public void noLleneElCampo(String field) {
        try {
            registerPage.registerPerson();
            registerPage.clearField(field);
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @Then("recibira el siguiente mensaje: {string} is required")
    public void recibiraElSiguienteMensajeIsRequired(String field) {
        try {
            Assertions.assertEquals(registerPage.sendRegisterForm(field), field + " is required.");
            close();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }
}
