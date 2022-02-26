package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends LoadableComponent<SearchResultsPage> {

    private WebDriver driver;

    @FindBy(className = "product-layout")
    private List<WebElement> searchResults;

    @FindBy(id = "content")
    private WebElement searchHeader;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage clickFirstSearchResult(){
        getSearchResultByIndex(0).findElement(By.className("image")).click();
        return new ProductPage(driver).get();
    }

    private WebElement getSearchResultByIndex(int index){
          return searchResults.get(index);
    }

    @Override
    protected void load() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(searchHeader));
    }

    @Override
    protected void isLoaded() throws Error {
        IsLoaded.forThis(driver).whenElementIsVisible(searchHeader);
    }
}
