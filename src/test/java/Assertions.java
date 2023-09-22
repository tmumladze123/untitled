import models.Pet;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Assertions {

    Pet pet ;
    @Test //Single JSON Object , hamcrest
    public void assertSpecificValue() {
        given().baseUri("https://petstore.swagger.io/v2/pet/12345")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .body("id", equalTo("12345"));
    }

    @Test //Assert response after extraction and deserialization
    public void assertAfterExtracting() {
        Pet pet = given().baseUri("https://petstore.swagger.io/v2/pet/12345")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .as(Pet.class);
        assertThat(pet.getId(), equalTo(12345));
    }

    @Test /*(dependsOnMethods = {"assertAfterExtracting"})*/ //Assert Array
    public void usageWithArray() {
        given().baseUri("https://petstore.swagger.io/v2/pet/findByStatus")
                .header("accept", "application/json")
                .queryParam("status","happy")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .body("size()",is(1));
    }

}
