package org.uiautomation.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class AppPage {
    private AppiumDriver driver;
    public AppPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /**
     * Page Elements
     */
    @AndroidFindBy(accessibility = "My Demo App")
    private WebElement appButton;

    /**
     * Page Functions
     */
    public void clickApp(){
        appButton.click();
    }

    public void clickElement(WebElement element, int timeout){
        try{
            for(int i =0;i<timeout;i++){
                Thread.sleep(1000);
                if(element.isDisplayed()){
                    element.click();
                    break;
                }
            }
        }catch (Exception e){

        }
    }

}
