package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopToolBarPage extends BasePage<TopToolBarPage>{

  @FindBy(css = "a[title=\"Shopping Cart\"]")
  private WebElement shoppingCartLink;

  public TopToolBarPage(WebDriver driver){
    super(driver);
  }

  public ShoppingCartPage clickShoppingCartPageLink(){
    shoppingCartLink.click();
    return new ShoppingCartPage(driver);
  }

  @Override
  protected void isLoaded() throws Error {
    IsLoaded.forThis(driver).whenElementIsVisible(shoppingCartLink);
  }
}
