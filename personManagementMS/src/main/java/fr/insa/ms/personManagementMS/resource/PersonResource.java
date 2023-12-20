package fr.insa.ms.personManagementMS.resource;

import fr.insa.ms.personManagementMS.model.Admin;
import fr.insa.ms.personManagementMS.model.Person;
import fr.insa.ms.personManagementMS.model.User;
import fr.insa.ms.personManagementMS.model.Volunteer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonResource {
    
	private static final List<Person> persons = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();
    private static final List<Admin> admins = new ArrayList<>();
    private static final List<Volunteer> volunteers = new ArrayList<>();

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok("User added successfully");
    }
    
    @PostMapping("/addUsers")
    public ResponseEntity<?> addUsers(@RequestBody List<User> userList) {
        users.addAll(userList);
        return ResponseEntity.ok("Users added successfully");
    }

    @PostMapping("/addVolunteer")
    public ResponseEntity<?> addVolunteer(@RequestBody Volunteer volunteer) {
        volunteers.add(volunteer);
        return ResponseEntity.ok("Volunteer added successfully");
    }

    @PostMapping("/addVolunteers")
    public ResponseEntity<?> addVolunteers(@RequestBody List<Volunteer> userList) {
    	volunteers.addAll(userList);
        return ResponseEntity.ok("Volunteers added successfully");
    }
    
    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        admins.add(admin);
        return ResponseEntity.ok("Admin added successfully");
    }

    @PostMapping("/addAdmins")
    public ResponseEntity<?> addAdmins(@RequestBody List<Admin> userList) {
    	admins.addAll(userList);
        return ResponseEntity.ok("Admins added successfully");
    }
    
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getAdmins")
    public ResponseEntity<List<Admin>> getAdmins() {
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/getVolunteers")
    public ResponseEntity<List<Volunteer>> getVolunteers() {
        return ResponseEntity.ok(volunteers);
    }
    
    @GetMapping("/exists/{userId}")
    public ResponseEntity<Boolean> checkUserExists(@PathVariable int userId) {
        boolean userExists = users.stream()
            .anyMatch(person -> person.getId() == userId);
        return ResponseEntity.ok(userExists);
    }


}
