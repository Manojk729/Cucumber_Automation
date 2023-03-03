package stepDefinitions;

import constants.Constants;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultsPage;
import pages.SearchPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.time.Duration;

import static constants.Constants.driver;
import static constants.Constants.wait;

public class Checkout_StepDefinitions {
    @Given("Open the application")
    public void open_the_application() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setDeviceName("64e3a033");
        options.setCapability("appActivity", "com.myntra.android.SplashActivity");
        options.setCapability("appPackage", "com.myntra.android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Constants.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @Then("Verify user lands on HomePage")
    public void verify_User_Lands_On_HomePage() {
        try {
            Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.homePagebanner1));
            Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.homePagebanner2));
            Assert.assertTrue(driver.findElement(HomePage.homePagebanner1).isDisplayed());
            Assert.assertTrue(driver.findElement(HomePage.homePagebanner2).isDisplayed());
        } catch (Exception e) {
            System.out.println("Banners are not visible");
        }
        Assert.assertTrue(driver.findElement(HomePage.notificationIcon).isDisplayed());
    }

    @Then("Check if search button is clickable")
    public void check_if_search_button_clickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(HomePage.searchButton));
        Assert.assertTrue(driver.findElement(HomePage.searchButton).isDisplayed());
    }

    @When("Click on Search button")
    public void click_on_search_bar() {
        Constants.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(HomePage.searchButton)));
        driver.findElement(HomePage.searchButton).click();
    }

    @Then("Text in search bar should be visible")
    public void text_In_SearchBar_Should_Be_Visible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPage.searchBar));
        String searchBarText = driver.findElement(SearchPage.searchBar).getText();
//        try{
//            Assert.assertEquals(searchBarText,"Search for products & brands");
//    }catch (Exception e){
//            System.out.println("PlaceHolder Text mismatched");
//        }
    }

    @And("Enter the name of product")
    public void enter_the_name_of_product() {
        Constants.wait.until(ExpectedConditions.elementToBeClickable(SearchPage.cameraIcon));
        //Constants.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPage.trendingBanner));
        driver.findElement(SearchPage.searchBar).sendKeys("Puma Shoes");
        String sText = driver.findElement(SearchPage.searchBar).getText();
        Assert.assertEquals(sText, "Puma Shoes");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Then("Wishlist icon should be visible")
    public void wishlist_Icon_Should_Be_Visible() {
        wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(AppiumBy.accessibilityId("wishlist")))));
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("wishlist")).isDisplayed());

    }

    @And("Scroll to the product")
    public void scroll_to_the_product() {
        try {
            Constants.wait.until(ExpectedConditions.visibilityOf(driver.findElement(ResultsPage.sortIcon)));
            Constants.wait.until(ExpectedConditions.elementToBeClickable(ResultsPage.genderIcon));
            Constants.wait.until(ExpectedConditions.elementToBeClickable(ResultsPage.filterIcon));
            //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"exact_text\"))"));
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        } catch (Exception e) {
            System.out.println("Product found on top of list");
        }
    }

    @And("Select the product")
    public void select_the_product() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='one8 x PUMA']")).click();//click the shoe

    }

    @And("Click on Add to Cart button")
    public void click_on_add_to_cart_button() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO BAG']")).click();//add to bag

    }

    @And("Select the size of product")
    public void select_The_Size_Of_Product() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='10']")).click();//select the size

    }

    @Then("Seller text should be visible")
    public void seller_Text_Should_Be_Visible() {
        Assert.assertTrue(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"size_selector\"]/android.widget.TextView[6]")).isDisplayed());//seller text

    }

    @And("Click the done button")
    public void click_The_Done_Button() {
        driver.findElement(AppiumBy.accessibilityId("buy_done_button")).click();// clicking done button

    }

    @Then("GO TO BAG button should be visible")
    public void go_TO_BAG_Button_should_Be_Visible() {
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO BAG']")).isDisplayed());//go to bag button visible

    }

    @And("Click on cart icon")
    public void click_On_CartIcon() {
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='bag']/android.view.ViewGroup")).click();//click cart

    }

    @And("Click on place order")
    public void click_On_Place_Order() {
        driver.findElement(By.xpath("(//android.view.View[@index='2']")).click();//place order

    }

    @Then("Login page should appear")
    public void login_page_should_appear() {
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).isDisplayed());
    }

}
