package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ResultsPage {
    public static By sortIcon = AppiumBy.accessibilityId("touchable_sort");
    public static By genderIcon = By.xpath("//android.widget.TextView[@text='GENDER']");
    public static By filterIcon = AppiumBy.accessibilityId("image_filter");
}
