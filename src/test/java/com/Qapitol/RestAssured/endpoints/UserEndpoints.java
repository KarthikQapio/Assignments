package com.Qapitol.RestAssured.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class UserEndpoints {
    static {
        RestAssured.baseURI = Routes.BASE_URL;
    }
    public static Response createPet(JSONObject payload) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .post(Routes.CREATE_PET);
    }
    public static Response updatePet(JSONObject payload) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .put(Routes.UPDATE_PET);
    }
    public static Response deletePet(int petId) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .pathParam("petId", petId)  // Use path parameter for petId
                .when()
                .delete(Routes.DELETE_PET);
    }
}
