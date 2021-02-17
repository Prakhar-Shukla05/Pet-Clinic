package com.prakhar.petclinic.services;

import com.prakhar.petclinic.model.Owner;
import com.prakhar.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
