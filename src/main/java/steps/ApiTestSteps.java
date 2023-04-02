package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pom.baseUrl.UrlConstant;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiTestSteps {

    Response response;
    RequestSpecification reqSpec;

    @Given("I want to see all comments")
    public void iWantToSeeAllComments() {
        reqSpec = new RequestSpecBuilder().
                setBaseUri(UrlConstant.url + "1/comments").
                setContentType(ContentType.JSON).
                build();
    }

    @Then("Valid status code {int}")
    public void validStatusCode(int statusCode) {
        response = given()
                .spec(reqSpec)
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .response();

        assertEquals(statusCode, response.getStatusCode());
    }

    @Given("I want to update the title")
    public void iWantToUpdateTheTitle() {
        reqSpec = new RequestSpecBuilder().
                setBaseUri(UrlConstant.url + "1").
                setContentType(ContentType.JSON).
                build();
    }

    @Then("Valid that the title was modified")
    public void validThatTheTitleWasModified() {

        String json = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";

        response = given()
                .spec(reqSpec)
                .body(json)
                .when()
                .put()
                .then()
                .log()
                .all()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode());
    }
}
