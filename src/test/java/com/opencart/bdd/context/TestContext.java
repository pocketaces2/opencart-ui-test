package com.opencart.bdd.context;

import com.opencart.bdd.managers.DriverManager;
import com.opencart.bdd.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

/**
 * Allows for sharing any data between steps definitions, test data specifically is shared using the
 * Scenario Context
 *
 * @see ScenarioContext
 */
public class TestContext {

  private final PageObjectManager pageObjectManager;
  private final DriverManager driverManager;
  private final WebDriver driver;
  private final ScenarioContext scenarioContext;


  public TestContext() {
    driverManager = new DriverManager();
    driver = driverManager.getDriver();
    pageObjectManager = new PageObjectManager(driver);
    scenarioContext = new ScenarioContext();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public PageObjectManager getPageObjectManager() {
    return pageObjectManager;
  }

  public ScenarioContext getScenarioContext() {
    return scenarioContext;
  }
}
