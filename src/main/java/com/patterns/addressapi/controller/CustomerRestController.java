package com.patterns.addressapi.controller;

import com.patterns.addressapi.model.Customer;
import com.patterns.addressapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This controller is an example of the Facade design pattern, since it abstracts allt the complexity
 * of the integrations to other application in a simple and concise interface
 */
@RestController
@RequestMapping("cliente")
public class CustomerRestController {

    @Autowired //behind the curtain, spring implements autowired via a singleton
    private CustomerService service;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll() {

        return ResponseEntity.ok(service.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {
        service.create(customer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable("id") Long id, @RequestBody @Valid Customer customer) {
        service.update(id, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
