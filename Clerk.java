import java.util.*;
public class Clerk extends Employees{
    String name;
    int daysWorked = 0;
    Clerk(String n)
    {
        name = n;
    }
    void processDeliveries(Clerk c, Inventory I, int day){
        ArrayList<Integer> arrivals = new ArrayList<Integer>();
        for(int i = 0; i < I.orders.size(); i++){
            Orders order = I.orders.get(i);
            if(order.dayArrived == day){
                arrivals.add(i);
                order.addToInventory(c, I);
            }
        }
        for(int i = 0; i < arrivals.size(); i++){
            I.orders.remove(arrivals.get(i));
        }
    }
    void doInventory(Clerk c, Inventory I, Register r, int d){
        float total = 0;
        total = I.addValue();
        System.out.println(name + " says the inventory is valued at $" + total);
        I.checkDogs(I, c, r, d);
        I.checkCats(I, c, r, d);
        I.checkBirds(I, c, r, d);
        I.checkDogFood(I,c,r,d);
        I.checkCatFood(I,c,r,d);
        I.checkBirdFood(I,c,r,d);
        I.checkDogToys(I,c,r,d);
        I.checkCatToys(I,c,r,d);
        I.checkBirdToys(I,c,r,d);
        I.checkLitter(I,c,r,d);
        I.checkCatLeash(I,c,r,d);
        I.checkDogLeash(I,c,r,d);
    }
    void placeAnOrder(Inventory I, Item a, Item b, Item c, Register r, int d){
        Random rand = new Random();
        Orders order = new Orders();
        int total = 0;
        int day = rand.nextInt(3);
        if(day == 0){
            day = 1;
        }
        day += d;
        total +=  a.purchasePrice;
        total += b.purchasePrice;
        total += c.purchasePrice;
        if(total > r.amount){
            System.out.println("There are insufficient funds to place an order. " + name + " is going to the bank to get money.");
            goToBank(r);
            System.out.println(name + " went to the bank and will place the order. The items should arrive in a few days.");
            order.addToOrder(a,b,c,day);
            order.getOrderCost();
            I.orders.add(order);
            r.amount -= total;
        }
        else{
            order.addToOrder(a,b,c,day);
            order.getOrderCost();
            I.orders.add(order);
            r.amount -= total;
        }
    }
    void checkRegister(Clerk c, Register r){
        if(r.amount < 200){
            System.out.println(c.name + " says there is $" + r.amount + " in the register. They're going to the bank.");
            goToBank(r);
        }
        else{
            System.out.println(c.name + " says there is $" + r.amount + " in the register. No need to go to bank.");
        }
    }
    void goToBank(Register r){
        r.amount += 1000;
        System.out.println("There is now $" + r.amount + " in the bank.");
        r.visits++;
    }
}