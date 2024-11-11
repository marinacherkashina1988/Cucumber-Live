package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
public class APISteps {
    String baseURL = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    RequestSpecification request;
    Response response;
    public static String employee_id;
    public static String token;

    @Given("JWT bearer token is generated")
    public void jwt_bearer_token_is_generated() {

        request = given().header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"admin_main@example.com\",\n" +
                        "  \"password\": \"Pass123\"\n"+
                        "}");
        response = request.when().post("/generateToken.php");
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);
    }
    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Siri\",\n" +
                        "  \"emp_lastname\": \"GlooGloo\",\n" +
                        "  \"emp_middle_name\": \"Ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-11-11\",\n" +
                        "  \"emp_status\": \"Intern\",\n" +
                        "  \"emp_job_title\": \"Data Analyst\"\n" +
                        "}");
        System.out.println(token);
    }
    @When("POST call is made to create an employee")
    public void post_call_is_made_to_create_an_employee() {
        response = request.when().post("/createEmployee.php");
    }
    @Then("status code is {int}")
    public void statusCodeIs(int code) {
        response.then().assertThat().statusCode(code);

    }
    @Then("the employee id {string} is stored and value is validated")
    public void the_employee_id_is_stored_and_value_is_validated(String empPath) {
        employee_id = response.jsonPath().getString(empPath);
        System.out.println("The employee id is " + employee_id);
    }


}
