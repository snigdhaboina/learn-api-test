import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
    @Test
    void test01(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    void test02(){
        get("https://reqres.in/api/users?page=2").then().statusCode(200);
        given().get("https://reqres.in/api/users?page=2").then().body("data.id[0]", equalTo(7));
    }
}
