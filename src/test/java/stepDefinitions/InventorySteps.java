package stepDefinitions;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
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
        System.out.println(itemText);
      //2

//      List<WebElement> elements =  getElements(inventoryPom.getInventoryElementText());
//      for (WebElement element : elements){
//          if (element.getText().equals(itemText)){
//              element.click();
//          }
//      }

    }

    @And("Click on the product's random star")
    public void clickOnTheProductSRandomStar() {

        //scrollToElementText(getElement(inventoryPom.getDescriptionText()).getText());
        System.out.println(getElement(inventoryPom.getProductDescription()).getText());
        getElement(inventoryPom.getStarProduct()).click();
    }


    @Then("Pop-up window appears on the screen")
    public void popUpWindowAppearsOnTheScreen() {
        Assert.assertTrue(getElement(inventoryPom.getStarText()).isDisplayed());

    }

    @Then("Product description appears")
    public void productDescriptionAppears() {
        scrollToElementText("Product Highlights");
        Assert.assertTrue(getElement(inventoryPom.getProductDescription()).isDisplayed());

    }


}
