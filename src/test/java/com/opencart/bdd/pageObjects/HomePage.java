package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends LoadableComponent<HomePage> {

    private WebDriver driver;

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(css = "#search button")
    private WebElement searchBtn;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearchBarText(String value){
        searchBar.sendKeys(value);
    }

    public SearchResultsPage clickSearchBtn(){
        searchBtn.click();
        return new SearchResultsPage(driver);
    }


    @Override
    protected void load() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(searchBar));
    }

    @Override
    protected void isLoaded() throws Error {
        IsLoaded.forThis(driver).whenElementIsVisible(searchBar);
    }
}
