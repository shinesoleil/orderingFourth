package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.domain.payment.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface PaymentMapper {
  void save(@Param("info") Map<String, Object> info);

  Payment findById(@Param("orderId") String orderId);
}
