
import java.util.*;
public class Trainer extends Employees{
    String name;

    Method technique;
    int daysWorked  = 0;
    Trainer(String n, Method method){
        name = n;
        technique = method;
    }
    void trainAnimals(Inventory I, int day){
        for(int i = 0; i < I.items.size(); i++){
            Items a = I.items.get(i);
            Item item = (Item) a;
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(pet.breed == "dog"){
                    out(name + " is training a dog.\n", day);
                    Dog dog = (Dog) pet;
                    if(dog.housebroken){
                        out("The dog is already housebroken, no need to train.\n", day);
                    }
                    else{
                        out("The dog is not yet housebroken, they're going to train with " + name + "\n", day);
                        technique.train(pet, day);//strategy
                    }
                }
                if(pet.breed == "cat"){
                    out(name + " is training a cat.\n", day);
                    Cat cat = (Cat) pet;
                    if(cat.housebroken){
                        out("The cat is already housebroken, no need to train.\n", day);
                    }
                    else{
                        out("The cat is not yet housebroken, they're going to train with " + name + "\n", day);
                        technique.train(pet, day);//strategy
                    }

                }
                if(pet.breed == "ferret"){
                    out(name + " is training a ferret.\n", day);
                    Ferret ferret = (Ferret) pet;
                    if(ferret.housebroken){
                        out("The ferret is already housebroken, no need to train.\n", day);
                    }
                    else{
                        out("The ferret is not yet housebroken, they're going to train with " + name + "\n", day);
                        technique.train(pet, day);//strategy
                    }
                }
            }
        }
    }
    void feedAnimals(Inventory I, Trainer t, int day){
        Random rand = new Random();
        int num = 0;
        for(int i = 0; i < I.items.size(); i++){
            Items a = I.items.get(i);
            Item item = (Item) a;
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(pet.health){
                    num = rand.nextInt();
                    if(num%20 == 0){
                        pet.health = false;
                        out(t.name + " is feeding a " + pet.breed + ". " + t.name + " says the " + pet.breed + " has gotten sick. They're being moved to the clinic.\n", day);
                    }
                    else{
                        out(t.name + " is feeding a " + pet.breed + ".\n", day);
                    }
                }
                else if(!pet.health){
                    num = rand.nextInt();
                    if(num%4 == 0){
                        pet.health = true;
                        out(t.name + " is feeding a sick " + pet.breed + ". " + t.name + " says the " + pet.breed + " has gotten better. They're being moved to the store.\n", day);
                    }
                    else{
                        out(t.name + " is feeding a sick " + pet.breed + ". They haven't gotten better.\n", day);
                    }
                }
            }
        }
    }
}