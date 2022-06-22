import java.util.*;
public class Toy extends Supplies{
    String animal;
    Toy(){
        super("toy");
        Random rand = new Random();
        int num = rand.nextInt(3);
        int num1 = rand.nextInt(101);
        String[] animals = new String[3];
        animals[0] = "dog";
        animals[1] = "cat";
        animals[2] = "bird";
        animal = animals[num];
        purchasePrice = num1;
        listPrice = purchasePrice*2;
    }
    Toy(String a){
        super("toy");
        Random rand = new Random();
        int num1 = rand.nextInt(101);
        animal = a;
        purchasePrice = num1;
        listPrice = purchasePrice*2;
    }
}