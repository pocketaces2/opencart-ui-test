package com.opencart.bdd.managers;


import com.opencart.bdd.pageObjects.HomePage;
import com.opencart.bdd.pageObjects.ProductPage;
import com.opencart.bdd.pageObjects.SearchResultsPage;
import com.opencart.bdd.pageObjects.ShoppingCartPage;
import com.opencart.bdd.pageObjects.TopToolBarPage;
import org.openqa.selenium.WebDriver;


/**
 * Used for instantiating page objects and returning a single instance of the page.
 */
public class PageObjectManager {

  private final WebDriver driver;

  private HomePage homePage;
  private SearchResultsPage searchResultsPage;
  private ProductPage productPage;
  private ShoppingCartPage shoppingCartPage;
  private TopToolBarPage topToolBarPage;

  public PageObjectManager(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage getHomePage() {
    return (homePage == null) ? homePage = new HomePage(driver) : homePage;
  }

  public SearchResultsPage getSearchResultsPage() {
    return (searchResultsPage == null) ? searchResultsPage = new SearchResultsPage(driver)
        : searchResultsPage;
  }

  public ProductPage getProductPage() {
    return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
  }

  public ShoppingCartPage getShoppingCartPage() {
    return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartPage(driver)
        : shoppingCartPage;
  }

  public TopToolBarPage getTopToolBarPage() {
    return (topToolBarPage == null) ? topToolBarPage = new TopToolBarPage(driver) : topToolBarPage;
  }
}
