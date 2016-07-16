package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.product.Product;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
  @Inject
  ProductRepository productRepository;

  @Test
  public void create_product_with_parameters_and_find_product_by_product_id() {
    productRepository.create(TestHelper.productMap("1"));
    Product product = productRepository.findById("1");

    assertThat(product.getId(), is("1"));
    assertThat(product.getName(), is("desk"));
    assertThat(product.getDescription(), is("black"));
    assertThat(product.getPrice(), is(610.00));
  }

  @Test
  public void should_find_all_products() {
    productRepository.create(TestHelper.productMap("1"));
    productRepository.create(TestHelper.productMap("2"));

    List<Product> productList = productRepository.find();

    assertThat(productList.size(), is(2));
    assertThat(productList.get(0).getId(), is("1"));

  }
}
