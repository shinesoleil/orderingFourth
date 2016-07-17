package com.thoughtworks.api.web;

import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class UserApiTest extends ApiSupport{

  @Test
  public void should_return_201_when_post_user() {
    Map<String, Object> info = new HashMap<>();

    Response post = post("users", info);

    assertThat(post.getStatus(), is(201));
  }
}