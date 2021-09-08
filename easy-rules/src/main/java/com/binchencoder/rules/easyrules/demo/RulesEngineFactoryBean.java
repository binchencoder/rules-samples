package com.binchencoder.rules.easyrules.demo;

import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class RulesEngineFactoryBean implements FactoryBean<RulesEngine> {

  public static final Logger LOGGER = LoggerFactory.getLogger(RulesEngineFactoryBean.class);

  /**
   * 默认规则引擎类（可结束）
   */
  private RulesEngine rulesEngine;

  private void init() {
    this.rulesEngine = new DefaultRulesEngine();
    LOGGER.info("create rule Engine");
    DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
    rulesEngine.getRuleListeners().clear();
    rulesEngine.getRulesEngineListeners().clear();
    rulesEngine.registerRuleListener(new MyRulesListener());
    rulesEngine.registerRulesEngineListener(new MyRuleEngineListener());
  }

  public RulesEngineFactoryBean() {
    this.init();
  }

  @Override
  public RulesEngine getObject() throws Exception {
    return this.rulesEngine;
  }

  @Override
  public Class<?> getObjectType() {
    return RulesEngine.class;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }
}