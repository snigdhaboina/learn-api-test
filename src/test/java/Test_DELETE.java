import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Test_DELETE {

    @Test
    void test01(){
        when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
    }
}
