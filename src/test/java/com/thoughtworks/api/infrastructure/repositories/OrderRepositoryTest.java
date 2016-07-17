package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.Order.Order;
import com.thoughtworks.api.domain.Order.OrderRepository;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class OrderRepositoryTest {
  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;

  @Inject
  OrderRepository orderRepository;

  @Test
  public void should_create_order_with_parameters_and_find_by_user_id_and_order_id() {
    productRepository.create(TestHelper.productMap("product1"));
    userRepository.create(TestHelper.userMap("user1"));


    orderRepository.create(TestHelper.orderMap("order1", "user1", "product1"));

    Order order = orderRepository.findById("order1", "user1");

    assertThat(order.getId(), is("order1"));
    assertThat(order.getOrderItems().size(), is(1));
  }
}
