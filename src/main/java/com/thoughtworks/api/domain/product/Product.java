package com.thoughtworks.api.domain.product;

import com.thoughtworks.api.infrastructure.records.Record;
import com.thoughtworks.api.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Product implements Record{
  private String id;
  private String name;
  private String description;
  private double price;

  public Product() {

  }

  public Product(String id, String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }


  public Map<String, Object> toRefJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("id", getId());
      put("uri", "products/" + getId());
      put("name", getName());
      put("description", getDescription());
      put("price", getPrice());
    }};
  }


  public Map<String, Object> toJson(Routes routes) {
    return toRefJson(routes);
  }

}
