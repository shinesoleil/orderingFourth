package com.thoughtworks.api.domain.Order;

import java.util.Map;

public interface OrderRepository {
  void create(Map<String, Object> info);

  Order findById(String orderId, String userId);
}
