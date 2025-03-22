package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage extends AppPage{
    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement productQty;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    private WebElement totalPrice;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/colorIV")
    private WebElement selectedColor;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement checkoutButton;

    public void tapCheckoutButton(){
        clickElement(checkoutButton,3,"checkout button is not displayed");
    }

    public void assertCartPage(int qty, String productName, boolean withColor, String totalPrice){
        assertElementValue(productQty,qty+"");
        assertElementValue(productTitle,productName);
        assertElementValue(this.totalPrice,totalPrice);
        if(withColor){
            Assert.assertEquals(selectedColor.isDisplayed(),true,"Color is not selected");
        }
    }
}
