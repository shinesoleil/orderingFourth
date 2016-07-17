package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.Order.Order;
import com.thoughtworks.api.domain.Order.OrderRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("users/{userId}/orders")
public class OrdersApi {
  @Context
  OrderRepository orderRepository;

  @POST
  public Response createOrder(HashMap<String, Object> info,
                              @PathParam("userId") String userId) {
    String orderId = UUID.randomUUID().toString().replaceAll("-", "");

    info.put("id", orderId);
    info.put("user_id", userId);
    List<HashMap<String, Object>> itemsInfo = (ArrayList<HashMap<String, Object>>) info.get("order_items");
    for (Map<String, Object> itemInfo: itemsInfo) {
      itemInfo.put("order_id", orderId);
    }
    info.replace("order_items", itemsInfo);

    orderRepository.create(info);
    Order order = orderRepository.findById(orderId, userId);

    if (order != null) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Order> findOrders() {
    return orderRepository.find();
  }
}
