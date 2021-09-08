package com.binchencoder.rules.easyrules.demo;

import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * 原型RulesEngine FactoryBean
 */
public class ProtoRulesEngineFactoryBean implements FactoryBean<RulesEngine> {

  public static final Logger LOGGER = LoggerFactory.getLogger(ProtoRulesEngineFactoryBean.class);

  public RulesEngine init() {
    LOGGER.info("create rule Engine");
    DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
    rulesEngine.registerRuleListener(new MyRulesListener());
    rulesEngine.registerRulesEngineListener(new MyRuleEngineListener());
    return rulesEngine;
  }

  @Override
  public RulesEngine getObject() throws Exception {
    return this.init();
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
