package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.product.Product;
import com.thoughtworks.api.domain.product.ProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.UUID;

@Path("products")
public class ProductApi {

  @Context
  ProductRepository productRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(HashMap<String,Object> info) {
    String id = UUID.randomUUID().toString().replaceAll("-", "");
    info.put("id", id);

    productRepository.create(info);
    Product product = productRepository.findById(id);

    if (product != null) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }

  @GET
  public Response findProducts() {
    return Response.status(200).build();
  }
}
