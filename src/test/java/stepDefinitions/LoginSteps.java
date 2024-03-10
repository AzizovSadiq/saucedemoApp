package stepDefinitions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.LoginPom;

import java.time.Duration;


public class LoginSteps extends BaseMethods{
    LoginPom loginPom;
    {
        loginPom = LoginPom.getInstance();
    }


    @Given("User is in saucedemo app")
    public void userIsInSaucedemoApp() {

    }

    @When("User clicks burger menu button")
    public void userClicksBurgerMenuButton() {
        getElement(loginPom.getBurgermenu()).click();
    }

    @And("Clicks login button in dropdown")
    public void clicksLoginButtonInDropdown() {
        //bir nece variantda clicklemek olar

        //1
       // findElementByText("Log In").click();
        // ve ya ashagidaki kimi

        //2
        //clickGesture(By.xpath("//*[@text = 'Log In']"));

        // veya action ile ashagidaki kimi
        //3
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementByText("Log In")).click().perform();
    }


    @And("Fills username input with {string}")
    public void fillsUsernameInputWith(String userName) {
        //bir nece variant var
        //1
        //getElement(loginPom.getUserNameInput()).sendKeys(userName);

        // veya
        //2
        getElement(loginPom.getUserNameInput()).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(userName).perform();
    }

    @And("Fills password input  with {string}")
    public void fillsPasswordInputWith(String password) {
        //bir nece variant var
        //1
        //getElement(loginPom.getPasswordInput()).sendKeys(password);

        // veya
        //2
        getElement(loginPom.getPasswordInput()).click();
        Actions action = new Actions(driver);
        action.sendKeys(password).perform();
        // bu halda keyboard baglamaq ucun ashagidakini etmeliyik
        clickKeyboardAction("Go");

    }

    @And("Clicks login button")
    public void clicksLoginButton() {
       getElement(loginPom.getLoginBtn()).click();
    }

    @Then("User should be navigated to homepage")
    public void userShouldBeNavigatedToHomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPom.getProductImage()));
        Assert.assertTrue(getElement(loginPom.getProductImage()).isDisplayed());
    }


    @Then("{string} message appears on the screen")
    public void messageAppearsOnTheScreen(String expectedErrorText) {
      //String actualErrorText1 = getElement(loginPom.getErrorMesage()).getText(); // bunu yoxlaya bilmedim
      String actualErrorText2 = getElement(loginPom.getErrormesage2()).getText();
      Assert.assertEquals(actualErrorText2,expectedErrorText);
    }



}
