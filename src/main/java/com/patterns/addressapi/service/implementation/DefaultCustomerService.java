package com.patterns.addressapi.service.implementation;

import com.patterns.addressapi.model.Customer;
import com.patterns.addressapi.model.CustomerRepository;
import com.patterns.addressapi.model.Address;
import com.patterns.addressapi.model.AddressRepository;
import com.patterns.addressapi.service.CustomerService;
import com.patterns.addressapi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private ViaCepService cepService;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {

        return customerRepo.findById(id).get();
    }

    @Override
    public void create(Customer c) {
        checkAddressAndSaveCustomer(c);
    }

    @Override
    public void update(Long id, Customer c) {
        Optional<Customer> foundCustomer = customerRepo.findById(id);

        if(foundCustomer.isPresent()) {
            checkAddressAndSaveCustomer(c);
        }

    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
    }

    //This method acts as a Facade strategy by hiding the complexity of searching the CEP subsystem
    private void checkAddressAndSaveCustomer(Customer c) {
        String cep = c.getAddress().getCep();

        //checks if address is in database. Adds if doesn't.
        Address address = addressRepo.findById(cep).orElseGet(() -> {
            Address e = cepService.checkCEP(cep);
            addressRepo.save(e);
            return e;
        });
        c.setAddress(address);

        customerRepo.save(c);
    }
}
