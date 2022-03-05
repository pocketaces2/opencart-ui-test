package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage<HomePage> {

  @FindBy(name = "search")
  private WebElement searchBar;

  @FindBy(css = "#search button")
  private WebElement searchBtn;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void setSearchBarText(String value) {
    searchBar.clear();
    searchBar.sendKeys(value);
  }

  public SearchResultsPage clickSearchBtn() {
    searchBtn.click();
    return new SearchResultsPage(driver);
  }

  @Override
  protected void isLoaded() throws Error {
    IsLoaded.forThis(driver).whenElementIsVisible(searchBar);
  }
}
