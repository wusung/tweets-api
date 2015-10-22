package com.rga.rest;

import com.rga.service.AuthenticationService;
import com.rga.utilty.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.StringTokenizer;

/**
 * @author Green
 * @since 2015/10/05
 */
@Component
@Path("/logout")
public class LoginServlet {

    @Autowired
    AuthenticationService authenticationService;

    @GET
    public Response logout(@Context HttpHeaders headers) {
        String data = "";
        String username = getUsername(headers);
        boolean logout = authenticationService.logout(username);
        if (logout) {
            data = "Logout success";
        }

        String result = JSONUtils.makeJsonText(data);
        return Response.status(200).entity(result).build();
    }

    public String getUsername(HttpHeaders headers) {
        String username = "";
        String authHeader = headers.getRequestHeader("Authorization").get(0);
        if (authHeader != null) {
            StringTokenizer st = new StringTokenizer(authHeader);
            if (st.hasMoreTokens()) {
                String basic = st.nextToken();

                if (basic.equalsIgnoreCase("Basic")) {
                    String credentials = new String(Base64.getDecoder().decode((st.nextToken())));
                    //LOG.debug("Credentials: " + credentials);
                    int p = credentials.indexOf(":");
                    if (p != -1) {
                        username = credentials.substring(0, p).trim();
                    }
                }
            }
        }

        return username;
    }
}
