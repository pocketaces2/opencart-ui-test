package com.opencart.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Advice taken from https://www.eviltester.com/blog/seleniumsimplified/2013-08-17-helper-classes-for-slowloadablecomponent-page-objects/
 */

public class IsLoaded {

    private WebDriver driver;

    public IsLoaded(WebDriver driver){
        this.driver = driver;
    }

    public static IsLoaded forThis(WebDriver driver){
        return new IsLoaded(driver);
    }

    public IsLoaded whenElementIsVisible(WebElement element){
        try{
            if(element.isDisplayed()){
                return this;
            }
            else {
                throw new Error(element.toString() + " is not visible");
            }
        }
        catch (WebDriverException e){
            throw new Error(element.toString() + " is not visible", e);
        }
    }

}
