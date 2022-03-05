package com.opencart.bdd.context;

import com.opencart.bdd.managers.PageObjectManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext {

  private final PageObjectManager pageObjectManager;
  private final WebDriver driver;
  private final ScenarioContext scenarioContext;


  public TestContext(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    pageObjectManager = new PageObjectManager(driver);
    scenarioContext = new ScenarioContext();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public PageObjectManager getPageObjectManager() {
    return pageObjectManager;
  }

  public ScenarioContext getScenarioContext(){
    return scenarioContext;
  }
}
