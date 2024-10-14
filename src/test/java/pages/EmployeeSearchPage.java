package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.EmployeeSearchSteps;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "empsearch_id")
    public WebElement employeeIDSearchField;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement employeeNameField;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;
}
