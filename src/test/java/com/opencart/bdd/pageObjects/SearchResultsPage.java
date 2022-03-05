package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage<SearchResultsPage> {

  @FindBy(className = "product-layout")
  private List<WebElement> searchResults;

  @FindBy(id = "product-search")
  private WebElement searchContainer;

  public SearchResultsPage(WebDriver driver) {
    super(driver);
  }

  @Override
  protected void isLoaded() throws Error {
    IsLoaded.forThis(driver).whenElementIsVisible(searchContainer);
  }

  public ProductPage clickFirstSearchResult() {
    getSearchResultByIndex(0).findElement(By.className("image")).click();
    return new ProductPage(driver).get();
  }

  public SearchResultsPage clickAddToCartOnFirstSearchResult() {
    getSearchResultByIndex(0).findElement(By.cssSelector("button[Type=\"button\"")).click();
    return this.get();
  }

  public String getPriceOfFirstSearchResult() {
    return getSearchResultByIndex(0).findElement(By.className("price")).getText().split("Ex")[0];
  }

  private WebElement getSearchResultByIndex(int index) {
    return searchResults.get(index);
  }


}
