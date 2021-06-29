package com.prakhar.petclinic.repositories;

import com.prakhar.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);

}
