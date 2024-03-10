package pom;

import io.appium.java_client.AppiumBy;
import lombok.Data;
import org.openqa.selenium.By;
@Data
public class FilterPom {
    private FilterPom(){

    }

    private static FilterPom Instance;

    public static FilterPom getInstance(){
        if(Instance == null){
            Instance = new FilterPom();
            return Instance;
        }else{
            return Instance;
        }
    }
    private final By sortBtn = AppiumBy.accessibilityId("sort button");
    private final By windowSort = AppiumBy.xpath("//android.widget" +
            ".FrameLayout[@resource-id=\"android:id/content\"]/android" +
            ".widget.FrameLayout/android.view.ViewGroup/android.view" +
            ".ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
    private final By ascendingName = AppiumBy.accessibilityId("nameAsc");
    private final By descendingName = AppiumBy.accessibilityId("nameDesc");
    private final By priceAsc = AppiumBy.accessibilityId("priceAsc");
    private final By priceDesc = AppiumBy.accessibilityId("priceDesc");
}
