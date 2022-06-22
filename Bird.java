import java.util.*;
public class Bird extends Pet{
    String size;
    boolean exotic;
    boolean mimicry;
    boolean papers;
    Bird(){
        super("bird");
        Random rand = new Random();
        String[] sizes = new String[3];
        sizes[0] = "small";
        sizes[1] = "medium";
        sizes[2] = "large";
        int num = rand.nextInt(101);
        int num2 = rand.nextInt(3);
        size = sizes[num2];
        exotic = rand.nextBoolean();
        mimicry = rand.nextBoolean();
        papers = rand.nextBoolean();
        purchasePrice = num;
        listPrice = 2*purchasePrice;
    }
}