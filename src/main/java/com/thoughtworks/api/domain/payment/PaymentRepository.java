package com.thoughtworks.api.domain.payment;

import java.util.Map;

public interface PaymentRepository {
  void create(Map<String, Object> info);

  Payment findById(String orderId);
}
