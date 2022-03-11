package com.opencart.bdd.driver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Listens for events happening on the webdriver and executes code when triggered
 */
public class CustomListener implements WebDriverListener {

  WebDriver driver;
  Logger logger = LoggerFactory.getLogger(CustomListener.class);


  public CustomListener(WebDriver driver){
    this.driver = driver;
  }

  /**
   * Listens for an error happening on the webdriver, takes a screenshot and moves to appropriate directory when triggered.
   *
   */
  public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {

    var camera = (TakesScreenshot) driver;
    File screenshotError = camera.getScreenshotAs(OutputType.FILE);
    Path screenshotDestinationPath = Paths.get(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\opencart\\bdd\\screenshots\\"  + screenshotError.getName());
    try {
      Files.move(screenshotError.toPath(), screenshotDestinationPath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
    logger.error("Screenshot taken of exception: " + screenshotDestinationPath);
  }

}
