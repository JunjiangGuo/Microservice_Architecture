package fr.insa.soa.RestProject;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("admin")
public class AdminRessource {
    //private static Map<Integer, Requests> requestsDB = new HashMap<>();

	@POST
	@Path("/{idAdmin}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAdmin(Administrator adminNouv) {
		System.out.println("Admin " + adminNouv.getId()+ " "+ adminNouv.getName()+ " "+adminNouv.getSurname()+" added!");	
	}

}
