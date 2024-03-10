package stepDefinitions;

import com.google.common.collect.ImmutableMap;
import hooks.CucumberHooks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class BaseMethods {

    public AppiumDriver driver = CucumberHooks.appiumDriver;

    protected WebElement getElement(By locator){return driver.findElement(locator);}
    protected List<WebElement> getElements(By locator){return driver.findElements(locator);}

    protected WebElement findElementByText(String text){
        return driver.findElement(By.xpath("//*[@text = '"+text+"']"));
    }

    protected void longClickGesture(By locator){
        ((JavascriptExecutor)driver).executeScript("mobile: LongClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)getElement(locator))));
    }

    protected void clickGesture(By locator){
        ((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)getElement(locator))
        ));
    }
    protected void clickKeyboardAction(String action){
        ((JavascriptExecutor)driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action",action));

    }
//    protected void scrollToElementText(String element){
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"element\"));"));
//
//    }
    protected void scrollToElementText(String elementText){
        String uiSelector = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));";
        driver.findElement(AppiumBy.androidUIAutomator(uiSelector));
    }

    protected WebElement clickStar(int number) {
        String xpath = "(//android.widget.TextView[@text=\"\uDB81\uDCCF\"])[" + number + "]";
       return driver.findElement(By.xpath(xpath));
    }
    public int generateRandomNum(int size){
        return (int) (Math.random()*size);
    }

}
