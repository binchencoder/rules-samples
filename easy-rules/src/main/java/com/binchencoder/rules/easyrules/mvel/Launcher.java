package com.binchencoder.rules.easyrules.mvel;

import com.binchencoder.rules.easyrules.spel.Person;
import java.io.InputStreamReader;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

/**
 * Created by chenbin on 21-9-7.
 */
public class Launcher {

  public static void main(String[] args) throws Exception {
    //create a person instance (fact)
    Person tom = new Person("Tom", 14);
    Facts facts = new Facts();
    facts.put("person", tom);

    // create rules
    MVELRule ageRule = new MVELRule()
        .name("age rule")
        .description("Check if person's age is > 18 and mark the person as adult")
        .priority(1)
        .when("person.age > 18")
        .then("person.setAdult(true);");
    MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
    Rule alcoholRule = ruleFactory.createRule(new InputStreamReader(
        com.binchencoder.rules.easyrules.spel.Launcher.class.getClassLoader()
            .getResourceAsStream("mvel/alcohol-rule.yml")));

    // create a rule set
    Rules rules = new Rules();
    rules.register(ageRule);
    rules.register(alcoholRule);

    //create a default rules engine and fire rules on known facts
    RulesEngine rulesEngine = new DefaultRulesEngine();

    System.out.println("Tom: Hi! can I have some Vodka please?");
    rulesEngine.fire(rules, facts);
  }
}
