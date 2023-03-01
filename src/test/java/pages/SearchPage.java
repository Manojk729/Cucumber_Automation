package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SearchPage {
    public static By searchBar = AppiumBy.accessibilityId("search_default_search_text_input");
    public static By cameraIcon = AppiumBy.accessibilityId("search_toolbar_right_element_press_0");
    public static By trendingBanner = By.xpath("//android.widget.TextView[@text='TRENDING ON MYNTRA']");
    public static By crossButton = By.xpath("//android.view.ViewGroup[@content-desc=\"search_text_clear_click\"]/android.widget.TextView");
}
