package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ShippmentPage extends AppPage{
    public ShippmentPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/fullNameET")
    private WebElement fullNameTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address1ET")
    private WebElement addressTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/address2ET")
    private WebElement secAddressTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cityET")
    private WebElement cityTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/stateET")
    private WebElement stateTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/zipET")
    private WebElement zipTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/countryET")
    private WebElement countryTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement paymentButton;

    public void insertShipmentDetails(String username, String address, String secAddress, String city, String state, String zipCode, String country){
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        sendKeysWithValue(fullNameTextField, username);
        sendKeysWithValue(addressTextField, address);
        sendKeysWithValue(secAddressTextField, secAddress);
        sendKeysWithValue(cityTextField, city);
        sendKeysWithValue(stateTextField, state);
        sendKeysWithValue(zipTextField, zipCode);
        sendKeysWithValue(countryTextField, country);
        clickElement(paymentButton, 10, "Payment button was not displayed");
    }
}
