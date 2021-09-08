package com.binchencoder.rules.easyrules.demo;

import java.io.InputStreamReader;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.JsonRuleDefinitionReader;
import org.mvel2.ParserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 加载rule文件
 */
@Component
public class ConfigRules {

  @Autowired
  private MyService myService;

  public Rules fetchConfigRules() throws Exception {
//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//        MySpringAppConfig.class);
//    BeanResolver beanResolver = new SimpleBeanResolver(applicationContext);

    ParserContext context = new ParserContext();
    context.addImport("myService", MyService.class);
    MVELRuleFactory ruleFactory = new MVELRuleFactory(new JsonRuleDefinitionReader(), context);
    Rules jsonRules = ruleFactory.createRules(new InputStreamReader(
        Launcher.class.getClassLoader().getResourceAsStream("mvel/demo-rule.json")));
    return jsonRules;
  }
}
