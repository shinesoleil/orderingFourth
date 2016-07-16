package com.thoughtworks.api.infrastructure.mybatis.mappers;

import com.thoughtworks.api.domain.product.Product;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ProductMapper {
  void save(@Param("info") Map<String, Object> info);

  Product findById(@Param("id") String id);
}
