package fr.insa.soa.RestProject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("/requests")
public class RequestsResource {
    private static Map<Integer, Requests> requestsDB = new HashMap<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRequest(Requests request) {
        requestsDB.put(request.getRequest_id(), request);
        System.out.println("Request ID " + request.getRequest_id() + " added successfully.");
        return Response.status(Response.Status.CREATED).entity(request).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRequest(@PathParam("id") int requestId) {
        if (requestsDB.containsKey(requestId)) {
            requestsDB.remove(requestId);
            System.out.println("Request ID " + requestId + " deleted successfully.");
            return Response.status(Response.Status.OK).build();
        } else {
            System.out.println("Request ID " + requestId + " not found.");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}/approve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveRequest(@PathParam("id") int requestId, Person approver) {
        Requests request = requestsDB.get(requestId);
        if (request != null && approver instanceof Administrator) {
            request.setState("Validated");
            System.out.println("Request ID " + requestId + " approved by " + approver.getName() + ".");
            return Response.status(Response.Status.OK).entity(request).build();
        } else if (request != null) {
            System.out.println("Approval failed: Only administrators can approve requests.");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else {
            System.out.println("Request ID " + requestId + " not found.");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRequests() {
        return Response.status(Response.Status.OK).entity(new ArrayList<>(requestsDB.values())).build();
    }

}
