package com.thoughtworks.api.web;

import com.thoughtworks.api.domain.user.User;
import com.thoughtworks.api.domain.user.UserRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.UUID;

@Path("users")
public class UsersApi {

  @Context
  UserRepository userRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(HashMap<String, Object> info) {
    String id = UUID.randomUUID().toString().replaceAll("-", "");
    info.put("id", id);

    userRepository.create(info);
    User user = userRepository.findById(id);

    if (user != null) {
      return Response.status(201).build();
    } else {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }
}
