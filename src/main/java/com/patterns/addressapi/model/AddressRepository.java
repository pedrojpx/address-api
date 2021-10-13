package com.patterns.addressapi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //@Repository is a form in which spring implements the Strategy pattern
public interface AddressRepository extends CrudRepository<Address, String> {
}
