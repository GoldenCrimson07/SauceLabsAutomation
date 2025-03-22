package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ProductDetailPage extends AppPage{
    public ProductDetailPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productTitleText;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement iconPlus;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement totalQty;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartButton;

    public void selectColor(String color){
        try{Thread.sleep(2000);}catch (Exception e){};
        WebElement colorElement = driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiSelector().description(\""+color+"\")"));
        clickElement(colorElement,10,"No Colour Available");
    }

    public void setProductQuantity(int value){
        while (!totalQty.getText().equalsIgnoreCase(value+"")){
            clickElement(iconPlus,3, "Plus Icon is not displayed");
        }
    }
    public void tapAddToCartButton(){
        clickElement(addToCartButton,5, "addToCartButton not visible");
    }

    public void tapCartButton(){
        clickElement(cartButton,3,"cart button is npt displayed");
    }

    public void assertProductTitle(String productTitle){
        assertElementValue(productTitleText,productTitle);
    }
}
