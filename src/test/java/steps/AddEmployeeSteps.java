package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user enters firstname and lastname in the fields")
    public void user_enters_firstname_and_lastname_in_the_fields() {
        sendText("Clare", addEmployeePage.firstnameField);
        sendText("Mitchel", addEmployeePage.lastnameField);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        sendText("Jane", addEmployeePage.firstnameField);
        sendText("Christina", addEmployeePage.middlenameField);
        sendText("Doe", addEmployeePage.lastnameField);
    }

    @When("user enters {string} and {string} and {string} in the name field")
    public void user_enters_and_and_in_the_name_field(String fn, String mn, String ln) {
        sendText(fn, addEmployeePage.firstnameField);
        sendText(mn, addEmployeePage.middlenameField);
        sendText(ln, addEmployeePage.lastnameField);
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fn, String mn, String ln) {
        sendText(fn, addEmployeePage.firstnameField);
        sendText(mn, addEmployeePage.middlenameField);
        sendText(ln, addEmployeePage.lastnameField);
    }

    @When("user enters employees using data table and saves them")
    public void user_enters_employees_using_data_table_and_saves_them(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map <String, String> employee : employeeNames){
            sendText(employee.get("firstname"), addEmployeePage.firstnameField);
            sendText(employee.get("middlename"), addEmployeePage.middlenameField);
            sendText(employee.get("lastname"), addEmployeePage.lastnameField);
            click(addEmployeePage.saveButton);
            click(addEmployeePage.addEmployeeButton);
        }
    }

    @When("user adds multiple employees using excel file")
    public void user_adds_multiple_employees_using_excel_file() {
        try {
            List<Map<String, String>> employeeNames = ExcelReader.read();
            for (Map<String, String> employee: employeeNames){
                sendText(employee.get("firstname"), addEmployeePage.firstnameField);
                sendText(employee.get("middlename"), addEmployeePage.middlenameField);
                sendText(employee.get("lastname"), addEmployeePage.lastnameField);
                click(addEmployeePage.saveButton);
                click(addEmployeePage.addEmployeeButton);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        click(addEmployeePage.addEmployeeButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("New employee added successfully");
    }
}
