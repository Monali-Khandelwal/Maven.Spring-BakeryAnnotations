package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //annotation which combines @Controller and @ResponseBody and is used at the class level
public class BakerController {

    @Autowired
    private BakerService service;

    public BakerController(BakerService service) {
        this.service = service;
    }

    @GetMapping("/baker")  //annotation tells Spring that this code describes an endpoint that should be made available over the web.
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/baker/{id}") //acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping("/baker") //acts as a shortcut for @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Baker> create(Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PutMapping("/baker/{id}") //acts as a shortcut for @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Baker> update(@PathVariable Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping("/baker/{id}") //acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
