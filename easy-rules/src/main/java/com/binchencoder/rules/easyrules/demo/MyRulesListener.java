package com.binchencoder.rules.easyrules.demo;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MyRulesListener implements RuleListener {

  public static final Logger LOGGER = LoggerFactory.getLogger(MyRulesListener.class);

  @Override
  public boolean beforeEvaluate(Rule rule, Facts facts) {
    return true;
  }

  @Override
  public void afterEvaluate(Rule rule, Facts facts, boolean b) {
    LOGGER.info("-----------------afterEvaluate-----------------");
    LOGGER.info(rule.getName() + rule.getDescription() + facts.toString());
  }

  @Override
  public void beforeExecute(Rule rule, Facts facts) {
    LOGGER.info("-----------------beforeExecute-----------------");
    LOGGER.info(rule.getName() + rule.getDescription() + facts.toString());
  }

  @Override
  public void onSuccess(Rule rule, Facts facts) {
    LOGGER.info("-----------------onSuccess-----------------");
    LOGGER.info(rule.getName() + rule.getDescription() + facts.toString());
  }

  @Override
  public void onFailure(Rule rule, Facts facts, Exception e) {
    LOGGER.info("-----------------onFailure-----------------");
    LOGGER.info(
        rule.getName() + "----------" + rule.getDescription() + facts.toString() + e.toString());
  }
}
