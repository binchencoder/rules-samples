package com.binchencoder.rules.easyrules.demo;

import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Launcher {

  public static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

  @Bean(name = "myEngine")
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public RulesEngine myEngine(MyRulesListener myRulesListener,
      MyRuleEngineListener myRuleEngineListener) {
    LOGGER.info("create rule Engine");
    //create a default rules engine and fire rules on known facts
    RulesEngineParameters parameters = new
        RulesEngineParameters().skipOnFirstAppliedRule(true);
    DefaultRulesEngine rulesEngine = new DefaultRulesEngine(parameters);
    rulesEngine.registerRuleListener(myRulesListener);
    rulesEngine.registerRulesEngineListener(myRuleEngineListener);

    return rulesEngine;
  }

  @Bean("myEngine2")
  ProtoRulesEngineFactoryBean rulesEngineFactoryBean() {
    return new ProtoRulesEngineFactoryBean();
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Launcher.class, args);
  }
}