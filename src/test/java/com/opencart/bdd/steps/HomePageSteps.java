package com.opencart.bdd.steps;

import com.opencart.bdd.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

public class HomePageSteps {

  private final TestContext testContext;

  public HomePageSteps(TestContext testContext) {
    this.testContext = testContext;
  }

  @Given("^I am on the opencart homepage$")
  public void setupThenNavigateToOpenCart() {
    testContext.getDriver().get("https://demo.opencart.com/");
  }

  @After
  public void cleanUp() {
    testContext.getDriver().quit();
  }

}
