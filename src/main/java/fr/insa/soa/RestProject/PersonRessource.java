package fr.insa.soa.RestProject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/persons")
public class PersonRessource {
    private static ConcurrentHashMap<Integer, Person> persons = new ConcurrentHashMap<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        if (person != null && person.getId() != 0 && !persons.containsKey(person.getId())) {
            persons.put(person.getId(), person);
            System.out.println("Added: " + person);
            return Response.status(Response.Status.CREATED).entity(person).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
    	if (persons.containsKey(id)) {
            Person person = persons.remove(id);
            System.out.println("Deleted: " + person);
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        List<Person> personList = new ArrayList<>(persons.values());
        Map<String, Object> response = new HashMap<>();
        response.put("persons", personList);
        response.put("count", personList.size());

        return Response.status(Response.Status.OK).entity(response).build();
    }

}
