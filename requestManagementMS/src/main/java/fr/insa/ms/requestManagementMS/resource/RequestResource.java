package fr.insa.ms.requestManagementMS.resource;

import fr.insa.ms.requestManagementMS.model.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requests")
public class RequestResource {

    private static final List<Request> requests = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity<?> addRequest(@RequestBody Request request) {
        requests.add(request);
        return ResponseEntity.ok("Request added successfully");
    }

    @PostMapping("/addrequests")
    public ResponseEntity<?> addRequests(@RequestBody List<Request> newRequests) {
        requests.addAll(newRequests);
        return ResponseEntity.ok("Requests added successfully");
    }

    @GetMapping("/all")
    public List<Request> getAllRequests() {
        return requests;
    }
    
    @PutMapping("/validate/{id}")
    public ResponseEntity<?> validateRequest(@PathVariable int id) {
        Optional<Request> requestOptional = requests.stream()
                .filter(request -> request.getRequestId() == id)
                .findFirst();

        if (requestOptional.isPresent()) {
            Request request = requestOptional.get();
            request.setState(Request.State.VALIDATED);
            return ResponseEntity.ok("Request validated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/reject/{id}")
    public ResponseEntity<?> rejectRequest(@PathVariable int id, @RequestBody String reason) {
        Optional<Request> requestOptional = requests.stream()
                .filter(request -> request.getRequestId() == id)
                .findFirst();

        if (requestOptional.isPresent()) {
            Request request = requestOptional.get();
            request.setState(Request.State.REJECTED);
            return ResponseEntity.ok("Request rejected: " + reason);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/choose/{id}")
    public ResponseEntity<?> chooseRequest(@PathVariable int id) {
        Optional<Request> foundRequest = requests.stream()
            .filter(request -> request.getRequestId() == id)
            .findFirst();

        if (foundRequest.isPresent()) {
            Request request = foundRequest.get();
            request.setState(Request.State.CHOSEN);
            return ResponseEntity.ok("Request chosen successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/realize/{id}")
    public ResponseEntity<?> realizeRequest(@PathVariable int id) {
        Optional<Request> foundRequest = requests.stream()
            .filter(request -> request.getRequestId() == id)
            .findFirst();

        if (foundRequest.isPresent()) {
            Request request = foundRequest.get();
            request.setState(Request.State.REALIZED);
            return ResponseEntity.ok("Request realized successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/exists/{requestId}")
    public ResponseEntity<Boolean> checkRequestExists(@PathVariable int requestId) {
        boolean requestExists = requests.stream()
            .anyMatch(request -> request.getRequestId() == requestId);
        return ResponseEntity.ok(requestExists);
    }


}
