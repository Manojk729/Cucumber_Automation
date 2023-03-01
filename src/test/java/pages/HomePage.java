package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePage {
    public static By searchButton = AppiumBy.accessibilityId("search");
    public static By homePagebanner1 = By.xpath("//android.view.ViewGroup[@content-desc=\"BANNER_1\"]/android.widget.ImageView");
    public static By homePagebanner2 = By.xpath("//android.view.ViewGroup[@content-desc=\"BANNER_2\"]/android.widget.ImageView");
    public static By notificationIcon = AppiumBy.accessibilityId("notification");
}
