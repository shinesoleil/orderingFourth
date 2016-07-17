package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.payment.Payment;
import com.thoughtworks.api.domain.payment.PaymentRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("users/{userId}/orders/{orderId}/payment")
public class PaymentApi {

  @Context
  PaymentRepository paymentRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createPayment(HashMap<String, Object> info,
                                @PathParam("orderId") String orderId) {
    info.put("order_id", orderId);

    paymentRepository.create(info);
    Payment payment = paymentRepository.findById(orderId);

    if (payment != null) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }
}
