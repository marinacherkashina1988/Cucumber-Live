package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.ExcelReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters admin username and admin password")
    public void user_enters_admin_username_and_admin_password() {
        sendText(ConfigReader.read("userName"), loginPage.userNameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @Then("user is navigated to dashboard page")
    public void user_is_navigated_to_dashboard_page() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
        System.out.println("test passed");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(ConfigReader.read("userName"), loginPage.userNameField);
        passwordField.sendKeys("Hum@nhrm12234563");
    }

    @Then("user can see error message")
    public void user_can_see_error_message() {
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials!", actualErrorMessage);
    }
}