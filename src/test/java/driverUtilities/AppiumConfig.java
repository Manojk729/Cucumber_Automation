package driverUtilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import static constants.Constants.driver;

public class AppiumConfig {

    @BeforeTest
    public void configureAppium() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        // options.setDeviceName("64e3a033");//Physical Device
        // options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\apks\\Myntra.apk");
         options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\apks\\ApiDemos.apk");
        //options.setCapability("appActivity", "com.myntra.android.SplashActivity");
       // options.setCapability("appPackage", "com.myntra.android");
        //driverInvoke
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterTest
    public void closingSession() {
        driver.quit();
    }
}
