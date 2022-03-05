package com.opencart.bdd.context;

import java.util.EnumMap;
import java.util.Map;

public class ScenarioContext {

  private final Map<Context, Object> scenarioContext;

  public ScenarioContext() {
    scenarioContext = new EnumMap<>(Context.class);
  }

  public void setContext(Context key, Object value) {
    scenarioContext.put(key, value);
  }

  public <T> T get(Context key) {
    return (T) scenarioContext.get(key);
  }




}
