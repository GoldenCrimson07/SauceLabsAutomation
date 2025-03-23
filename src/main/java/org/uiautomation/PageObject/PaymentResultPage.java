package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaymentResultPage extends AppPage{
    public PaymentResultPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/completeTV")
    private WebElement successResult;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/shoopingBt")
    private WebElement continueShoppingButton;

    public void assertSuccessPaymentResultPage(){
        waitPageToReload(1);
        Assert.assertEquals(successResult.isDisplayed(),true);
        Assert.assertEquals(continueShoppingButton.isDisplayed(),true);
    }
}
