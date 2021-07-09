package com.prakhar.petclinic.services.springdatajpa;

import com.prakhar.petclinic.model.Owner;
import com.prakhar.petclinic.repositories.OwnerRepository;
import com.prakhar.petclinic.repositories.PetRepository;
import com.prakhar.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Hulk";
    public static final long ID = 1L;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;


    Owner returnOwner;
    @BeforeEach
    void Setup() {
        returnOwner= Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {

        Owner one= Owner.builder().id(ID).build();
        Owner two= Owner.builder().id(2L).build();
        Set<Owner> ownerSet= new HashSet<>();
        ownerSet.add(one);
        ownerSet.add(two);
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> ownerSetJpa= ownerSDJpaService.findAll();
        assertEquals(2,ownerSetJpa.size());
        verify(ownerRepository,times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner toCheck= ownerSDJpaService.findById(ID);
        assertNotNull(toCheck);
        assertEquals(ID,toCheck.getId());


    }

    @Test
    void save() {
        Owner ownerToSave= Owner.builder().id(4L).build();
        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner savedOwner= ownerSDJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ID);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        Owner savedOwner= Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(savedOwner);

        Owner hulk= ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, hulk.getLastName());
        verify(ownerRepository,times(1)).findByLastName(any());

    }
}