import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import org.apache.http.client.methods.RequestBuilder;
import org.assertj.core.api.Java6Assertions;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Specifications  extends  BaseRequest{
    RequestSpecification requestSpecification = RestAssured
            .given()
            .baseUri("https://petstore.swagger.io/v2/pet")
            .header("accept", "application/json");
    @Test //Single JSON Object , hamcrest
    public void assertSpecificValue() {
        get(requestSpecification,"112233")
                .then()
                .assertThat()
                .body("id", equalTo(112233));
    }

    @Test //Assert response after extraction and deserialization
    public void assertAfterExtracting() {
        Pet pet = get(requestSpecification, "112233").as(Pet.class);
        assertThat(pet.getId(), equalTo(112233L));
    }

    @Test //Assert Array
    public void usageWithArray() {
        get(requestSpecification,"findByStatus")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(0));
    }

    @Test  //Assert Array
    public void usageWithArrayAssertj() throws JsonProcessingException {
        Pet pet = requestSpecification
                .when()
                .get("112233")
                .then()
                .log()
                .all()
                .extract()
                .as(Pet.class);
        Java6Assertions.assertThat(pet.getName()).endsWith("n");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println( objectMapper.writeValueAsString(pet));
    }
}
