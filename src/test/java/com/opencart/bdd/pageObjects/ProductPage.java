package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage<ProductPage> {

    @FindBy(xpath = "(//div[@id=\"content\"]//a[@class=\"thumbnail\"])[1]")
    private WebElement primaryImageThumbnail;

    @FindBy(css = "button[title='Next (Right arrow key)'")
    private WebElement rightArrowImageScroll;

    @FindBy(className = "mfp-img")
    private WebElement enlargedImage;

    @FindBy(className = "mfp-counter")
    private WebElement enlargedImageCounter;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        IsLoaded.forThis(driver).whenElementIsVisible(primaryImageThumbnail);
    }


    public boolean enlargedImageIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(enlargedImage));
        return enlargedImage.isDisplayed();
    }

    public int getEnlargedImageCount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(enlargedImageCounter));
        return Integer.parseInt(enlargedImageCounter.getText().split(" of")[0]);
    }

    public void clickPrimaryImageThumbNail(){
        primaryImageThumbnail.click();
    }

    public void scrollToNextEnlargedImageByRightArrow(){
        rightArrowImageScroll.click();
    }
}
