package com.opencart.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

  /**
   * Used for reading properties from a properties file and returning this as a java properties
   * object
   *
   * @param propertiesPath - the relative path to the properties path in the repo
   * @return - a properties object consisting of the properties defined in properties file.
   */
  public static Properties readProps(String propertiesPath) {

    Properties properties = new Properties();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(propertiesPath))) {
      properties.load(bufferedReader);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return properties;

  }

}
