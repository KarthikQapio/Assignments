
package com.Qapitol.RestAssured.testcases;

import com.Qapitol.RestAssured.endpoints.UserEndpoints;
import com.Qapitol.RestAssured.utility.ExtentReportListener;
import com.github.javafaker.Faker;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserTest {

    private final String baseUrl = "https://petstore.swagger.io/v2";
    private Faker faker;

    @BeforeSuite
    public void setup() {
        ExtentReportListener.setupReport();
        faker = new Faker();
    }

    @AfterSuite
    public void tearDown() {
        ExtentReportListener.flushReport();
    }

    @Test
    public void testCreatePet() {
        ExtentTest test = ExtentReportListener.createTest("Create Pet Test");
        test.info("Starting Create Pet Test");

        // Use Faker to generate random data for pet
        int petId = faker.number().randomDigitNotZero();
        String petName = faker.name().firstName();
        String petStatus = faker.random().nextBoolean() ? "available" : "sold"; // Random status

        JSONObject payload = new JSONObject();
        payload.put("id", petId);
        payload.put("name", petName);
        payload.put("status", petStatus);

        test.info("Payload for creating pet: " + payload.toString());
        Response response = UserEndpoints.createPet(payload);

        test.info("Response: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());

        if (response.getStatusCode() == 200) {
            test.pass("Create Pet Test Passed");
        } else {
            test.fail("Create Pet Test Failed");
        }

        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testUpdatePet() {
        ExtentTest test = ExtentReportListener.createTest("Update Pet Test");
        test.info("Starting Update Pet Test...");
        int petId = faker.number().randomDigitNotZero();
        String petName = faker.name().firstName();
        String petStatus = faker.random().nextBoolean() ? "sold" : "available";

        JSONObject payload = new JSONObject();
        payload.put("id", petId);
        payload.put("name", petName);
        payload.put("status", petStatus);

        test.info("Payload for updating pet: " + payload.toString());
        Response response = UserEndpoints.updatePet(payload);

        test.info("Response: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());

        if (response.getStatusCode() == 200) {
            test.pass("Update Pet Test Passed");
        } else {
            test.fail("Update Pet Test Failed");
        }

        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testDeletePet() {
        ExtentTest test = ExtentReportListener.createTest("Delete Pet Test");
        test.info("Starting Delete Pet Test...");
        int petId = faker.number().randomDigitNotZero();
        Response response = UserEndpoints.deletePet(petId);

        test.info("Response: " + response.getBody().asString());
        test.info("Status Code: " + response.getStatusCode());

        if (response.getStatusCode() == 200) {
            test.pass("Delete Pet Test Passed");
        } else {
            test.fail("Delete Pet Test Failed");
        }

        assertEquals(response.getStatusCode(), 200);
    }
}
