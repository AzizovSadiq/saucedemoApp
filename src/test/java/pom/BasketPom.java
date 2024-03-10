package pom;

import io.appium.java_client.AppiumBy;
import lombok.Data;
import org.openqa.selenium.By;
@Data
public class BasketPom {
    private BasketPom(){
    }
    private static BasketPom Instance;
    public static BasketPom getInstance(){
        if(Instance == null){
            Instance = new BasketPom();
            return Instance;
        }else{
            return Instance;
        }
    }
    private final By goshoppingBtn = AppiumBy.accessibilityId("Go Shopping button");
    private final By basketBtn = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView");
    private By itemProduct = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[2]");
    private final By addToCard = AppiumBy.accessibilityId("Add To Cart button");
    private By basketNumber = AppiumBy.xpath("(//android.widget.TextView[@text=\"1\"])[1]");
    private final By basketPruductName = AppiumBy.accessibilityId("product label");
    private final By removeElement = AppiumBy.accessibilityId("remove item");
    private final By productPrice = AppiumBy.accessibilityId("product price");
    private final By productTotalPrice = AppiumBy.accessibilityId("total price");
    private final By plusProduct = AppiumBy.accessibilityId("counter plus button");

}
