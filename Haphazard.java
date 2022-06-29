import java.util.*;
public class Haphazard implements Method, Logger{//training strategy
    public void train(Pet item, int d){
        Random rand = new Random();
        int num = rand.nextInt(10);
        if(item.breed == "dog"){
            Dog dog = (Dog) item;
            if(num == 0){
                if(dog.housebroken){
                    dog.housebroken = false;
                    out("The haphazard training didn't work, the dog is no longer housebroken.\n", d);
                }
                else{
                    dog.housebroken = true;
                    out("The haphazard training worked, the dog is now housebroken.\n", d);
                }
            }
        }
        if(item.breed == "ferret"){
            Ferret ferret = (Ferret) item;
            if(num == 0){
                if(ferret.housebroken){
                    ferret.housebroken = false;
                    System.out.println("The haphazard training didn't work, the ferret is no longer housebroken.\n");
                }
                else{
                    ferret.housebroken = true;
                    System.out.println("The haphazard training worked, the ferret is now housebroken.\n");
                }
            }
        }
        if(item.breed == "cat"){
            Cat cat = (Cat) item;
            if(num == 0){
                if(cat.housebroken){
                    cat.housebroken = false;
                    System.out.println("The haphazard training didn't work, the cat is no longer housebroken.\n");
                }
                else{
                    cat.housebroken = true;
                    System.out.println("The haphazard training worked, the cat is now housebroken.\n");
                }
            }
        }
    }
}