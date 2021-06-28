package com.prakhar.petclinic.services.map;

import com.prakhar.petclinic.model.Specialty;
import com.prakhar.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceMap extends AbstractMapClass<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
         super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
