package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.domain.Order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
  void save(@Param("info") Map<String, Object> info);

  void saveItems(@Param("itemsInfo") List<Map<String, Object>> info);

  Order findById(@Param("orderId") String orderId,
                 @Param("userId") String userId);
}
