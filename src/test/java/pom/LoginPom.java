package pom;

import io.appium.java_client.AppiumBy;
import lombok.Data;
import org.openqa.selenium.By;
@Data
public class LoginPom {

    private final By burgermenu = AppiumBy.accessibilityId("open menu");
    private By userNameInput = AppiumBy.accessibilityId("Username input field");
    private By passwordInput = AppiumBy.accessibilityId("Password input field");
    private  By loginBtn = AppiumBy.accessibilityId("Login button");
    private By productImage = AppiumBy.xpath("//android.widget.TextView[@text=\"Products\"]");
    private final By errorMesage = AppiumBy.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private  final By errormesage2 = AppiumBy.xpath("//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]");
    private LoginPom(){

    }
    private static LoginPom Instance;

    public static LoginPom getInstance(){
        if(Instance == null){
            Instance = new LoginPom();
            return Instance;
        }else{
            return Instance;
        }
    }
}
