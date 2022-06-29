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
        ItemFactory factory = new ItemFactory();//factory to create items
        float total = 0;
        int count = 0;
        String names;
        total = I.addValue();
        out(name + " says the inventory is valued at $" + total + "\n", d);
        for(int j = 0; j < I.item.length; j++){
            names = I.item[j];
            for(int i = 0; i < I.items.size(); i++){
                Items a = I.items.get(i);
                Item item = (Item) a;
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
                    Items dog1 = factory.createItem("dog");//creating dogs for example here
                    Items dog2 = factory.createItem("dog");
                    Items dog3 = factory.createItem("dog");
                    c.placeAnOrder(I, dog1, dog2, dog3, r, d);
                }
                if(names == "cat"){
                    out(c.name + " says there are no cats in stock. They're going to order more.\n", d);
                    Items cat1 = factory.createItem("cat");
                    Items cat2 = factory.createItem("cat");
                    Items cat3 = factory.createItem("cat");
                    c.placeAnOrder(I, cat1, cat2, cat3, r, d);
                }
                if(names == "bird"){
                    out(c.name + " says there are no birds in stock. They're going to order more.\n", d);
                    Items bird1 = factory.createItem("bird");
                    Items bird2 = factory.createItem("bird");
                    Items bird3 = factory.createItem("bird");
                    c.placeAnOrder(I, bird1, bird2, bird3, r, d);
                }
                if(names == "ferret"){
                    out(c.name + " says there are no ferrets in stock. They're going to order more.\n", d);
                    Items f1 = factory.createItem("ferret");
                    Items f2 = factory.createItem("ferret");
                    Items f3 = factory.createItem("ferret");
                    c.placeAnOrder(I, f1, f2, f3, r, d);
                }
                if(names == "snake"){
                    out(c.name + " says there are no snakes in stock. They're going to order more.\n", d);
                    Items s1 = factory.createItem("snake");
                    Items s2 = factory.createItem("snake");
                    Items s3 = factory.createItem("snake");
                    c.placeAnOrder(I, s1, s2, s3, r, d);
                }
                if(names == "treats"){
                    out(c.name + " says there are no more treats in stock. They're going to order more.\n", d);
                    Items t1 = factory.createItem("treats");
                    Items t2 = factory.createItem("treats");
                    Items t3 = factory.createItem("treats");
                    c.placeAnOrder(I, t1, t2, t3, r, d);
                }
                if(names == "leash"){
                    out(c.name + " says there are no more leashes in stock. They're going to order more.\n", d);
                    Items ls1 = factory.createItem("leash");
                    Items ls2 = factory.createItem("leash");
                    Items ls3 = factory.createItem("leash");
                    c.placeAnOrder(I, ls1, ls2, ls3, r, d);
                }
                if(names == "litter"){
                    out(c.name + " says there is no more litter in stock. They're going to order more.\n", d);
                    Items l1 = factory.createItem("litter");
                    Items l2 = factory.createItem("litter");
                    Items l3 = factory.createItem("litter");
                    c.placeAnOrder(I, l1, l2, l3, r, d);
                }
                if(names == "toy"){
                    out(c.name + " says there are no more toys in stock. They're not going to order more.\n", d);
                }
                if(names == "food"){
                    out(c.name + " says there is more food in stock. They're going to order more.\n", d);
                    Items food1 = factory.createItem("food");
                    Items food2 = factory.createItem("food");
                    Items food3 = factory.createItem("food");
                    c.placeAnOrder(I, food1, food2, food3, r, d);
                }
            }
        }
    }
    void placeAnOrder(Inventory I, Items i1, Items i2, Items i3, Register r, int d){
        Random rand = new Random();
        Orders order = new Orders();
        int total = 0;
        int day = rand.nextInt(3);
        if(day == 0){
            day = 1;
        }
        day += d;
        i1.setArrivalDate(day);
        i2.setArrivalDate(day);
        i3.setArrivalDate(day);
        Item a = (Item) i1;
        Item b = (Item) i2;
        Item c = (Item) i3;
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