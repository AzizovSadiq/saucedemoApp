package hooks;

import driverSession.CreateDriverSesion;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class CucumberHooks {
    public static AppiumDriver appiumDriver;

    @Before
    public void beforeScenario() throws MalformedURLException {
       appiumDriver = CreateDriverSesion.getAppiumDriver();
       appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void afterScenario(){
        appiumDriver.quit();
    }
}
