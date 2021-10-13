package com.patterns.addressapi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //por trás dos panos, o @Repository trata-se de um Strategy pattern
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
