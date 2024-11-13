package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

public class APISteps {
    String baseURL = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    RequestSpecification request;
    Response response;
    JsonPath jsPath;
    public static String employee_id;
    public static String token;

    @Given("JWT bearer token is generated")
    public void jwt_bearer_token_is_generated() {

        request = given().header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"main_admin@example.com\",\n" +
                        "  \"password\": \"Pass123\"\n" +
                        "}");
        response = request.when().post("/generateToken.php");
        token = "Bearer " + response.jsonPath().getString("token");
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

    @Given("request to get one employee is prepared")
    public void request_to_get_one_employee_is_prepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        System.out.println(employee_id);
    }

    @When("GET request is called to retrieve an employee")
    public void get_request_is_called_to_retrieve_an_employee() {
        response = request.when().get("/getOneEmployee.php");
        System.out.println(employee_id);
    }

    @Then("the employee id is verified")
    public void the_employee_id_is_verified() {
        String actualID = response.body().jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, actualID);
    //response.then().assertThat().body("employee.employee_id",equalTo(employee_id));
    }

    @Given("request to update employee is prepared")
    public void request_to_update_employee_is_prepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Lili\",\n" +
                        "  \"emp_lastname\": \"Kiri\",\n" +
                        "  \"emp_middle_name\": \"Ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1994-11-11\",\n" +
                        "  \"emp_status\": \"Employeed\",\n" +
                        "  \"emp_job_title\": \"Computer Technician\"\n" +
                        "}");
    }

    @When("PUT request is called to update an employee")
    public void put_request_is_called_to_update_an_employee() {
        response = request.when().put("/updateEmployee.php");
    }

    @Then("Message {string} is displayed")
    public void message_is_displayed(String msg) {
        String currentMsg = response.body().jsonPath().getString("Message");
        Assert.assertEquals(msg, currentMsg);
    }

    @Given("request to partially update an employee is prepared")
    public void requestToPartiallyUpdateAnEmployeeIsPrepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_job_title\": \"Senior Computer Technician\"\n" +
                        "}");
    }

    @When("PATCH request is called to update an employee")
    public void patchRequestIsCalledToUpdateAnEmployee() {
        response = request.when().patch("/updatePartialEmplyeesDetails.php");
    }

    @Then("updated status {string} and Job Title {string} are verified")
    public void updatedStatusAndJobTitleAreVerified(String msg1, String msg2) {
        String currentJobTitle = response.body().jsonPath().getString("employee.emp_job_title");
        Assert.assertEquals(msg2, currentJobTitle);
    }

    @Given("request to delete employee is prepared")
    public void requestToDeleteEmployeeIsPrepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        System.out.println(employee_id + " found");
    }

    @When("DELETE request is called to delete an employee")
    public void deleteRequestIsCalledToDeleteAnEmployee() {
        response = request.when().delete("/deleteEmployee.php");
        System.out.println("Request sent");
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String message) {
        String currentMsg = response.body().jsonPath().getString("message");
        Assert.assertEquals(message, currentMsg);
    }

    @Given("request to retrieve all employees is prepared")
    public void requestToRetrieveAllEmployeesIsPrepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token);
    }

    @When("GET request is called to retrieve all employees")
    public void getRequestIsCalledToRetrieveAllEmployees() {
        response = request.when().get("/getAllEmployees.php");
    }

    @Then("we can access all employee IDs")
    public void weCanAccessAllEmployeeIDs() {
        jsPath = response.jsonPath();
        List<String> employeeIDs = jsPath.get("Employees.employee_id");
        for (String id : employeeIDs) {
            System.out.println(id);
        }
    }

    @Given("request to retrieve job titles is prepared")
    public void requestToRetrieveJobTitlesIsPrepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token);
    }

    @When("GET request is called to retrieved job titles")
    public void getRequestIsCalledToRetrievedJobTitles() {
        response = request.when().get("/jobTitle.php");
    }

    @Then("we can access all job titles")
    public void weCanAccessAllJobTitles() {
        jsPath = response.jsonPath();
        List<String> jobTitles = jsPath.get("Jobs.job");
        for (String jobTitle : jobTitles) {
            System.out.println(jobTitle);
        }
    }

    @Given("request to retrieve employment status is prepared")
    public void requestToRetrieveEmploymentStatusIsPrepared() {
        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token);
    }

    @When("GET request is called to retrieve all employees employment status")
    public void getRequestIsCalledToRetrieveAllEmployeesEmployementStatus() {
        response = request.when().get("/employeementStatus.php");
    }

    @Then("we can access all employees employment status")
    public void weCanAccessAllEmployeesEmploymentStatus() {
        jsPath = response.jsonPath();
        System.out.println(response.getBody().asString());
/*        List<Map<String, Object>> employmentStatus = jsPath.getList("Employeement Status");
        List<String> jobStatus = new ArrayList<>();

        for (Map<String, Object> status : employmentStatus) {
            jobStatus.add((String) status.get("name"));
        }

        for (String status : jobStatus) {
            System.out.println(status);
        }*/
    }
}
