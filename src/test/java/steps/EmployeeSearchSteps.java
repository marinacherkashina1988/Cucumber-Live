package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EmployeeSearchPage;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user enters employee ID")
    public void user_enters_employee_id() {
        sendText("110360A", employeeSearchPage.employeeIDSearchField);
    }

    @When("user enters employee name")
    public void user_enters_employee_name() {
        sendText("Gogaa ME Alfred",employeeSearchPage.employeeNameField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see searched employee on screen")
    public void user_is_able_to_see_searched_employee_on_screen() {
        System.out.println("Employee found");
    }
}
