package com.patterns.addressapi.service.implementation;

import com.patterns.addressapi.model.Cliente;
import com.patterns.addressapi.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class DefaultClientService implements ClientService {
    @Override
    public Iterable<Cliente> findAll() {
        return null;
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public void create(Cliente c) {

    }

    @Override
    public void update(Long id, Cliente c) {

    }

    @Override
    public void delete(Long id) {

    }
}
