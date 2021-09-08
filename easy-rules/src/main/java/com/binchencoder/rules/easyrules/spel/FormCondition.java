package com.binchencoder.rules.easyrules.spel;

import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by chenbin on 21-9-7.
 */
public class FormCondition {

  public Map<String, Object> params;

  public String nextNodeId;

  public Map<String, Object> getParams() {
    return params;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }

  public String getNextNodeId() {
    return nextNodeId;
  }

  public void setNextNodeId(String nextNodeId) {
    this.nextNodeId = nextNodeId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
