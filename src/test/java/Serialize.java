
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import models.CreateUserSuccess;
import models.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Serialize {

    @Test
    public void usingJson() throws JsonProcessingException {
        User user = new User();
        user.setUserName("Random123");
        user.setPassword("Password123!!");
        user.setAge("Aa`1scd");
        ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));
        Response response = given()
                .baseUri("https://bookstore.toolsqa.com/Account/v1/User")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post()
                .then()
                .extract().response();
        CreateUserSuccess createUserSuccess = response.as(CreateUserSuccess.class);
        System.out.println(createUserSuccess.getUserID());
        System.out.println(createUserSuccess.getUsername());
    }
}
