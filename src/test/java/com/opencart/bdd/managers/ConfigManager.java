package com.opencart.bdd.managers;

import com.opencart.bdd.driver.DriverType;
import com.opencart.utils.ConfigFileReader;
import java.util.Properties;


/**
 * Used for supplying information about the configuration of the tests from an external properties
 * file
 */
public class ConfigManager {

  private static final ConfigManager configManager = new ConfigManager();
  private static final String configFilePath = "src/test/resources/com/opencart/bdd/config/config.properties";

  Properties properties;


  private ConfigManager() {
    properties = ConfigFileReader.readProps(configFilePath);
  }

  public static ConfigManager getInstance() {
    return configManager;
  }

  public DriverType getWebDriverType() {
    String browser = properties.getProperty("browser");

    switch (browser.toUpperCase()) {
      case "FIREFOX" -> {
        return DriverType.FIREFOX;
      }
      case "CHROME" -> {
        return DriverType.CHROME;
      }
      case "EDGE" -> {
        return DriverType.EDGE;
      }
      default -> {
        throw new IllegalArgumentException(
            "Invalid or unsupported browser specified to run tests with, browser specified: "
                + browser);
      }
    }
  }

  public boolean isBrowserWindowMaximized() {
    return Boolean.parseBoolean(properties.getProperty("windowMaximized"));
  }

}
