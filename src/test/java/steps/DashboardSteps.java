package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class DashboardSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimButton);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        click(dashboardPage.employeeList);
    }


}
