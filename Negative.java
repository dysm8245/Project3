import java.util.*;
public class Negative implements Method{
    public void train(Pet item) {
        Random rand = new Random();
        int num = rand.nextInt(5);
        if (item.breed == "dog") {
            Dog dog = (Dog) item;
            if (num == 0) {
                if (num == 0) {
                    if (dog.housebroken) {
                        dog.housebroken = false;
                        System.out.println("The negative reinforcement training backfired, the dog is no longer housebroken.");
                    }
                }
                else if (num == 1 || num == 2) {
                    dog.housebroken = true;
                    System.out.println("The negative reinforcement training worked, the dog is now housebroken.");
                }
            }
        }
        if (item.breed == "ferret") {
            Ferret ferret = (Ferret) item;
            if (num == 0) {
                if (num == 0) {
                    if (ferret.housebroken) {
                        ferret.housebroken = false;
                        System.out.println("The negative reinforcement training backfired, the ferret is no longer housebroken.");
                    }
                }
                else if (num == 1 || num == 2) {
                    ferret.housebroken = true;
                    System.out.println("The negative reinforcement training worked, the ferret is now housebroken.");
                }
            }
        }
        if (item.breed == "cat") {
            Cat cat = (Cat) item;
            if (num == 0) {
                if (cat.housebroken) {
                    cat.housebroken = false;
                    System.out.println("The negative reinforcement training backfired, the cat is no longer housebroken.");
                }
            }
            else if (num == 1 || num == 2) {
                cat.housebroken = true;
                System.out.println("The negative reinforcement training worked, the cat is now housebroken.");
            }
        }
    }
}