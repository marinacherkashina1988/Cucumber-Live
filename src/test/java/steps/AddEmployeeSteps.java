package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        click(addEmployeeButton);
    }

    @When("user enters firstname and lastname in the fields")
    public void user_enters_firstname_and_lastname_in_the_fields() {
        WebElement firstnameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastnameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        sendText("Clare", firstnameField);
        sendText("Mitchel", lastnameField);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstnameField = driver.findElement(By.id("firstName"));
        WebElement middlenameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        WebElement lastnameField = driver.findElement(By.id("lastName"));
        sendText("Jane", firstnameField);
        sendText("Christina", middlenameField);
        sendText("Doe", lastnameField);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
        click(saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("New employee added successfully");
    }

    @When("user enters {string} and {string} and {string} in the name field")
    public void user_enters_and_and_in_the_name_field(String fn, String mn, String ln) {
        WebElement firstnameField = driver.findElement(By.id("firstName"));
        WebElement middlenameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        WebElement lastnameField = driver.findElement(By.id("lastName"));
        firstnameField.sendKeys(fn);
        middlenameField.sendKeys(mn);
        lastnameField.sendKeys(ln);
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fn, String mn, String ln) {
        WebElement firstnameField = driver.findElement(By.id("firstName"));
        WebElement middlenameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        WebElement lastnameField = driver.findElement(By.id("lastName"));
        firstnameField.sendKeys(fn);
        middlenameField.sendKeys(mn);
        lastnameField.sendKeys(ln);
    }

    @When("user enters employees using data table and saves them")
    public void user_enters_employees_using_data_table_and_saves_them(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map <String, String> employee : employeeNames){
            WebElement firstnameField = driver.findElement(By.id("firstName"));
            WebElement middlenameField = driver.findElement(By.xpath("//input[@id='middleName']"));
            WebElement lastnameField = driver.findElement(By.id("lastName"));

            firstnameField.sendKeys(employee.get("firstname"));
            middlenameField.sendKeys(employee.get("middlename"));
            lastnameField.sendKeys(employee.get("lastname"));

            WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
            click(saveButton);

            WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
            click(addEmployeeButton);
        }
    }

    @When("user adds multiple employees using excel file")
    public void user_adds_multiple_employees_using_excel_file() {
        try {
            List<Map<String, String>> employeeNames = ExcelReader.read();
            for (Map<String, String> employee: employeeNames){
                WebElement firstnameField = driver.findElement(By.id("firstName"));
                WebElement middlenameField = driver.findElement(By.xpath("//input[@id='middleName']"));
                WebElement lastnameField = driver.findElement(By.id("lastName"));

                firstnameField.sendKeys(employee.get("firstname"));
                middlenameField.sendKeys(employee.get("middlename"));
                lastnameField.sendKeys(employee.get("lastname"));

                WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
                click(saveButton);

                WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
                click(addEmployeeButton);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
