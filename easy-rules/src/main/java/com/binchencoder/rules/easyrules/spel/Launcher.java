package com.binchencoder.rules.easyrules.spel;

import java.io.InputStreamReader;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.spel.SpELRuleFactory;
import org.jeasy.rules.support.reader.JsonRuleDefinitionReader;

/**
 * Created by chenbin on 21-9-7.
 */
public class Launcher {

  public static void main(String[] args) throws Exception {
    // define facts
//    Facts facts = new Facts();
//    facts.put("temperature", 30);
//
//    // define rules
//    Rule airConditioningRule = new RuleBuilder()
//        .name("air conditioning rule")
//        .when(itIsHot())
//        .then(decreaseTemperature())
//        .build();
//    Rules rules = new Rules();
//    rules.register(airConditioningRule);
//
//    // fire rules on known facts
//    RulesEngine rulesEngine = new InferenceRulesEngine();
//    rulesEngine.fire(rules, facts);

    // create a person instance (fact)
    Person tom = new Person("Tom", 20);
    tom.setAdult(true);
    Facts facts = new Facts();
    facts.put("person", tom);

    // create rules
    SpELRuleFactory ruleFactory = new SpELRuleFactory(new JsonRuleDefinitionReader());
    Rule alcoholRule = ruleFactory.createRule(new InputStreamReader(
        Launcher.class.getClassLoader().getResourceAsStream("spel/alcohol-rule.json")));

    // create a rule set
    Rules rules = new Rules();
    rules.register(alcoholRule);
    //create a default rules engine and fire rules on known facts
    RulesEngine rulesEngine = new DefaultRulesEngine();

    System.out.println("Tom: Hi! can I have some Vodka please?");
    rulesEngine.fire(rules, facts);
  }
}