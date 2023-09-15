import models.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Serialize {

    @Test
    public void usingJson() throws JSONException {
        /*JSONObject jsonData = new JSONObject();
        jsonData.put("userName", "tazo");
        jsonData.put("password", "Tamuna123!!");*/
        User user = new User();
        given()
                .baseUri("https://bookstore.toolsqa.com/Account/v1/User")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(user)
                .when()
                .post()
                .then()
                .log().all();
    }
}
