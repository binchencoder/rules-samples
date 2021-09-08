package com.binchencoder.rules.easyrules.demo;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.util.Lists;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  public RulesEngine myEngine;

  @Autowired
  public ConfigRules configRules;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Object info() throws Exception {
    try {
      Rules rules = configRules.fetchConfigRules();

      // create a person instance (fact)
      Facts facts = new Facts();
      FormCondition formCond = new FormCondition();
      Map<String, Object> params = new HashMap<>();
      params.put("numberField", 18L);
      params.put("selectField", Lists.newArrayList("111", "222"));
      formCond.setParams(params);
      facts.put("formCond", formCond);

      myEngine.fire(rules, facts);

      System.out.println(formCond);
    } catch (Exception e) {
      e.printStackTrace();
      return e;
    }

    return null;
  }
}
