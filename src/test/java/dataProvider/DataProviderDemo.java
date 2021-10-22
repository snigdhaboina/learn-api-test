package dataProvider;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataProviderDemo extends InputDataProviderClass {

    @Test
    @Parameters({"userId"})
        //@Test(dataProvider = "dataToDelete")
    void testDelete(String anUserId) {
        baseURI = "http://localhost:3000";
        when().delete("/users/" + anUserId).then().statusCode(200).log().all();
    }

    @Test(dataProvider = "DataToCreate")
    void testPost(String afirstName, String alastname, String asubjectId, String anId) {

        /*Request Body {{
      "firstName" : "snigdha",
      "lastName" : "boina",
      "subjectId" : "1",
      "id": "1"
    }*/
        baseURI = "http://localhost:3000/";

        JSONObject req = new JSONObject();
        req.put("firstName", afirstName);
        req.put("lastName", alastname);
        req.put("subjectId", asubjectId);
        req.put("id", anId);

        given().header("Content-Type", "application/Json")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(req.toString()).when().post("/users").then().statusCode(201).log().all();
    }
}
