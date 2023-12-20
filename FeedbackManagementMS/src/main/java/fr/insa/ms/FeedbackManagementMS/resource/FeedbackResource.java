package fr.insa.ms.FeedbackManagementMS.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.insa.ms.FeedbackManagementMS.model.Feedback;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackResource {

    @Autowired
	private RestTemplate restTemplate;
	//private final RestTemplate restTemplate;
    
    private static final List<Feedback> feedbacks = new ArrayList<>();

    /*
    @Autowired
    public FeedbackResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    */

    @PostMapping("/add")
    public ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {
        boolean userExists = restTemplate.getForObject("http://PersonManagementService/api/persons/exists/" + feedback.getUserId(), Boolean.class);
        
        boolean requestExists = restTemplate.getForObject("http://RequestManagementService/api/requests/exists/" + feedback.getRequestId(), Boolean.class);
        //System.out.println(userExists+ " "+ requestExists);
       
        if (userExists && requestExists) {
            feedbacks.add(feedback);
            return ResponseEntity.ok("Feedback added successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid user or request");
        }
    }
    
    @GetMapping("/all")
    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }

}
