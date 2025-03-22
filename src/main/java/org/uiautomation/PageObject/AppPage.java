package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class AppPage {
    public AppiumDriver driver;
    public AppPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Page Elements
     */
    @AndroidFindAll({
            @AndroidBy(accessibility = "My Demo App"),
            @AndroidBy(uiAutomator = "new UiSelector().text(\"My Demo App\")")
    })
    private WebElement appButton;

    /**
     * Page Functions
     */
    public void clickApp(){
        clickElement(appButton,10,"App Button Was Not Found");
    }

    public void waitPageToReload(int timeout){
        try{Thread.sleep(timeout*1000);}catch (Exception e){}
    }

    public void clickElement(WebElement element, int timeout, String errorReason){
            try{
                waitElement(element,timeout,errorReason);
                Thread.sleep(1000);
                element.click();
            }catch (Exception e){
                System.out.println("Element was not found: "+errorReason);
                throw new RuntimeException(e);

            }
    }

    public void waitElement(WebElement element, int timeout, String errorReason){
        for(int i =0;i<timeout;i++){
            try{
                Thread.sleep(1000);
                if(element.isDisplayed()){
                    System.out.println("Element Found");
                    break;
                }
            }catch (Exception e){
                if(i==timeout-1){
                    System.out.println("Element was not found: "+errorReason);
                }
            }
        }
    }

    public void sendKeysWithValue(WebElement element, String value){
        waitElement(element,10, "element was not found");
        element.sendKeys(value);
    }

    public void scrollToElement(String elementText){
        try{
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text("+elementText+"))"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Assertion
     */
    public void assertElementValue(WebElement element, String value){
        waitElement(element,3, "element not found");
        Assert.assertEquals(element.getText(),value,"Element value is not matched");
    }

}
