import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_POST {

    @Test
    void test01(){

        /*Request Body {
            "name": "morpheus",
                    "job": "leader"
        }*/

        JSONObject req = new JSONObject();
        req.put("name", "SnigdhaBoina");
        req.put("job", "Automation/QA Engineer");

        given().header("Content-Type","application/Json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                //Any of above 3 headers r same
                .body(req.toString()).when().put("https://reqres.in/api/users").then().statusCode(200).log().all();
    }
}
