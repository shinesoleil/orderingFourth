package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.Order.OrderRepository;
import com.thoughtworks.api.domain.product.ProductRepository;
import com.thoughtworks.api.domain.user.UserRepository;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class OrdersApiTest extends ApiSupport{

  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;

  @Inject
  OrderRepository orderRepository;

  @Test
  public void should_return_201_when_post_with_parameters() {
    productRepository.create(TestHelper.productMap("product1"));
    userRepository.create(TestHelper.userMap("user1"));

    Response post = post("users/user1/orders", TestHelper.orderMapApi("product1"));

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void should_return_200_when_get_orders() {
    Response get = get("users/user1/orders");

    assertThat(get.getStatus(), is(200));
  }

  @Test
  public void should_return_list_of_order_when_get_orders() {
    productRepository.create(TestHelper.productMap("product1"));
    userRepository.create(TestHelper.userMap("user1"));
    orderRepository.create(TestHelper.orderMap("order1", "user1", "product1"));

    Response get = get("users/user1/orders");

    assertThat(get.readEntity(List.class).size(), is(1));
  }
}
