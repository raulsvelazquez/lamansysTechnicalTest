package pom.flow02;

import lombok.Getter;

@Getter
public class Flow02Page {

    private final String inputSearch = "//input[@class='gh-tb ui-autocomplete-input']";
    private final String buttonSearch = "//input[@type='submit']";
    private final String price = "(//span[@class='s-item__price'])[2]";

}
