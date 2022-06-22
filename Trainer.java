
import java.util.*;
public class Trainer extends Employees{
    String name;

    Method technique;
    int daysWorked  = 0;
    Trainer(String n, Method method){
        name = n;
        technique = method;
    }
    void trainAnimals(Inventory I){
        for(int i = 0; i < I.items.size(); i++){
            Item item = I.items.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(pet.breed == "dog"){
                    Dog dog = (Dog) pet;
                    if(dog.housebroken){
                        System.out.println("The dog is housebroken, but they're going to train more with " + name);
                    }
                    else{
                        System.out.println("The dog is not yet housebroken, they're going to train with " + name);
                    }
                    technique.train(pet);
                }
                if(pet.breed == "cat"){
                    Cat cat = (Cat) pet;
                    if(cat.housebroken){
                        System.out.println("The cat is housebroken, but they're going to train more with " + name);
                    }
                    else{
                        System.out.println("The cat is not yet housebroken, they're going to train with " + name);
                    }
                    technique.train(pet);
                }
                if(pet.breed == "ferret"){
                    Ferret ferret = (Ferret) pet;
                    if(ferret.housebroken){
                        System.out.println("The ferret is housebroken, but they're going to train more with " + name);
                    }
                    else{
                        System.out.println("The ferret is not yet housebroken, they're going to train with " + name);
                    }
                    technique.train(ferret);
                }
            }
        }
    }
    void feedAnimals(Inventory I, Trainer t){
        Random rand = new Random();
        int num = 0;
        for(int i = 0; i < I.items.size(); i++){
            Item item = I.items.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(pet.health){
                    num = rand.nextInt();
                    if(num%20 == 0){
                        pet.health = false;
                        System.out.println(t.name + " is feeding a " + pet.breed + ". " + t.name + " says the " + pet.breed + " has gotten sick. They're being moved to the clinic.");
                    }
                    else{
                        System.out.println(t.name + " is feeding a " + pet.breed + ".");
                    }
                }
                else if(!pet.health){
                    num = rand.nextInt();
                    if(num%4 == 0){
                        pet.health = true;
                        System.out.println(t.name + " is feeding a sick " + pet.breed + ". " + t.name + " says the " + pet.breed + " has gotten better. They're being moved to the store.");
                    }
                    else{
                        System.out.println(t.name + " is feeding a sick " + pet.breed + ". They haven't gotten better.");
                    }
                }
            }
        }
    }
}