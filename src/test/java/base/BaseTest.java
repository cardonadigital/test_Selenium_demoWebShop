package base;

import demo.tricentis.demowebshop.pages.homepage.HomePage;
import demo.tricentis.demowebshop.pages.registerpage.RegisterPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepdefinitions.RegisterStepDefinition;


import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static demo.tricentis.demowebshop.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class BaseTest {
    protected static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    public void close(){
        driver.quit();
    }


    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


    public void errorManagement(Exception exception){
        Assertions.fail(exception.getMessage(), exception);
        LOGGER.error(exception.getMessage(), exception);
        close();
    }


}
