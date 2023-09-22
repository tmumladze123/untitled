import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredLesson1 {

    @Test
    public void test() {
        Response response = given().baseUri("https://back.expressgroup.ge/api/Dashboard/products")
                .header("Authorization","Bearer 14461|0Ndp4COwalZ0f2kUng0xkeD8VdVKTCC4ksDKofB8")
                .when()
                .delete()
                .then().extract().response();
        Assert.assertEquals(response.statusCode(),403);
    }
}
