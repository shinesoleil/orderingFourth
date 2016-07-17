package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.payment.Payment;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class PaymentRepositoryTest {
  @Inject
  ProductRepository productRepository;

  @Inject
  UserRepository userRepository;

  @Inject
  OrderRepository orderRepository;

  @Inject
  PaymentRepository paymentRepository;

  @Test
  public void should_create_payment_with_parameters_and_get_payment_by_user_id_and_order_id() {
    productRepository.create(TestHelper.productMap("product1"));
    userRepository.create(TestHelper.userMap("user1"));
    orderRepository.create(TestHelper.orderMap("order1", "user1", "product1"));

    paymentRepository.create(TestHelper.paymentMap("order1"));

    Payment payment = paymentRepository.findById("order1");

    assertThat(payment.getOrderId(), is("order1"));
  }
}
