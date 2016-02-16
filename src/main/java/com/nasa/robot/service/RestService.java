package com.nasa.robot.service;

import com.nasa.robot.models.PlanetArea;
import com.nasa.robot.models.Robot;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/{commands}")
public class RestService {

    @POST
    @Produces("text/html")
    public Response instructions(@PathParam("commands") String commands) {
        try {
            Robot robot = new Robot(new PlanetArea());
            if(robot.isValidCommands(commands)){
                robot.execute(commands);
                return Response.ok(robot.getCoordinates(), "text/html").build();
            }else
                throw new IllegalArgumentException("Invalid commands.");
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
