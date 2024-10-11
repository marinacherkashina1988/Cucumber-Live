package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

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
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText("admin", usernameField);
        sendText("Hum@nhrm123", passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        click(loginButton);
    }

    @Then("user is navigated to dashboard page")
    public void user_is_navigated_to_dashboard_page() {
        System.out.println("test passed");
    }
}