import models.Pet;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class Assertions2 {
    @Test /*(dependsOnMethods = {"assertAfterExtracting"})*/ //Assert Array
    public void usageWithArrayAssertj() {
        Pet pet = given().baseUri("https://petstore.swagger.io/v2/pet/12345")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .as(Pet.class);
        assertThat(pet.getName()).endsWith("2");
    }
}
