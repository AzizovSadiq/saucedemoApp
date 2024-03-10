package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.BasketPom;
import pom.InventoryPom;

public class BasketSteps extends BaseMethods{
    BasketPom basketPom;
    {
        basketPom = BasketPom.getInstance();
    }
    InventoryPom inventoryPom;
    {
        inventoryPom = InventoryPom.getInstance();
    }

    @When("User click the basket button")
    public void userClickTheEmptyCartButton() {
        getElement(basketPom.getBasketBtn()).click();
    }

    @Then("{string} button appears")
    public void buttonAppears(String arg0) {
        Assert.assertTrue(getElement(basketPom.getGoshoppingBtn()).isDisplayed());
    }

    @When("Click to random product")
    public void clickToRandomProduct() {
        getElement(basketPom.getItemProduct()).click();
    }

    @And("Click {string} button")
    public void clickButton(String itemText) throws InterruptedException {
        scrollToElementText(itemText);
        getElement(basketPom.getAddToCard()).click();
        Thread.sleep(2000);
        getElement(basketPom.getBasketBtn()).click();
        Thread.sleep(2000);
    }

    @Then("Product is in the basket page")
    public void productIsInTheBasketPage() throws InterruptedException {
        getElement(basketPom.getBasketBtn()).click();
        Thread.sleep(200);
        System.out.println(getElement(basketPom.getProductTotalPrice()).getText());
      Assert.assertTrue(getElement(basketPom.getBasketPruductName()).isDisplayed());
    }

    @And("Remove element basket page")
    public void removeElementBasketPage() {
        getElement(basketPom.getRemoveElement()).click();
    }

    @Then("Item has been removed from the cart page")
    public void itemHasBeenRemovedFromTheCartPage() {
        Assert.assertTrue(getElement(basketPom.getGoshoppingBtn()).isDisplayed());
    }

    @Then("One order price is equal to the total price")
    public void oneOrderPriceIsEqualToTheTotalPrice() {
        String priceText2 = getElement(basketPom.getProductTotalPrice()).getText().replace("$", "");
        Double priceDouble2 = Double.parseDouble(priceText2);

        String priceText = getElement(basketPom.getProductPrice()).getText().replace("$", "");
        Double priceDouble = Double.parseDouble(priceText);
        boolean price = false;
        if (priceDouble.equals(priceDouble2)) price = true;

        Assert.assertTrue(price);
    }

    @And("Add two products to cart")
    public void addTwoProductsToCart() {
        scrollToElementText("Product Highlights");
        getElement(basketPom.getPlusProduct()).click();
        getElement(basketPom.getBasketBtn()).click();
    }

    @Then("Price of two orders is equal to the total price")
    public void priceOfTwoOrdersIsEqualToTheTotalPrice() {
        String priceText2 = getElement(basketPom.getProductTotalPrice()).getText().replace("$", "");
        Double priceDouble2 = Double.parseDouble(priceText2);

        String priceText = getElement(basketPom.getProductPrice()).getText().replace("$", "");
        Double priceDouble = Double.parseDouble(priceText);
        priceDouble = priceDouble*2;
        System.out.println(priceDouble);
        boolean price = false;
        if (priceDouble.equals(priceDouble2)) price = true;

        Assert.assertTrue(price);

    }
}
