package stepDefinitions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import pom.FilterPom;
import pom.InventoryPom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterSteps extends BaseMethods{
    FilterPom filterPom;
    {
        filterPom = FilterPom.getInstance();
    }
    InventoryPom inventoryPom;
    {
        inventoryPom = InventoryPom.getInstance();
    }
    List<String> productList = new ArrayList<>();

    @When("User clicks filter button")
    public void userClicksFilterButton() {
       getElement(filterPom.getSortBtn()).click();
    }

    @Then("Filter menu appears on the screen")
    public void filterMenuAppearsOnTheScreen() {
        Assert.assertTrue(getElement(filterPom.getWindowSort()).isDisplayed());
    }

    @And("User clicks {string} button")
    public void userClicksButton(String itemText) {
        getElement(filterPom.getAscendingName()).click();

              List<WebElement> elements =  getElements(inventoryPom.getInventoryElementText());
      for (WebElement element : elements){
         productList.add(element.getText());
          System.out.println(productList);
      }
        System.out.println(productList);

//        boolean isSorted = true;
//        for (int i = 0; i < productList.size() - 1; i++) {
//            if (productList.get(i).compareTo(productList.get(i + 1)) > 0) {
//                isSorted = false;
//                break;
//            }
//        }

    }

    @Then("Product {string} matches the filter")
    public void productMatchesTheFilter(String itemText) {
        boolean isSorted = true;
        for (int i = 0; i < productList.size() - 1; i++) {
            if (productList.get(i).compareTo(productList.get(i + 1)) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted);
    }

    @And("User clicks A to Z button")
    public void userClicksAToZButton() {
        getElement(filterPom.getAscendingName()).click();
    }

    @Then("Product arrangement from A to Z")
    public void productArrangementFromAToZ() throws InterruptedException {
        Thread.sleep(6000);
        List<WebElement> elements = getElements(inventoryPom.getInventoryElementText());
        System.out.println("e: " + elements.size());
        List<String> actualText = new ArrayList<>();
        List<String>sortedItems = new ArrayList<>();
        for (WebElement element:elements){
            String s = element.getText();
            actualText.add(s);
        }
        sortedItems.addAll(actualText);
        Collections.sort(sortedItems);
        System.out.println("e: " + elements.size());
        System.out.println("a: "+ actualText.size());

        Assert.assertTrue(actualText.equals(sortedItems));
    }
}
