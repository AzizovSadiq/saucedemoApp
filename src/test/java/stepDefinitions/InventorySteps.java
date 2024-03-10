package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.InventoryPom;

import java.util.List;

public class InventorySteps extends BaseMethods {
    InventoryPom inventoryPom;
    {
        inventoryPom = InventoryPom.getInstance();
    }

    @Given("User is in sauce demo home page")
    public void userIsInSauceDemoHomePage() {

    }

    @When("User clicks {string} item")
    public void userClicksItem(String itemText) {
      scrollToElementText(itemText);
      // iki usulla  elemente scroll edib clickleyirik

      //1

      findElementByText(itemText).click();

      //2

//      List<WebElement> elements =  getElements(inventoryPom.getInventoryElementText());
//      for (WebElement element : elements){
//          if (element.getText().equals(itemText)){
//              element.click();
//          }
//      }

    }


    @When("Click on the product's {string} star")
    public void clickOnTheProductSStar(Integer number) throws InterruptedException {
        Thread.sleep(3000);
        getElement(inventoryPom.getStarProduct()).click();

    }

    @Then("Pop-up window appears on the screen")
    public void popUpWindowAppearsOnTheScreen() {

    }

    @Then("Product description appears")
    public void productDescriptionAppears() {
        scrollToElementText("Product Highlights");
        Assert.assertTrue(getElement(inventoryPom.getProductDescription()).isDisplayed());

    }
}
