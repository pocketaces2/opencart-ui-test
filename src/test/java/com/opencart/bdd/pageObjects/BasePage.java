package com.opencart.bdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {

  protected WebDriver driver;

  public BasePage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @Override
  protected void load() {
    //Behaviour undesired, IsLoaded implementation takes precedence
  }


}
