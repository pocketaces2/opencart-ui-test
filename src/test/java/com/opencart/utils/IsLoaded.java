package com.opencart.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Helper methods to check if an element has loaded and if not to wait for a specified time via the
 * LoadableComponent logic. The logic here supersedes the need a for a call to load() in this class
 *
 * @see org.openqa.selenium.support.ui.LoadableComponent
 */
public class IsLoaded {

  private WebDriver driver;

  public IsLoaded(WebDriver driver) {
    this.driver = driver;
  }

  public static IsLoaded forThis(WebDriver driver) {
    return new IsLoaded(driver);
  }

  public IsLoaded whenElementIsVisible(WebElement element) {
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until((ExpectedConditions.visibilityOf(element)));
    try {
      if (element.isDisplayed()) {
        return this;
      } else {
        throw new Error(element + " is not visible");
      }
    } catch (WebDriverException e) {
      throw new Error(element + " is not visible", e);
    }
  }

}
