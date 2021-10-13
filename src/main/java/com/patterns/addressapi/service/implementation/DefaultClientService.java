package com.patterns.addressapi.service.implementation;

import com.patterns.addressapi.model.Cliente;
import com.patterns.addressapi.model.ClienteRepository;
import com.patterns.addressapi.model.Endereco;
import com.patterns.addressapi.model.EnderecoRepository;
import com.patterns.addressapi.service.ClientService;
import com.patterns.addressapi.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultClientService implements ClientService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private EnderecoRepository enderecoRepo;

    @Autowired
    private ViaCepService cepService;

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findById(Long id) {

        return clienteRepo.findById(id).get();
    }

    @Override
    public void create(Cliente c) {
        checkAddressAndSaveCustomer(c);
    }

    @Override
    public void update(Long id, Cliente c) {
        Optional<Cliente> clienteBd = clienteRepo.findById(id);

        if(clienteBd.isPresent()) {
            checkAddressAndSaveCustomer(c);
        }

    }

    @Override
    public void delete(Long id) {
        clienteRepo.deleteById(id);
    }

    //Este método age como uma fachada ao esconder a complexidade de se buscar o subsistema
    private void checkAddressAndSaveCustomer(Cliente c) {
        String cep = c.getEndereco().getCep();

        //checks if address is in database. Adds if doesn't.
        Endereco address = enderecoRepo.findById(cep).orElseGet(() -> {
            Endereco e = cepService.checkCEP(cep);
            enderecoRepo.save(e);
            return e;
        });
        c.setEndereco(address);

        clienteRepo.save(c);
    }
}
