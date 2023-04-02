package pom.flow01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.baseUrl.UrlConstant;
import steps.Hooks;

import static org.junit.Assert.*;

public class Flow01Logic extends Hooks {

    Flow01Page flow01Page = new Flow01Page();
    private static final Logger log = LogManager.getLogger(Flow01Logic.class);

    public void navigateToGmail() {
        String step = "Navigate to the gmail page";
        log.info(step);

        navigateToUrl(UrlConstant.google);
    }

    public void enterEmail(String email) {
        String step = "Enter the e-mail address " + email;
        log.info(step);

        write(flow01Page.getInputEmail(), email);
        clickElement(flow01Page.getButtonNext());
    }

    public void enterPassword(String password) {
        String step = "Enter the password " + password;
        log.info(step);

        write(flow01Page.getInputPassword(), password);
        clickElement(flow01Page.getButtonNext());
    }

    public void validLogin() {
        String step = "Valid successful login";
        log.info(step);

        assertTrue("The icon is not displayed", elementIsDisplayed(flow01Page.getIcon()));
    }

    public void validPasswordIncorrect() {
        String step = "Valid password is incorrect";
        log.info(step);

        assertTrue("The password is correct", elementIsDisplayed(flow01Page.getMessageIncorrect()));
    }
}
