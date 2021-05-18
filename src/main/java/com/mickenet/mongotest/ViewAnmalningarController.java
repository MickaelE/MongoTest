package com.mickenet.mongotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api")
public class ViewAnmalningarController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/registration/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> getRegistration(@PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(registrationService.getReregistrationById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration){
        return new ResponseEntity<>(registrationService.createRegistration(registration), HttpStatus.CREATED);
    }

    @PutMapping(value = "/registration/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> updateRegistration(@RequestBody Registration registration, @PathVariable(value = "id") UUID id){
        return new ResponseEntity<Registration>(registrationService.updateRegistration(registration), HttpStatus.OK);
    }
    @GetMapping(value = "/registration/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Registration>> getRegistrations(){
        return new ResponseEntity<List<Registration>>(registrationService.getReregistration(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/registration/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Registration> deleteRegistration(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(registrationService.deleteRegistrationById(id), HttpStatus.OK);
    }
}
