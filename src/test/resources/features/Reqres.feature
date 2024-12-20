Feature: Reqres API Testing

  Scenario: Create a new user
    Given I have a payload for creating a user
    When I send a POST request to "/api/users"
    Then the response status code should be 201
    And the response should contain the user details

  Scenario: Get a user by ID
    Given I have a user ID
    When I send a GET request to "/api/users/{id}"
    Then the response status code should be 200
    And the response should contain the user data
