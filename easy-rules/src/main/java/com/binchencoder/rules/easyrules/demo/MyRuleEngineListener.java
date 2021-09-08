package com.binchencoder.rules.easyrules.demo;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyRuleEngineListener implements RulesEngineListener {

  public static final Logger LOGGER = LoggerFactory.getLogger(MyRuleEngineListener.class);

  @Override
  public void beforeEvaluate(Rules rules, Facts facts) {
    LOGGER.info("-----------------beforeEvaluate-----------------");
    LOGGER.info(rules.toString() + " " + facts.toString());
  }

  @Override
  public void afterExecute(Rules rules, Facts facts) {
    LOGGER.info("-----------------afterExecute-----------------");
    LOGGER.info(rules.toString() + "   " + facts.toString());
  }
}
