package com.prakhar.petclinic.bootstrap;

import com.prakhar.petclinic.model.Owner;
import com.prakhar.petclinic.model.Pet;
import com.prakhar.petclinic.model.PetType;
import com.prakhar.petclinic.model.Vet;
import com.prakhar.petclinic.services.OwnerService;
import com.prakhar.petclinic.services.PetTypeService;
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

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


//    public DataLoader() {
//        ownerService= new OwnerServiceMap();
////        if( instanceof OwnerService){
////            System.out.println("true");
////        }else{
////            System.out.println("false");
////        }
////        System.out.println("inside constructor");
//        vetService= new VetServiceMap();
//        //printhirarchy();
//       // printhirarchy1();
//    }

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

        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Martin");
        vet2.setLastName("Tyler");

        vetService.save(vet2);

        System.out.println("Loaded vets---");
    }
}
