package com.thoughtworks.api.web;

import com.thoughtworks.api.infrastructure.repositories.OrderRepository;
import com.thoughtworks.api.infrastructure.repositories.ProductRepository;
import com.thoughtworks.api.infrastructure.repositories.UserRepository;
import com.thoughtworks.api.support.ApiSupport;
import com.thoughtworks.api.support.ApiTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport{
  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;

  @Inject
  OrderRepository orderRepository;

  @Test
  public void should_return_201_when_post_payment_with_parameters() {
    productRepository.create(TestHelper.productMap("product1"));
    userRepository.create(TestHelper.userMap("user1"));
    orderRepository.create(TestHelper.orderMap("order1", "user1", "product1"));

    Response post = post("users/user1/orders/order1/payment", TestHelper.paymentMapApi());

    assertThat(post.getStatus(), is(201));
  }
}
