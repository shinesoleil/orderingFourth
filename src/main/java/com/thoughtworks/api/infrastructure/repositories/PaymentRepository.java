package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.payment.Payment;
import com.thoughtworks.api.infrastructure.mybatis.mappers.PaymentMapper;

import javax.inject.Inject;
import java.util.Map;

public class PaymentRepository implements com.thoughtworks.api.domain.payment.PaymentRepository {
  @Inject
  PaymentMapper paymentMapper;

  @Override
  public void create(Map<String, Object> info) {
    paymentMapper.save(info);
  }

  @Override
  public Payment findById(String orderId) {
    Payment payment =  paymentMapper.findById(orderId);

    return payment;
  }
}
