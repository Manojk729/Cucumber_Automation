package constants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constants {
    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static String API_DEMO_PATH = "\\src\\utiles\\ApiDemos.apk";
    public static String GENERAL_STORE_APP = "\\src\\utiles\\General-Store.apk";
}
