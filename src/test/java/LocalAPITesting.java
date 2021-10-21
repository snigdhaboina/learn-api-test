import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LocalAPITesting {

    /*Resources
    http://localhost:3000/posts
    http://localhost:3000/comments
    http://localhost:3000/profile

    Home
    http://localhost:3000*/

    @Test
    void testPost(){

        /*Request Body {{
      "firstName" : "snigdha",
      "lastName" : "boina",
      "subjectId" : "1",
      "id": "1"
    }*/
        baseURI = "http://localhost:3000/";

        JSONObject req = new JSONObject();
        req.put("firstName", "Snigdha");
        req.put("lastName", "Boina");
        req.put("subjectId", "1");
        req.put("id", "4");

        given().header("Content-Type","application/Json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(req.toString()).when().post("/users").then().statusCode(201).log().all();
    }

    @Test
    void testGET() {
        baseURI = "http://localhost:3000/";
        when().get("/users").then().statusCode(200).log().all();
    }

    @Test
    void testPATCH(){

        /*Request Body {{
      "firstName" : "snigdha",
      "lastName" : "boina",
      "subjectId" : "1",
      "id": "1"
    }*/

        baseURI = "http://localhost:3000/";
        JSONObject req = new JSONObject();
        req.put("lastName", "BUDIGAM");

        given().header("Content-Type","application/Json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(req.toString()).when().patch("/users/4").then().statusCode(200).log().all();
    }

    @Test
    void testDELETE(){
        baseURI = "http://localhost:3000/";
        when().delete("/users/4").then().statusCode(200).log().all();
    }
}
