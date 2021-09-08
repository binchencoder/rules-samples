package com.binchencoder.rules.easyrules.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyService {

  public static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

  public static void doAction(FormCondition condition) {
    LOGGER.info("------------do action1------------");
    LOGGER.info(condition.toString());
  }
}
