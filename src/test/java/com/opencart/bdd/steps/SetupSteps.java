package com.opencart.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupSteps {

  private WebDriver driver;

  @Given("^I am on the opencart homepage$")
  public void setupThenNavigateToOpenCart() {
    setupTests();
    driver.get("https://demo.opencart.com/");
  }

  @Given("^I have a desktop view of the screen$")
  public void setScreenFullSize() {
    driver.manage().window().maximize();
  }

  @After
  public void cleanUp(){
    driver.quit();
  }

  private void setupTests(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  public WebDriver getDriver(){
    return driver;
  }
}
