package com.prakhar.petclinic.services.map;

import com.prakhar.petclinic.model.Pet;
import com.prakhar.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapClass<Pet, Long>  implements CrudService<Pet,Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
         super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }
}
