package com.patterns.addressapi.service;

import com.patterns.addressapi.model.Cliente;

/**
 * Esta interface define o padrão Strategy para Cliente, assim podemos ter várias implementações desta interface
 * para facilmente modificar a forma como este service tratará o cliente
 */
public interface ClientService {

    Iterable<Cliente> findAll();

    Cliente findById(Long id);

    void create(Cliente c);

    void update(Long id, Cliente c);

    void delete(Long id);
}
