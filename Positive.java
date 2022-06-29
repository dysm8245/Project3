import java.util.*;
public class Positive implements Method, Logger{//training strategy
    public void train(Pet item, int d) {
        Random rand = new Random();
        int num = 0;
        if(item.breed == "dog"){
            num = rand.nextInt(2);
            Dog dog = (Dog) item;
            if(num == 0){
                if(!dog.housebroken){
                    dog.housebroken = true;
                    out("The positive reinforcement training worked, the dog is now housebroken.\n", d);
                }
            }
        }
        if(item.breed == "ferret"){
            Ferret ferret = (Ferret) item;
            if(num == 0){
                if(!ferret.housebroken){
                    ferret.housebroken = true;
                    out("The positive reinforcement training worked, the ferret is now housebroken.\n", d);
                }
            }
        }
        if(item.breed == "cat"){
            Cat cat = (Cat) item;
            if(num == 0){
                if(!cat.housebroken){
                    cat.housebroken = true;
                    out("The positive reinforcement training worked, the cat is now housebroken.\n", d);
                }
            }
        }
    }
}