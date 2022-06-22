import java.util.*;
public class Dog extends Pet{
    String size;
    String color;
    boolean purebred;
    boolean housebroken;
    Dog(){
        super("dog");
        Random rand = new Random();
        String[] sizes = new String[3];
        sizes[0] = "small";
        sizes[1] = "medium";
        sizes[2] = "large";
        String[] colors = new String[5];
        colors[0] = "black";
        colors[1] = "white";
        colors[2] = "yellow";
        colors[3] = "brown";
        colors[4] = "mixed";
        int num = rand.nextInt(101);
        int num1 = rand.nextInt(3);
        int num2 = rand.nextInt(5);
        size = sizes[num1];
        color = colors[num2];
        purebred = rand.nextBoolean();
        housebroken = rand.nextBoolean();
        purchasePrice = num;
        listPrice = 2*purchasePrice;
    }
}
