package com.rga.rest;

import com.rga.model.Status;
import com.rga.model.User;
import com.rga.service.AuthenticationService;
import com.rga.service.StatusService;
import com.rga.service.UserService;
import com.rga.utilty.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WinnieLin on 2015/10/22.
 */
@Component
@Path("status")
public class StatusServlet {

    @Autowired
    private StatusService statusService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @GET
    @Path("user/{id}")
    @Produces("application/json")
    public Response findByUser(@PathParam("id") Integer id) {

        String message = "Query success";
        List<Status> status = statusService.findById(id);
        String result = JSONUtils.makeJsonText(status, message);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Produces("application/json")
    public Response findAll() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        User u = userService.find(name);

        String data = "";
        String message = "Query success";
        List<Status> customers = statusService.findAll();
        List<Status> results = new ArrayList<>();
        for (Status s : customers) {
            if (s.getUserId() == u.getId())
                results.add(s);
        }

        return Response.status(200).entity(JSONUtils.makeJsonText(results, message)).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response find(@PathParam("id") Integer id) {

        String data = "";
        String message = "Query success";
        Status status = statusService.find(id);
        if (status != null) {
            //data = status;
        }

        String result = JSONUtils.makeJsonText(status, message);
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Status status) {
        String data = "";
        String message = "Add fail";
        boolean ok = statusService.addStatus(status);
        if (ok) {
            message = "Add success";
        }
        String result = JSONUtils.makeJsonText(data, message);
        return Response.status(200).entity(result).build();
    }
}
