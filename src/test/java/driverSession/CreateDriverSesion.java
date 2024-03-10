package driverSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSesion {
    public static AndroidDriver getAppiumDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app","C:/Users/Aydin/Downloads/saucedemo.apk");
        //capabilities.setCapability("deviceName","Pixel 2");
        //capabilities.setCapability("appPackage","com.saucelabs.mydemoapp.rn");
        //capabilities.setCapability("appActivity","MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");

        return new AndroidDriver(url, capabilities );
    }
}
