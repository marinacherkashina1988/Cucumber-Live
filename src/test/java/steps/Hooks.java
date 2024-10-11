package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class Hooks extends CommonMethods {

    @Before
    public void start() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void end() {
        closeBrowser();
    }
}
