
import java.util.*;
public class Trainer extends Employees{
    String name;
    int daysWorked  = 0;
    Trainer(String n){
        name = n;
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