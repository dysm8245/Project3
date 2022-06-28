import java.util.*;
public class Inventory{//inventory class demonstrates encapsulation of the whole inventory
    //Inventory class also has good cohesion as it holds all objects and acts like a real inventory
    ArrayList<Item> items = new ArrayList<Item>();//holds all in store items
    ArrayList<Orders> orders = new ArrayList<Orders>();//holds orders that have been placed
    ArrayList<Item> soldItems = new ArrayList<Item>();//keeps track of sold items
    String[] item = new String[10];
    
    Inventory(){
        for(int i = 0; i < 3; i++){//intializes three of everything for starting inventory
            Dog dog = new Dog();
            dog.dayArrived = 1;
            items.add(dog);
            Bird bird = new Bird();
            bird.dayArrived = 1;
            items.add(bird);
            Cat cat = new Cat();
            cat.dayArrived = 1;
            items.add(cat);
            Ferret ferret = new Ferret();
            ferret.dayArrived = 1;
            items.add(ferret);
            Snake snake = new Snake();
            snake.dayArrived = 1;
            items.add(snake);
            Toy toy = new Toy();
            toy.dayArrived = 1;
            items.add(toy);
            Litter litter = new Litter();
            litter.dayArrived = 1;
            items.add(litter);
            Food food = new Food();
            food.dayArrived = 1;
            items.add(food);
            Leash leash = new Leash();
            leash.dayArrived = 1;
            items.add(leash);
            Treats treats = new Treats();
            treats.dayArrived = 1;
            items.add(treats);
        }
        item[0] = "dog";
        item[1] = "cat";
        item[2] = "bird";
        item[3] = "ferret";
        item[4] = "snake";
        item[5] = "leash";
        item[6] = "toy";
        item[7] = "treats";
        item[8] = "food";
        item[9] = "litter";
    }
    void items(){//test to see items
        for(int i = 0; i < items.size(); i++){
            Item obj = items.get(i);
            System.out.println(obj.name + " " + obj.dayArrived);
        }
    }
    float addValue(){//returns purchasePrice total of all items
        float sum = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            sum += item.purchasePrice;
        }
        return sum;
    }
    void summary(Register R, int day){//checks the ending inventory
        float value = 0;
        float profit = 0;
        int count = 0;
        System.out.println("After " + day + " days the following items are left in inventory.");
        for(int i = 0; i < items.size(); i++){//counts value of remaining inventory
            Item item = items.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                System.out.println(pet.breed + ": $" + pet.purchasePrice);
                value += pet.purchasePrice;
            }
            else{
                System.out.println(item.name + ": $" + item.purchasePrice);
                value += item.purchasePrice;
            }
        }
        System.out.println("Value of remaining inventory: $" + value);
        System.out.println("Over " + day + " days the following items were sold.");
        for(int i = 0; i < soldItems.size(); i++){//counts value of sold items
            Item item = soldItems.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                System.out.println(pet.breed + ": sold on day " + pet.daySold + " for " + pet.salePrice);
                profit += pet.purchasePrice;
            }
            else{
                System.out.println(item.name + ": sold on day " + item.daySold + " for " + item.salePrice);
                profit += item.purchasePrice;
            }

        }
        System.out.println("Total money from sales: $" + profit);
        for(int i = 0; i < items.size(); i++){//counts sick pets
            Item item = items.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(!pet.health){
                    count++;
                }
            }
        }
        System.out.println("There are " + count + " sick pets remaining in inventory.");
        float cash = R.getAmount();
        float total = R.getAmountAdded();
        System.out.println("There is $" + cash + " left in the register after " + day + " days."); 
        System.out.println("$" + total + " was added to the register over " + day + " days.");
    }
}