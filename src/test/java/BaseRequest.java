import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    public Response get(RequestSpecification spec, String path){
        return spec.when()
                .get(path)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}