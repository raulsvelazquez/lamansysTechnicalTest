package pom.flow02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.baseUrl.UrlConstant;
import steps.Hooks;

public class Flow02Logic extends Hooks {

    Flow02Page flow02Page = new Flow02Page();
    private static final Logger log = LogManager.getLogger(Flow02Logic.class);

    public void navigateToEbay() {
        String step = "Navigate to the ebay page";
        log.info(step);

        navigateToUrl(UrlConstant.ebay);
    }

    public void searchProduct() {
        String step = "Looking for an electric guitar";
        log.info(step);

        write(flow02Page.getInputSearch(), "guitarra electrica");
        clickElement(flow02Page.getButtonSearch());
    }

    public void priceElectricGuitar() {
        String step = "I print the price of the electric guitar by console";
        log.info(step);

        String price = textFromElement(flow02Page.getPrice());

        System.out.println("======> The price of the first guitar is: " + price);
    }

}
