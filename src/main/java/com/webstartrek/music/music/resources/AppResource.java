package com.webstartrek.music.music.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class AppResource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
