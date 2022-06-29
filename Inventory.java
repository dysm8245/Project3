import java.util.*;
public class Inventory{//inventory class demonstrates encapsulation of the whole inventory
    //Inventory class also has good cohesion as it holds all objects and acts like a real inventory
    ArrayList<Items> items = new ArrayList<Items>();//holds all in store items
    ArrayList<Orders> orders = new ArrayList<Orders>();//holds orders that have been placed
    ArrayList<Item> soldItems = new ArrayList<Item>();//keeps track of sold items
    String[] item = new String[10];
    
    Inventory(){
        for(int i = 0; i < 3; i++){//intializes three of everything for starting inventory
            ItemFactory factory = new ItemFactory();//factory to create Items
            Items item = factory.createItem("dog");//creates a dog from factory
            items.add(item);
            item.setArrivalDate(1);
            Items item1 = factory.createItem("bird");
            items.add(item1);
            item1.setArrivalDate(1);
            Items item2 = factory.createItem("cat");
            items.add(item2);
            item2.setArrivalDate(1);
            Items item3 = factory.createItem("ferret");
            items.add(item3);
            item3.setArrivalDate(1);
            Items item4 = factory.createItem("snake");
            items.add(item4);
            item4.setArrivalDate(1);
            Items item5 = factory.createItem("toy");
            items.add(item5);
            item5.setArrivalDate(1);
            Items item6 = factory.createItem("litter");
            items.add(item6);
            item6.setArrivalDate(1);
            Items item7 = factory.createItem("food");
            items.add(item7);
            item7.setArrivalDate(1);
            Items item8 = factory.createItem("leash");
            items.add(item8);
            item8.setArrivalDate(1);
            Items item9 = factory.createItem("treats");
            items.add(item9);
            item9.setArrivalDate(1);
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
            Items item = items.get(i);
            Item obj = (Item) item;
            System.out.println(obj.name + " " + obj.dayArrived);
        }
    }
    float addValue(){//returns purchasePrice total of all items
        float sum = 0;
        for(int i = 0; i < items.size(); i++){
            Items a = items.get(i);
            Item item = (Item) a;
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
            Items a = items.get(i);
            Item item = (Item) a;
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
            Items a = items.get(i);
            Item item = (Item) a;
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