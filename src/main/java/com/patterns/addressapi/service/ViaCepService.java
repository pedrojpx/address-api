package com.patterns.addressapi.service;

import com.patterns.addressapi.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Service that accesses the CEP API through use of OpenFeign
 */
@FeignClient(name = "viaCEP", url = "http://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Address checkCEP(@PathVariable("cep") String cep);

}
