package testcases;

import BaseDriver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.uiautomation.PageObject.*;

import java.net.MalformedURLException;

public class CheckoutTest {

    private AppiumDriver driver;
    HomePage homePage;
    AppPage appPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;
    ShippmentPage shippmentPage;
    CheckoutPage checkoutPage;
    OrderReviewPage orderReviewPage;
    PaymentResultPage paymentResultPage;

    public CheckoutTest() throws MalformedURLException {
        BaseDriver.setup();
        this.driver = BaseDriver.getDriver();
        homePage = new HomePage(driver);
        appPage = new AppPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        shippmentPage = new ShippmentPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderReviewPage = new OrderReviewPage(driver);
        paymentResultPage = new PaymentResultPage(driver);
    }

    @Given("Launch App")
    public void launchApp() throws MalformedURLException {
        appPage.clickApp();
    }

    @When("User selects product namely {string} with {string}")
    public void selectProduct(String productName, String color){
        homePage.clickProduct(productName);
        productDetailPage.selectColor(color);
    }

    @Then("User can see product detail page with {string} selected")
    public void assertProductAtPDP(String productName){
        productDetailPage.assertProductTitle(productName);
    }

    @When("User adds {int} items")
    public void addQuantity(int qty){
        productDetailPage.setProductQuantity(qty);
        productDetailPage.tapAddToCartButton();
    }

    @Then("User can see {int} products namely {string} and total price at {string} at cart page")
    public void checkCartPage(int qty, String productName, String totalPrice){
        productDetailPage.tapCartButton();
        cartPage.assertCartPage(qty,productName,true,totalPrice);
        cartPage.tapCheckoutButton();
    }

    @When("User adds buyer details")
    public void addBuyerDetails(){
        loginPage.loginAccount("wilton.pangestu@gmail.com","123456");
        shippmentPage.insertShipmentDetails("wilton","jl. testing no 123","","Jakarta","Jakarta","13411","Indonesia");
        checkoutPage.addPaymentDetails("wilton","29182918121","1233","123");
    }

    @Then("User can see payment details")
    public void checkShippingAddress(){
        orderReviewPage.assertCheckoutData("wilton","29182918121","Exp: 12/33","jl. testing no 123");
    }

    @When("User places order")
    public void placeOrder(){
        orderReviewPage.clickReviewButton();
    }

    @Then("Success checkout page is displayed")
    public void checkSuccessPage(){
        paymentResultPage.assertSuccessPaymentResultPage();
    }
//    Then User can see "2" products namely "Sauce Lab Back Packs" and total price at "$ 59.98" at cart page
//    When User adds buyer details
//    Then User can see shipping address
//    When User places order
//    Then Success checkout page is displayed


}
