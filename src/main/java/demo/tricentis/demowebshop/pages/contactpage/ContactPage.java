package demo.tricentis.demowebshop.pages.contactpage;

import demo.tricentis.demowebshop.common.BasePageActions;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePageActions {
    public ContactPage(WebDriver driver, Integer waitingTime) {
        super(driver, waitingTime);
        initElement(driver, 10);
    }
}
