package com.binchencoder.rules.easyrules.spel;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.util.Lists;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.spel.SpELRuleFactory;
import org.jeasy.rules.support.reader.JsonRuleDefinitionReader;

/**
 * Created by chenbin on 21-9-7.
 */
public class Launcher1 {

  public static void main(String[] args) throws Exception {
    // create a person instance (fact)
    Facts facts = new Facts();
    FormCondition formCond = new FormCondition();
    Map<String, Object> params = new HashMap<>();
    params.put("numberField", 18L);
    params.put("selectField", Lists.newArrayList("111", "222"));
    formCond.setParams(params);
    facts.put("formCond", formCond);

    // create rules
    SpELRuleFactory ruleFactory = new SpELRuleFactory(new JsonRuleDefinitionReader());
    Rules rules = ruleFactory.createRules(new InputStreamReader(
        Launcher1.class.getClassLoader().getResourceAsStream("spel/alcohol-rule1.json")));

    //create a default rules engine and fire rules on known facts
    RulesEngineParameters parameters = new
        RulesEngineParameters().skipOnFirstAppliedRule(true);
    RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

    System.out.println("Tom: Hi! can I have some Vodka please?");
    rulesEngine.fire(rules, facts);

    System.out.println(formCond.toString());
  }
}