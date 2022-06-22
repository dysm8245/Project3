import java.util.*;
public class Snake extends Pet{
    String size;
    Snake(){
        super("snake");
        Random rand = new Random();
        String[] sizes = new String[3];
        sizes[0] = "small";
        sizes[1] = "medium";
        sizes[2] = "large";
        int num = rand.nextInt(101);
        int num1 = rand.nextInt(3);
        size = sizes[num1];
        purchasePrice = num;
        listPrice = 2*purchasePrice;
    }
}