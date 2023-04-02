package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.flow02.Flow02Logic;

public class Flow02Steps {

    Flow02Logic flow02Logic = new Flow02Logic();

    @Given("Navigate to the ebay page")
    public void navigateToTheEbayPage() {
        flow02Logic.navigateToEbay();
    }

    @When("Looking for an electric guitar")
    public void lookingForAnElectricGuitar() {
        flow02Logic.searchProduct();
    }

    @Then("I print the price of the electric guitar by console")
    public void iPrintThePriceOfTheElectricGuitarByConsole() {
        flow02Logic.priceElectricGuitar();
    }
}
