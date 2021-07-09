package com.prakhar.petclinic.services.map;

import com.prakhar.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerID=1L;
    final String lastName= "Torres";
    @BeforeEach
    void setUp() {
          ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
          ownerServiceMap.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet= ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner= ownerServiceMap.findById(ownerID);
        assertEquals(1L,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id=2L;
        Owner owner2= Owner.builder().id(id).build();

        Owner savedOwner= ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saveOwner= ownerServiceMap.save(Owner.builder().build());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerID));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerID);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner Torres = ownerServiceMap.findByLastName(lastName);
        assertNotNull(Torres);
        assertEquals(ownerID,Torres.getId());
        assertEquals("Torres",Torres.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner olo = ownerServiceMap.findByLastName("Olo");
        assertNull(olo);

    }
}