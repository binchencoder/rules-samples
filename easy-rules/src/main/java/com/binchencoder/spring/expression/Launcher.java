package com.binchencoder.spring.expression;

import java.util.List;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * Created by chenbin on 21-9-7.
 */
public class Launcher {

  public static void main(String[] args) {
    ExpressionParser parser = new SpelExpressionParser();
    EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

    List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
  }
}
