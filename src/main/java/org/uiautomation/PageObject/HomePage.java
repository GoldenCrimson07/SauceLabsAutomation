package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class HomePage  extends AppPage{
    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public void clickProduct(String productName){
        try{Thread.sleep(1500);} catch (InterruptedException e) {
            throw new RuntimeException(e);
        };
        WebElement productDesc = driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiSelector().description(\""+productName+"\")"));
        clickElement(productDesc,10,"product not found");
    }


}
