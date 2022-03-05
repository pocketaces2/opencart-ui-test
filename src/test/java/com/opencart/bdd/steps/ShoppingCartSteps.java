package com.opencart.bdd.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.opencart.bdd.context.Context;
import com.opencart.bdd.context.TestContext;
import com.opencart.bdd.pageObjects.ShoppingCartPage;
import com.opencart.bdd.pageObjects.TopToolBarPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

public class ShoppingCartSteps {

  TestContext testContext;
  TopToolBarPage topToolBarPage;
  ShoppingCartPage shoppingCartPage;

  public ShoppingCartSteps(TestContext testContext) {
    this.testContext = testContext;
    topToolBarPage = testContext.getPageObjectManager().getTopToolBarPage();
    shoppingCartPage = testContext.getPageObjectManager().getShoppingCartPage();
  }

  @When("I go to the the shopping cart page")
  public void iGoToTheTheShoppingCartPage() {
    topToolBarPage.get().clickShoppingCartPageLink();
  }

  @Then("the products are listed correctly")
  public void theProductsAreListedCorrectly() {
    Map<String, String> previouslyAddedProducts = testContext.getScenarioContext()
        .get(Context.SHOPPING_CART_PRODUCT_PRICES);
    Map<String, String> displayedCartProducts = shoppingCartPage.get().getShoppingCartProducts();
    assertThat(
        "Products previously added to the cart do not match the products displayed on the shopping cart page",
        previouslyAddedProducts.entrySet(), equalTo(displayedCartProducts.entrySet()));
  }
}
