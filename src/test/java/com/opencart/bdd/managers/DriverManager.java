package com.opencart.bdd.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Provides logic for instantiating the appropriate web driver to use in the selenium tests.
 */
public class DriverManager {

  private WebDriver driver;
  private static DriverType driverType;

  public DriverManager(){
    driverType = DriverType.valueOf(System.getProperty("browser", "EDGE"));
  }

  public WebDriver getDriver() {
    return driver == null ? createDriver() : driver;
  }

  private WebDriver createDriver(){
    switch (driverType){
      case FIREFOX -> {
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
      }
      case CHROME -> {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      }
      case EDGE -> {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
      }
      default -> {
        throw new IllegalArgumentException("Invalid browser specified to run tests with");
      }
    }
    return driver;
  }



}
