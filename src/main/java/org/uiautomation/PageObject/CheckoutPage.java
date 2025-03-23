package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends AppPage{
    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement paymentButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement cardHolderNameTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberET")
    private WebElement cardNumberTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateET")
    private WebElement expirationDateTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/securityCodeET")
    private WebElement securityCodeTextField;

    public void addPaymentDetails(String cardHolderName, String cardNumber, String expirationDate, String securityCode){
        waitPageToReload(2);
        sendKeysWithValue(cardHolderNameTextField, cardHolderName);
        sendKeysWithValue(cardNumberTextField, cardNumber);
        sendKeysWithValue(expirationDateTextField, expirationDate);
        sendKeysWithValue(securityCodeTextField, securityCode);
        clickElement(paymentButton,10,"no payment button");
    }
}
