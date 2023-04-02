package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.flow01.Flow01Logic;

public class Flow01Steps {

    Flow01Logic flow01Logic = new Flow01Logic();

    @Given("Navigate to the gmail page")
    public void navigateToTheGmailPage() {
        flow01Logic.navigateToGmail();
    }

    @When("Enter the e-mail address {string}")
    public void enterTheEMailAddress(String email) {
        flow01Logic.enterEmail(email);
    }

    @And("Enter the password {string}")
    public void enterThePassword(String password) {
        flow01Logic.enterPassword(password);
    }

    @Then("Valid successful login")
    public void validSuccessfulLogin() {
        flow01Logic.validLogin();
    }

    @Then("Valid password is incorrect")
    public void validPasswordIsIncorrect() {
        flow01Logic.validPasswordIncorrect();
    }

}
