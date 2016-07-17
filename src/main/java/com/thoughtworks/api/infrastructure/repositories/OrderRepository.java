package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.Order.Order;
import com.thoughtworks.api.infrastructure.mybatis.mappers.OrderMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class OrderRepository implements com.thoughtworks.api.domain.Order.OrderRepository {
  @Inject
  OrderMapper orderMapper;

  @Override
  public void create(Map<String, Object> info) {
    orderMapper.save(info);
    orderMapper.saveItems((List<Map<String,Object>>) info.get("order_items"));
  }

  @Override
  public Order findById(String orderId, String userId) {
    return orderMapper.findById(orderId, userId);
  }
}
