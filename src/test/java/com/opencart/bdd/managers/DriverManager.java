package com.opencart.bdd.managers;

import com.opencart.bdd.driver.CustomListener;
import com.opencart.bdd.driver.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;


/**
 * Provides logic for instantiating the appropriate web driver to use in the selenium tests.
 */
public class DriverManager {

  private WebDriver driver;

  public WebDriver getDriver() {
    return driver == null ? createDriver() : driver;
  }

  private WebDriver createDriver() {
    DriverType driverType = ConfigManager.getInstance().getWebDriverType();

    switch (driverType) {
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

    return configureWebDriver(driver);
  }

  private WebDriver configureWebDriver(WebDriver driver) {

    if (ConfigManager.getInstance().isBrowserWindowMaximized()) {
      driver.manage().window().maximize();
    }

    WebDriverListener listener = new CustomListener(driver);

    return new EventFiringDecorator(listener).decorate(driver);
  }

}
