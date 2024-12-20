package com.reqres.api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ReqresSteps {

    private int userId;
    private Response response;
    private String baseURI = "https://reqres.in";

    @Given("I have a user ID")
    public void i_have_a_user_id() {
        userId = 2;
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        RestAssured.baseURI = baseURI;
        response = given()
                .pathParam("id", userId)
                .when()
                .get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain the user data")
    public void the_response_should_contain_the_user_data() {
        response.then().body("data.id", equalTo(userId))
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue());
    }

    @Given("I have a payload for creating a user")
    public void i_have_a_payload_for_creating_a_user() {
        RestAssured.baseURI = baseURI;
    }

    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        String payload = "{ \"name\": \"John\", \"job\": \"leader\" }";

        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint);
    }

    @Then("the response should contain the user details")
    public void the_response_should_contain_the_user_details() {
        response.then()
                .body("name", equalTo("John"))
                .body("job", equalTo("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }
}
