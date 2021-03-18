package com.prakhar.petclinic.bootstrap;

import com.prakhar.petclinic.model.Owner;
import com.prakhar.petclinic.model.PetType;
import com.prakhar.petclinic.model.Vet;
import com.prakhar.petclinic.services.OwnerService;
import com.prakhar.petclinic.services.PetTypeService;
import com.prakhar.petclinic.services.VetService;
import com.prakhar.petclinic.services.map.OwnerServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


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
        dog.setName("Doggy");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        dog.setName("Meow");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1= new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston" );

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners---");

        Vet vet1= new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets---");
    }
}
