import java.util.*;
public class Haphazard implements Method{
    public void train(Pet item){
        Random rand = new Random();
        int num = rand.nextInt(10);
        if(item.breed == "dog"){
            Dog dog = (Dog) item;
            if(num == 0){
                if(dog.housebroken){
                    dog.housebroken = false;
                    System.out.println("The haphazard training didn't work, the dog is no longer housebroken.");
                }
                else{
                    dog.housebroken = true;
                    System.out.println("The haphazard training worked, the dog is now housebroken.");
                }
            }
        }
        if(item.breed == "ferret"){
            Ferret ferret = (Ferret) item;
            if(num == 0){
                if(ferret.housebroken){
                    ferret.housebroken = false;
                    System.out.println("The haphazard training didn't work, the " + item.breed + " is no longer housebroken.");
                }
                else{
                    ferret.housebroken = true;
                    System.out.println("The haphazard training worked, the " + item.breed + " is now housebroken.");
                }
            }
        }
        if(item.breed == "cat"){
            Cat cat = (Cat) item;
            if(num == 0){
                if(cat.housebroken){
                    cat.housebroken = false;
                    System.out.println("The haphazard training didn't work, the cat is no longer housebroken.");
                }
                else{
                    cat.housebroken = true;
                    System.out.println("The haphazard training worked, the cat is now housebroken.");
                }
            }
        }
    }
}