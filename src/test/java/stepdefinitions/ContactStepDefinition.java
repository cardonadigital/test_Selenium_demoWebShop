package stepdefinitions;

import base.BaseTest;
import demo.tricentis.demowebshop.pages.contactpage.ContactPage;
import demo.tricentis.demowebshop.pages.homepage.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ContactStepDefinition extends BaseTest {
    private static HomePage homePage;
    private static ContactPage contactPage;

    @Given("que el cliente entre al modulo de contactenos")
    public void queElClienteEntreAlModuloDeContactenos() {
        try {
            setUp();
            setUpLog4j2();
            homePage = new HomePage(driver, 10);
            contactPage = homePage.clickContact();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @When("ingrese los datos correctos en los campos solicitados")
    public void ingreseLosDatosCorrectosEnLosCamposSolicitados() {
        try {
            contactPage.fillData();
            contactPage.clickSubmit();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @Then("podra enviar el mensaje exitosamente")
    public void podraEnviarElMensajeExitosamente() {
        try {
            Assertions.assertEquals(contactPage.messageSent(), "Your enquiry has been successfully sent to the store owner.");
            close();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }



    @Given("que el cliente ingrese al modulo de contactenos")
    public void queElClienteIngreseAlModuloDeContactenos() {
        try {
            setUp();
            setUpLog4j2();
            homePage = new HomePage(driver, 10);
            contactPage = homePage.clickContact();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @When("no ingrese el nombre")
    public void noIngreseElNombre() {
        try {
            contactPage.clickSubmit();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }

    @Then("el sistema debera mostrar el siguiente mensaje {string}")
    public void elSistemaDeberaMostrarElSiguienteMensaje(String message) {
        try {
            Assertions.assertEquals(contactPage.messageField(), message);
            close();
        }catch (Exception exception) {
            errorManagement(exception);
        }
    }
}
