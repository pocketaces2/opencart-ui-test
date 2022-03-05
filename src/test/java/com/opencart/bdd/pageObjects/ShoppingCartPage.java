package com.opencart.bdd.pageObjects;

import com.opencart.utils.IsLoaded;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage<ShoppingCartPage>{

  @FindBy(id = "checkout-cart")
  private WebElement shoppingCartHeader;

  @FindBy(css = ".table-responsive tbody")
  private WebElement shoppingCartTable;


  public ShoppingCartPage(WebDriver driver){
    super(driver);
  }


  @Override
  protected void isLoaded() throws Error {
    IsLoaded.forThis(driver).whenElementIsVisible(shoppingCartHeader);
  }

  public Map<String,String> getShoppingCartProducts(){
    Map<String,String> shoppingCartProducts = new HashMap<>();
    int numOfProductRows = shoppingCartTable.findElements(By.cssSelector("tr")).size();

    for (int i = 1; i < numOfProductRows + 1; i++){

      String cartProductName = shoppingCartTable.findElement(
          By.xpath("tr[" + i + "]/td[@class=\"text-left\"][1]")).getText().replaceAll("\\*", "").trim();
      String cartProductPrice = shoppingCartTable.findElement(By.xpath("tr[" + i + "]/td[@class=\"text-right\"][1]")).getText();
      shoppingCartProducts.put(cartProductName, cartProductPrice);
    }

    return shoppingCartProducts;

  }
}
