package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimButton);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement employeeList = driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
        click(employeeList);
    }

    @When("user enters employee ID")
    public void user_enters_employee_id() {
        WebElement employeeIDSearchField = driver.findElement(By.xpath("//input[@id='empsearch_id']"));
        sendText("110360A", employeeIDSearchField);
    }

    @When("user enters employee name")
    public void user_enters_employee_name() {
        WebElement employeeNameField = driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']"));
        sendText("Gogaa ME Alfred",employeeNameField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='searchBtn']"));
        click(searchButton);
    }

    @Then("user is able to see searched employee on screen")
    public void user_is_able_to_see_searched_employee_on_screen() {
        System.out.println("Employee found");
    }
}
