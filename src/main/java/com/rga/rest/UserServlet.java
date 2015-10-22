package com.rga.rest;

import com.rga.model.User;
import com.rga.service.UserService;
import com.rga.utilty.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by WinnieLin on 2015/10/22.
 */
@Component
@Path("user")
public class UserServlet {

    @Autowired
    private UserService userService;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response findAll() {

        String message = "Query success";
        List<User> users = userService.findAll();
        String result = JSONUtils.makeJsonText(users, message);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response find(@PathParam("id") Integer id) {

        String data = "";
        String message = "Query success";
        User user = userService.find(id);
        if (user != null) {
            data = user.toJSONString();
        }

        String result = JSONUtils.makeJsonText(user, message);
        return Response.status(200).entity(result).build();
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(User user) {
        String data = "";
        String message = "Add fail";
        boolean ok = userService.addUser(user);
        if (ok) {
            message = "Add success";
        }
        String result = JSONUtils.makeJsonText(data, message);
        return Response.status(200).entity(result).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, User user) {
        String data = "";
        String message = "Update fail";
        boolean ok = userService.updateUser(id, user);
        if (ok) {
            message = "Update success";
        }
        String result = JSONUtils.makeJsonText(data, message);
        return Response.status(200).entity(result).build();
    }
}
