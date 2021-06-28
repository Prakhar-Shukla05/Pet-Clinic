package com.prakhar.petclinic.bootstrap;

import com.prakhar.petclinic.model.*;
import com.prakhar.petclinic.services.OwnerService;
import com.prakhar.petclinic.services.PetTypeService;
import com.prakhar.petclinic.services.SpecialtyService;
import com.prakhar.petclinic.services.VetService;
import com.prakhar.petclinic.services.map.OwnerServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }



    public void printhirarchy(){
        Class c1=OwnerServiceMap.class;;
        System.out.println(c1.getName());
        Class sc=c1.getSuperclass();
        while(sc!=null){
            System.out.println(sc.getName());
            c1=sc;
            sc=c1.getSuperclass();
        }
        Class[] interfaces=c1.getInterfaces();
        System.out.println(interfaces);
        System.out.println(interfaces.length);
        for(Class iface:interfaces){
            System.out.println("interfaces is" + iface.getName());
        }
    }


    @Override
    public void run(String... args) throws Exception {

        int count= petTypeService.findAll().size();
        if(count==0)
           loadData();
    }

    private void loadData() {
        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry= specialtyService.save(dentistry);

        Owner owner1= new Owner();
        owner1.setFirstName("Shaliesh");
        owner1.setLastName("Shukla" );
        owner1.setAddress("192-C Friends Colony");
        owner1.setCity("Etawah");
        owner1.setTelephone("9423123421");
        Pet shaileshsPet= new Pet();
        shaileshsPet.setPetType(savedDogPetType);
        shaileshsPet.setOwner(owner1);
        shaileshsPet.setBirthDate(LocalDate.now());
        shaileshsPet.setName("Vikas");
        owner1.getPets().add(shaileshsPet);
        ownerService.save(owner1);


        Owner owner2= new Owner();
        owner2.setFirstName("Axel");
        owner2.setLastName("Blaze");
        owner2.setAddress("50/B Ashok Nagar");
        owner2.setCity("Etawah");
        owner2.setTelephone("9454123421");
        Pet axelsPet = new Pet();
        axelsPet.setPetType(savedCatPetType);
        axelsPet.setOwner(owner2);
        axelsPet.setBirthDate(LocalDate.now());
        axelsPet.setName("Prerna");
        owner2.getPets().add(axelsPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners---");

        Vet vet1= new Vet();
        vet1.setFirstName("Alan");
        vet1.setLastName("Smith");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Martin");
        vet2.setLastName("Tyler");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets---");
    }
}
