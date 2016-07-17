package com.thoughtworks.api.domain.Order;

import com.thoughtworks.api.infrastructure.records.Record;
import com.thoughtworks.api.web.jersey.Routes;

import java.util.Map;

public class OrderItem implements Record {
  private String orderId;
  private String productId;
  private int quantity;

  public OrderItem() {

  }

  public OrderItem(String orderId, String productId, int quantity) {
    this.orderId = orderId;
    this.productId = productId;
    this.quantity = quantity;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
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
