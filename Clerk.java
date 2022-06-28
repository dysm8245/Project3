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
                order.addToInventory(c, I, i);
            }
        }
        for(int i = 0; i < arrivals.size(); i++){
            I.orders.remove(arrivals.get(i));
        }
    }
    void doInventory(Clerk c, Inventory I, Register r, int d){
        float total = 0;
        int count = 0;
        String names;
        total = I.addValue();
        out(name + " says the inventory is valued at $" + total + "\n", d);
        for(int j = 0; j < I.item.length; j++){
            names = I.item[j];
            for(int i = 0; i < I.items.size(); i++){
                Item item = I.items.get(i);
                if(item.name == "pet"){
                    Pet pet = (Pet) item;
                    if(pet.breed == names){
                        count++;
                    }
                }
                else if(item.name == names){
                    count++;
                }
            }
            if(count == 0){
                if(names == "dog"){
                    out(c.name + " says there are no dogs in stock. They're going to order more.\n", d);
                    Dog dog1 = new Dog();
                    Dog dog2 = new Dog();
                    Dog dog3 = new Dog();
                    c.placeAnOrder(I, dog1, dog2, dog3, r, d);
                }
                if(names == "cat"){
                    out(c.name + " says there are no cats in stock. They're going to order more.\n", d);
                    Cat cat1 = new Cat();
                    Cat cat2 = new Cat();
                    Cat cat3 = new Cat();
                    c.placeAnOrder(I, cat1, cat2, cat3, r, d);
                }
                if(names == "bird"){
                    out(c.name + " says there are no birds in stock. They're going to order more.\n", d);
                    Bird bird1 = new Bird();
                    Bird bird2 = new Bird();
                    Bird bird3 = new Bird();
                    c.placeAnOrder(I, bird1, bird2, bird3, r, d);
                }
                if(names == "ferret"){
                    out(c.name + " says there are no ferrets in stock. They're going to order more.\n", d);
                    Ferret f1 = new Ferret();
                    Ferret f2 = new Ferret();
                    Ferret f3 = new Ferret();
                    c.placeAnOrder(I, f1, f2, f3, r, d);
                }
                if(names == "snake"){
                    out(c.name + " says there are no snakes in stock. They're going to order more.\n", d);
                    Snake s1 = new Snake();
                    Snake s2 = new Snake();
                    Snake s3 = new Snake();
                    c.placeAnOrder(I, s1, s2, s3, r, d);
                }
                if(names == "treats"){
                    out(c.name + " says there are no more treats in stock. They're going to order more.\n", d);
                    Treats t1 = new Treats();
                    Treats t2 = new Treats();
                    Treats t3 = new Treats();
                    c.placeAnOrder(I, t1, t2, t3, r, d);
                }
                if(names == "leash"){
                    out(c.name + " says there are no more leashes in stock. They're going to order more.\n", d);
                    Leash ls1 = new Leash();
                    Leash ls2 = new Leash();
                    Leash ls3 = new Leash();
                    c.placeAnOrder(I, ls1, ls2, ls3, r, d);
                }
                if(names == "litter"){
                    out(c.name + " says there is no more litter in stock. They're going to order more.\n", d);
                    Litter l1 = new Litter();
                    Litter l2 = new Litter();
                    Litter l3 = new Litter();
                    c.placeAnOrder(I, l1, l2, l3, r, d);
                }
                if(names == "toy"){
                    out(c.name + " says there are no more toys in stock. They're not going to order more.\n", d);
                }
                if(names == "food"){
                    out(c.name + " says there is more food in stock. They're going to order more.\n", d);
                    Food food1 = new Food();
                    Food food2 = new Food();
                    Food food3 = new Food();
                    c.placeAnOrder(I, food1, food2, food3, r, d);
                }
            }
        }
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
            out("There are insufficient funds to place an order. " + name + " is going to the bank to get money.\n", d);
            goToBank(r,d);
            out(name + " went to the bank and will place the order. The items should arrive in a few days.\n", d);
            order.addToOrder(a,b,c,day);
            order.getOrderCost(day);
            I.orders.add(order);
            r.amount -= total;
        }
        else{
            order.addToOrder(a,b,c,day);
            order.getOrderCost(day);
            I.orders.add(order);
            r.amount -= total;
        }
    }
    void checkRegister(Clerk c, Register r, int d){
        if(r.amount < 200){
            out(c.name + " says there is $" + r.amount + " in the register. They're going to the bank.\n", d);
            goToBank(r,d);
        }
        else{
            out(c.name + " says there is $" + r.amount + " in the register. No need to go to bank.\n", d);
        }
    }
    void goToBank(Register r, int d){
        r.amount += 1000;
        out("There is now $" + r.amount + " in the bank.\n", d);
        r.visits++;
    }
}