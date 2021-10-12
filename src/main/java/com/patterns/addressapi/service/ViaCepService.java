package com.patterns.addressapi.service;

import com.patterns.addressapi.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Serviço responsável pelo consumo da API do via CEP utilizando o OpenFeign
 */
@FeignClient(name = "viaCEP", url = "http://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Endereco checkCEP(@PathVariable("cep") String cep);

}
