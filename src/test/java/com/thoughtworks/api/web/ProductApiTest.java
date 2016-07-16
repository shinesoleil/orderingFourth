package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.product.ProductRepository;
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
public class ProductApiTest extends ApiSupport{

  @Inject
  ProductRepository productRepository;

  @Test
  public void should_return_201_when_post_product_with_parameters() {
    Response post = post("products", TestHelper.productMapApi());

    assertThat(post.getStatus(), is(201));
  }

  @Test
  public void should_return_list_of_when_get_products() {
    productRepository.create(TestHelper.productMap("1"));

    Response get = get("products");

    assertThat(get.getStatus(), is(200));
    assertThat(get.readEntity(List.class).size(), is(1));
  }

  @Test

}
