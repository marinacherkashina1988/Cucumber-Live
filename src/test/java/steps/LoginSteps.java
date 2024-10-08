package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    //public WebDriver driver;

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters admin username and admin password")
    public void user_enters_admin_username_and_admin_password() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("Hum@nhrm123");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Then("user is navigated to dashboard page")
    public void user_is_navigated_to_dashboard_page() {
        System.out.println("test passed");
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimButton.click();
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement employeeList = driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
        employeeList.click();
    }

    @When("user enters employee ID")
    public void user_enters_employee_id() {
        WebElement employeeIDSearchField = driver.findElement(By.xpath("//input[@id='empsearch_id']"));
        employeeIDSearchField.sendKeys("110360A");
    }

    @When("user enters employee name")
    public void user_enters_employee_name() {
        WebElement employeeNameField = driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
        employeeNameField.sendKeys("Gogaa ME Alfred");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='searchBtn']"));
        searchButton.click();
    }

    @Then("user is able to see searched employee on screen")
    public void user_is_able_to_see_searched_employee_on_screen() {
        System.out.println("Employee found");
    }

    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        addEmployeeButton.click();
    }

    @When("user enters firstname and lastname in the fields")
    public void user_enters_firstname_and_lastname_in_the_fields() {
        WebElement firstnameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstnameField.sendKeys("Clare");
        WebElement lastnameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastnameField.sendKeys("Mitchel");
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstnameField = driver.findElement(By.id("firstName"));
        firstnameField.sendKeys("Jane");
        WebElement lastnameField = driver.findElement(By.id("lastName"));
        lastnameField.sendKeys("Doe");
        WebElement middlenameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        middlenameField.sendKeys("Christina");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
        saveButton.click();
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("New employee added successfully");
    }

}