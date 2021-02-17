package com.prakhar.petclinic.services;

import com.prakhar.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);




}
