import java.util.*;
public class Cat extends Pet{
    String color;
    boolean housebroken;
    boolean purebred;
    Cat(){
        super("cat");
        Random rand = new Random();
        String[] colors = new String[5];
        colors[0] = "calico";
        colors[1] = "tuxedo";
        colors[2] = "orange tabby";
        colors[3] = "brown tabby";
        colors[4] = "mixed";
        int num = rand.nextInt(101);
        int num2 = rand.nextInt(5);
        color = colors[num2];
        purebred = rand.nextBoolean();
        housebroken = rand.nextBoolean();
        purchasePrice = num;
        listPrice = 2*purchasePrice;
    }
}