import java.util.*;
public class Pet extends Item{
    String breed;
    int age;
    boolean health;
    Pet(String n){
        super("pet");
        Random rand = new Random();
        int num = rand.nextInt(3);
        age = num;
        breed = n;
        health = true;
    }
}