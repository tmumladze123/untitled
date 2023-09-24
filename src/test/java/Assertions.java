import models.Pet;
import org.assertj.core.api.Java6Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Assertions {

    @Test //Single JSON Object , hamcrest
    public void assertSpecificValue() {
        given().baseUri("https://petstore.swagger.io/v2/pet/112233")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .body("id", equalTo(112233));
    }

    @Test //Assert response after extraction and deserialization
    public void assertAfterExtracting() {
        Pet pet = given().baseUri("https://petstore.swagger.io/v2/pet/112233")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .as(Pet.class);
        assertThat(pet.getId(), equalTo(112233L));
    }

    @Test /*(dependsOnMethods = {"assertAfterExtracting"})*/ //Assert Array
    public void usageWithArray() {
        given().baseUri("https://petstore.swagger.io/v2/pet/findByStatus")
                .header("accept", "application/json")
                .queryParam("status", "happy123")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0));
    }
    @Test /*(dependsOnMethods = {"assertAfterExtracting"})*/ //Assert Array
    public void usageWithArrayAssertj() {
        Pet pet = given().baseUri("https://petstore.swagger.io/v2/pet/112233")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .as(Pet.class);
        Java6Assertions.assertThat(pet.getName()).endsWith("n");
    }

}
