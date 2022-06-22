import java.util.*;
public class Positive implements Method{
    public void train(Pet item) {
        Random rand = new Random();
        int num = rand.nextInt(2);
        if(item.breed == "dog"){
            Dog dog = (Dog) item;
            if(num == 0){
                if(!dog.housebroken){
                    dog.housebroken = true;
                    System.out.println("The negative reinforcement training worked, the dog is now housebroken.");
                }
            }
        }
        if(item.breed == "ferret"){
            Ferret ferret = (Ferret) item;
            if(num == 0){
                if(!ferret.housebroken){
                    ferret.housebroken = true;
                    System.out.println("The negative reinforcement training worked, the ferret is now housebroken.");
                }
            }
        }
        if(item.breed == "cat"){
            Cat cat = (Cat) item;
            if(num == 0){
                if(!cat.housebroken){
                    cat.housebroken = true;
                    System.out.println("The negative reinforcement training worked, the cat is now housebroken.");
                }
            }
        }
    }
}