package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PaymentResultPage extends AppPage{
    public PaymentResultPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement successResult;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/shoopingBt")
    private WebElement continueShoppingButton;


}
