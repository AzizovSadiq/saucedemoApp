package pom;

import io.appium.java_client.AppiumBy;
import lombok.Data;
import org.openqa.selenium.By;
@Data
public class InventoryPom {
    private InventoryPom(){

    }
    private static InventoryPom Instance;

    public static InventoryPom getInstance(){
        if(Instance == null){
            Instance = new InventoryPom();
            return Instance;
        }else{
            return Instance;
        }
    }

    private final By inventoryElementText = By.xpath("//*[@content-desc='store item text'");
    private By starProduct = AppiumBy.xpath("(//android.widget.TextView[@text=\"\uDB81\uDCCF\"])[3]");
    private final By productDescription = AppiumBy.accessibilityId("product description");
    private final By descriptionText = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"product description\"]");
}
