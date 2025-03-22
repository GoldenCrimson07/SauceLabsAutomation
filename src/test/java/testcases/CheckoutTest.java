package testcases;

import BaseDriver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.uiautomation.PageObject.AppPage;
import org.uiautomation.PageObject.HomePage;

import java.net.MalformedURLException;

public class CheckoutTest {

    private AppiumDriver driver;

    public CheckoutTest() throws MalformedURLException {
        BaseDriver.setup();
        this.driver = BaseDriver.getDriver();
    }

    @Given("Launch App")
    public void launchApp() throws MalformedURLException {
        AppPage appPage = new AppPage(driver);
        appPage.clickApp();

    }

    @When("User selects product")
    public void selectProduct(){
        HomePage homePage = new HomePage(driver);
        homePage.clickProduct();
    }
}
