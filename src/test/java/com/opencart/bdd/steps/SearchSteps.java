package com.opencart.bdd.steps;

import com.opencart.bdd.context.Context;
import com.opencart.bdd.context.TestContext;
import com.opencart.bdd.pageObjects.HomePage;
import com.opencart.bdd.pageObjects.SearchResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import java.util.HashMap;
import java.util.Map;


public class SearchSteps {

  TestContext testContext;

  HomePage homePage;
  SearchResultsPage searchResultsPage;


  public SearchSteps(TestContext testContext){
    this.testContext = testContext;
    homePage = testContext.getPageObjectManager().getHomePage();
    searchResultsPage = testContext.getPageObjectManager().getSearchResultsPage();
  }

  @Given("^I add the following products to the shopping cart$")
  public void iAddProductToTheShoppingCart(DataTable table) {

    Map<String, String> productPrices = new HashMap<>();

    for (String product : table.asList()){
      searchProduct(product);
      productPrices.put(product, getFirstProductResultPrice());
      addFirstProductResultToCart();
    }

    testContext.getScenarioContext().setContext(Context.SHOPPING_CART_PRODUCT_PRICES, productPrices);
  }

  @Given("^I search for a (.*) product$")
  public void searchProduct(String product) {
    homePage.get().setSearchBarText(product);
    homePage.clickSearchBtn();
  }

  @Given("^I click on the first search result$")
  public void clickFirstResult(){
    searchResultsPage.get().clickFirstSearchResult();
  }

  private String getFirstProductResultPrice(){
    return searchResultsPage.get().getPriceOfFirstSearchResult().trim();
  }

  private void addFirstProductResultToCart(){
    searchResultsPage.get().clickAddToCartOnFirstSearchResult();
  }

}
