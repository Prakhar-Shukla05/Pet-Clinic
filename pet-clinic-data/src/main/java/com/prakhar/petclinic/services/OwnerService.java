package com.prakhar.petclinic.services;

import com.prakhar.petclinic.model.Owner;
import com.prakhar.petclinic.model.Person;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);




}
