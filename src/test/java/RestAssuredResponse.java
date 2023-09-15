import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredResponse {

    @Test
    public void usingJson() throws JSONException {
        JSONObject jsonData = new JSONObject();
        jsonData.put("userName", "tazo");
        jsonData.put("password", "Tamuna123!!");

        given()
                .baseUri("https://bookstore.toolsqa.com/Account/v1/User")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(jsonData.toString())
                .when()
                .post()
                .then()
                .log().all();
    }
    @Test
    public void coockies() {
        given()
                .baseUri("https://wizzair.com/fijZd0RiOQLfH/Ub/HJOHMXUkshPU/iwiXzkV8phOG/W3lIdCkmegE/PU0Pf/i99NQ4B")
                .when()
                .post()
                .then()
                .log().cookies();
    }
    @Test
    public void responses() throws JSONException {
        JSONObject jsonData = new JSONObject();
        jsonData.put("userName", "tazo");
        jsonData.put("password", "Tamuna123!!");
        Response response = given()
                .baseUri("https://bookstore.toolsqa.com/Account/v1/User")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(jsonData.toString())
                .when()
                .post()
                .then()
                .extract().response();
        System.out.println(response.asString());
        System.out.println(response.path("code").toString());
        System.out.println(response.path("message").toString());
        System.out.println(response.jsonPath().getString("code").toString());
        System.out.println(response.jsonPath().getString("message").toString());

    }

}
