public class Orders{
    Item item1;
    Item item2;
    Item item3;
    int dayArrived = 0;
    float orderCost = 0;
    Orders(){

    }
    void addToOrder(Item a, Item b, Item c, int day){
        item1 = a;
        item2 = b;
        item3 = c;
        dayArrived = day;
    }

    void getOrderCost(){
        orderCost = item1.purchasePrice + item2.purchasePrice + item3.purchasePrice;
        System.out.println("The order will cost $" + orderCost);
    }

    void addToInventory(Clerk c, Inventory I){
        if(item1.name == "pet"){
            Pet pet1 = (Pet) item1;
            System.out.println(c.name + " says a new " + pet1.breed + " has arrived. It will be added to inventory.");
            I.items.add(pet1);
        }
        else{
            System.out.println(c.name + " says a new " + item1.name + " has arrived. It will be added to inventory.");
            I.items.add(item1);
        }
        if(item1.name == "pet"){
            Pet pet2 = (Pet) item2;
            System.out.println(c.name + " says a new " + pet2.breed + " has arrived. It will be added to inventory.");
            I.items.add(pet2);
        }
        else{
            System.out.println(c.name + " says a new " + item2.name + " has arrived. It will be added to inventory.");
            I.items.add(item2);
        }
        if(item1.name == "pet"){
            Pet pet3 = (Pet) item3;
            System.out.println(c.name + " says a new " + pet3.breed + " has arrived. It will be added to inventory.");
            I.items.add(pet3);
        }
        else{
            System.out.println(c.name + " says a new " + item3.name + " has arrived. It will be added to inventory.");
            I.items.add(item3);
        }
        if(item1.name == "leash"){

        }
    }
}