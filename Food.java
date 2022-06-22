import java.util.*;
public class Food extends Supplies{
    String size;
    String animal;
    String type;
    Food(){
        super("food");
        Random rand = new Random();
        int num = rand.nextInt(3);
        int num1 = rand.nextInt(101);
        int num2 = rand.nextInt(3);
        int num3 = rand.nextInt(2);
        String[] sizes = new String[3];
        sizes[0] = "small";
        sizes[1] = "medium";
        sizes[2] = "large";
        String[] animals = new String[3];
        animals[0] = "dog";
        animals[1] = "cat";
        animals[2] = "bird";
        String[] types = new String[2];
        types[0] = "organic";
        types[1] = "non-organic";
        size = sizes[num];
        animal = animals[num2];
        type = types[num3];
        purchasePrice = num1;
        listPrice = 2*num1;
    }
    Food(String a){
        super("food");
        Random rand = new Random();
        int num = rand.nextInt(3);
        int num1 = rand.nextInt(2);
        int num2 = rand.nextInt(101);
        String[] sizes = new String[3];
        sizes[0] = "small";
        sizes[1] = "medium";
        sizes[2] = "large";
        String[] types = new String[2];
        types[0] = "organic";
        types[1] = "non-organic";
        animal = a;
        size = sizes[num];
        type = types[num1];
        purchasePrice = num2;
        listPrice = 2*num2;
    }
}