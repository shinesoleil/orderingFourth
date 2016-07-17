package com.thoughtworks.api.domain.payment;

import com.thoughtworks.api.infrastructure.records.Record;
import com.thoughtworks.api.web.jersey.Routes;

import java.util.Date;
import java.util.Map;

public class Payment implements Record {
  private String orderId;
  private String payType;
  private double amount;
  private Date payTime;

  public Payment() {
  }

  public Payment(String orderId, String payType, double amount, Date payTime) {
    this.orderId = orderId;
    this.payType = payType;
    this.amount = amount;
    this.payTime = payTime;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getPayType() {
    return payType;
  }

  public double getAmount() {
    return amount;
  }

  public Date getPayTime() {
    return payTime;
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return null;
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return null;
  }
}
