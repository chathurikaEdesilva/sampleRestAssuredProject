//Author: Chathurika De Silva

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.response.Response;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;

public class SampleAPITest {
    Response response;
    Logger LOGGER = Logger.getLogger(SampleAPITest.class.getName());

    //This before test method is used to call the API endpoint and assign the response to a variable of type Response
    @BeforeTest
    public void callEndpoint() {
        try {
            LOGGER.log(Level.INFO, "Invoking API endpoint");
            response = given()
                    .when()
                    .get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false")
                    .then().statusCode(200).extract().response();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occured" + "--" + e.getMessage(), e);
        }
    }

    //This test method is used to verify whether the json payload's Name element consists of string "Carbon credits"
    @Test(description = "Retrieve and assert Name")
    public void testNameElement() {
        LOGGER.log(Level.INFO, "Executing test method - testNameElement");
        Assert.assertEquals(response.jsonPath().get("Name"), "Carbon credits");
    }

    //This test method is used to verify whether the json payload's CanRelist element consists of string "true"
    @Test(description = "Retrieve and assert CanRelist")
    public void testCanRelistElement() {
        LOGGER.log(Level.INFO, "Executing test method - testCanRelistElement");
        Assert.assertTrue(response.jsonPath().get("CanRelist"), "true");
    }

    //This test method is used to verify whether the Promotions array's objects consists of an element named Gallery
    //and thereafter checks the description element to consist string "Good position in category"
    @Test(description = "Retrieve and assert description of Gallery promotion item")
    public void testPromotionsForString() {
        LOGGER.log(Level.INFO, "Executing test method - testPromotionsForString");
        JsonPath jsonPathEval = response.jsonPath();
        int sizeofPromotions = jsonPathEval.getInt("Promotions.size()");
        for (int i = 0; i < sizeofPromotions; i++) {
            Map<String, String> promotions = jsonPathEval.getMap("Promotions[" + i + "]");
            String val1 = promotions.get("Name");
            if (val1.equalsIgnoreCase("Gallery")) {
                Assert.assertEquals(promotions.get("Description"), "Good position in category");
            }

        }
    }

}
