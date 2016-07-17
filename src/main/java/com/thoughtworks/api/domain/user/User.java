package com.thoughtworks.api.domain.user;

import com.thoughtworks.api.infrastructure.records.Record;
import com.thoughtworks.api.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class User implements Record {
  private String id;
  private String name;

  public User() {
  }

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public Map<String, Object> toRefJson(Routes routes) {
    return new HashMap<String, Object>() {{
      put("id", getId());
      put("uri", "users/" + getId());
      put("name", getName());
    }};
  }

  @Override
  public Map<String, Object> toJson(Routes routes) {
    return toRefJson(routes);
  }
}
