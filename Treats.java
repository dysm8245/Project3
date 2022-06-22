import java.util.*;
public class Treats extends Supplies{
    String animal;
    Treats(){
        super("treats");
        Random rand = new Random();
        int num = rand.nextInt(5);
        int num1 = rand.nextInt(101);
        String[] animals = new String[5];
        animals[0] = "dog";
        animals[1] = "cat";
        animals[2] = "bird";
        animals[3] = "ferret";
        animals[4] = "snake";
        animal = animals[num];
        purchasePrice = num1;
        listPrice = purchasePrice*2;
    }
}