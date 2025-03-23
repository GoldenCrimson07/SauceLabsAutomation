package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class OrderReviewPage extends AppPage{
    public OrderReviewPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardHolderTV")
    private WebElement userNameTextfield;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cardNumberTV")
    private WebElement cardNumberTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/expirationDateTV")
    private WebElement expirationDate;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/addressTV")
    private WebElement addressTextField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/paymentBtn")
    private WebElement reviewButton;

    public void clickReviewButton(){
        clickElement(reviewButton,10,"Review Button Was not displayed");
    }

    public void assertCheckoutData(String username, String cardNumber, String expirationDate, String address){
        waitPageToReload(2);
        scrollToElement("© 2021 Sauce Labs All Rights Reserved. Terms of Service | Privacy Policy");
        assertElementValue(userNameTextfield, username);
        assertElementValue(cardNumberTextField, cardNumber);
        assertElementValue(this.expirationDate, expirationDate);
        assertElementValue(addressTextField, address);
    }
}
