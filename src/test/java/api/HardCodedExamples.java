package api;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURL = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String employee_id;
    public static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MzE1MDY5MzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTczMTU1MDEzMiwidXNlcklkIjoiNjk3OSJ9.my1YYJtowlA53h10sCTGvjD4Bu2hEwy8XtXVMi7y0Ws";

    @Test
    public void A_createEmployee() {
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Ayush\",\n" +
                        "  \"emp_lastname\": \"Patel\",\n" +
                        "  \"emp_middle_name\": \"Mr\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-11-05\",\n" +
                        "  \"emp_status\": \"Intern\",\n" +
                        "  \"emp_job_title\": \"Software Engineer \"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        response.then().
                assertThat().statusCode(201).
                assertThat().body("Message", equalTo("Employee Created")).
                assertThat().body("Employee.emp_firstname", equalTo("Ayush"));

        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println("The employee id is " + employee_id);
    }

    @Test
    public void B_getEmployee() {
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);

    }

    @Test
    public void C_updateEmployee(){
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Ayush\",\n" +
                        "  \"emp_lastname\": \"Patel\",\n" +
                        "  \"emp_middle_name\": \"Mr\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2004-11-05\",\n" +
                        "  \"emp_status\": \"employeed\",\n" +
                        "  \"emp_job_title\": \"Software Engineer \"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void D_getUpdatedEmployee() {
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);
    }

    @Test
    public void E_partiallyUpdateEmployee(){
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_job_title\": \"Senior Software Engineer\"\n" +
                        "}");

        Response response = request.when().patch("/updatePartialEmplyeesDetails.php");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void F_deleteEmployee(){
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().delete("/deleteEmployee.php");
        response.then().statusCode(200);
        response.then().body("message", equalTo("Employee deleted"));
    }

    @Test
    public void G_getAllEmployee(){

        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token);

        Response response = request.when().get("/getAllEmployees.php");
        response.then().statusCode(200);

        JsonPath jsPath = response.jsonPath();

        String singleName = jsPath.get("Employees.emp_firstname[1]");
        System.out.println(singleName);

        List<String> fName = jsPath.get("Employees.emp_firstname");
        for (String name: fName){
            System.out.println(name);
        }
    }

    @Test
    public void H_getTitle(){
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token);

        Response response = request.when().get("/jobTitle.php");
        response.then().statusCode(200);
    }

    @Test
    public void I_getStatus(){
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token);

        Response response = request.when().get("/employeementStatus.php");
        response.then().statusCode(200);
    }

}
