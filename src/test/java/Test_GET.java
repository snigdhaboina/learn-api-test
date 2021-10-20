import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Test_GET {
    @Test
    void test01() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    void test02() {
        get("https://reqres.in/api/users?page=2").then().statusCode(200);
        given().get("https://reqres.in/api/users?page=2").then()
                .body("data.id[0]", equalTo(7))
                .body("data.first_name", hasItems("Michael", "Lindsay")).log().all();
        // u can also use header after given
        given().header("Content-Type", "application/json").get("https://reqres.in/api/users?page=2").then().statusCode(200);
    }
}
