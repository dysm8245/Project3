import java.util.*;
public class Litter extends Supplies{
    String size;
    Litter(){
        super("cat litter");
        Random rand = new Random();
        int num = rand.nextInt(3);
        int num1 = rand.nextInt(101);
        String[] sizes = new String[3];
        sizes[0] = "small";
        sizes[1] = "medium";
        sizes[2] = "large";
        size = sizes[num];
        purchasePrice = num1;
        listPrice = 2*num1;
    }
}