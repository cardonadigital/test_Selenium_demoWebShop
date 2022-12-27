package stepdefinitions;

import base.BaseTest;
import demo.tricentis.demowebshop.pages.homepage.HomePage;
import demo.tricentis.demowebshop.pages.registerpage.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class LoginStepDefinition extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);
    private static HomePage homePage;
    private static RegisterPage registerPage;

    @Given("que el cliente entre a la pagina web")
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

    }

    @Then("podra ingresar a la cuenta")
    public void podraIngresarALaCuenta() {
    }




    @Given("que el cliente ingrese a la pagina web")
    public void queElClienteIngreseALaPaginaWeb() {
    }

    @When("ingrese los datos que no pertenezcan a ninguna cuenta registrada")
    public void ingreseLosDatosQueNoPertenezcanANingunaCuentaRegistrada() {
    }

    @Then("no podra ingresar a la cuenta")
    public void noPodraIngresarALaCuenta() {
    }



}
