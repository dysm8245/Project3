import java.util.*;
public class Ferret extends Pet{
    String color;
    boolean housebroken;
    Ferret(){
        super("ferret");
        Random rand = new Random();
        String[] colors = new String[5];
        colors[0] = "black";
        colors[1] = "brown";
        colors[2] = "orange";
        colors[3] = "white";
        colors[4] = "mixed";
        int num = rand.nextInt(101);
        int num2 = rand.nextInt(5);
        color = colors[num2];
        
        housebroken = rand.nextBoolean();
        purchasePrice = num;
        listPrice = 2*purchasePrice;
    }
}