package hook;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Hook {
    private WebDriver driver;

    @Before
    public void before(){
        driver = DriverFactory.initializeDriver();
    }

    @After
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }

}
