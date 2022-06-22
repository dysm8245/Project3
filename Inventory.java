import java.util.*;
public class Inventory{//inventory class demonstrates encapsulation of the whole inventory
    //Inventory class also has good cohesion as it holds all objects and acts like a real inventory
    ArrayList<Item> items = new ArrayList<Item>();//holds all in store items
    ArrayList<Orders> orders = new ArrayList<Orders>();//holds orders that have been placed
    ArrayList<Item> soldItems = new ArrayList<Item>();//keeps track of sold items
    
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
    
    void checkDogs(Inventory I, Clerk c, Register r, int d){//checks stock for dogs
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                if(pet.breed == "dog"){
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no dogs in stock. They're going to order more.");
            Dog dog1 = new Dog();
            Dog dog2 = new Dog();
            Dog dog3 = new Dog();
            c.placeAnOrder(I, dog1, dog2, dog3, r, d);
        }
    }
    void checkCats(Inventory I, Clerk c, Register r, int d){//checks stock for cats
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "pet") {
                Pet pet = (Pet) item;
                if (pet.breed == "cat") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no cats in stock. They're going to order more.");
            Cat cat1 = new Cat();
            Cat cat2 = new Cat();
            Cat cat3 = new Cat();
            c.placeAnOrder(I, cat1, cat2, cat3, r, d);
        }
    }
    void checkBirds(Inventory I, Clerk c, Register r, int d){//checks stock for birds
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "pet") {
                Pet pet = (Pet) item;
                if (pet.breed == "bird") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no birds in stock. They're going to order more.");
            Bird bird1 = new Bird();
            Bird bird2 = new Bird();
            Bird bird3 = new Bird();
            c.placeAnOrder(I, bird1, bird2, bird3, r, d);
        }
    }
    
    void checkBirdFood(Inventory I, Clerk c, Register r, int d){//checks stock for bird food
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "food") {
                Food food = (Food) item;
                if (food.animal == "bird") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there is no bird food in stock. They're going to order more.");
            Food food1 = new Food("bird");
            Food food2 = new Food("bird");
            Food food3 = new Food("bird");
            c.placeAnOrder(I, food1, food2, food3, r, d);
        }
    }
    void checkCatFood(Inventory I, Clerk c, Register r, int d){//checks for cat food
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "food") {
                Food food = (Food) item;
                if (food.animal == "cat") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there is no cat food in stock. They're going to order more.");
            Food food1 = new Food("cat");
            Food food2 = new Food("cat");
            Food food3 = new Food("cat");
            c.placeAnOrder(I, food1, food2, food3, r, d);
        }
    }
    void checkDogFood(Inventory I, Clerk c, Register r, int d){//checks for dog food
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "food") {
                Food food = (Food) item;
                if (food.animal == "dog") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there is no dog food in stock. They're going to order more.");
            Food food1 = new Food("dog");
            Food food2 = new Food("dog");
            Food food3 = new Food("dog");
            c.placeAnOrder(I, food1, food2, food3, r, d);
        }
    }
    
    void checkDogToys(Inventory I, Clerk c, Register r, int d){//checks for dog toys
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "toy") {
                Toy toy = (Toy) item;
                if(toy.animal == "dog") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no more dog toys in stock. They're not going to order more.");
        }
    }
    void checkCatToys(Inventory I, Clerk c, Register r, int d){//checks for cat toys
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "toy") {
                Toy toy = (Toy) item;
                if(toy.animal == "cat") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no more cat toys in stock. They're not going to order more.");
        }
    }
    void checkBirdToys(Inventory I, Clerk c, Register r, int d){//checks for bird toys
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "toy") {
                Toy toy = (Toy) item;
                if (toy.animal == "bird") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no more bird toys in stock. They're not going to order more.");
        }
    }
    
    void checkLitter(Inventory I, Clerk c, Register r, int d){//check for litter
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "cat litter") {
                count++;
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there is no cat litter in stock. They're going to order more.");
            Litter lit1 = new Litter();
            Litter lit2 = new Litter();
            Litter lit3 = new Litter();
            c.placeAnOrder(I, lit1, lit2, lit3, r, d);
        }
    }
    void checkDogLeash(Inventory I, Clerk c, Register r, int d){//checks for dogs
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "leash") {
                Leash leash = (Leash) item;
                if (leash.animal == "dog") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no dog leashes in stock. They're going to order more.");
            Leash leash1 = new Leash("dog");
            Leash leash2 = new Leash("dog");
            Leash leash3 = new Leash("dog");
            c.placeAnOrder(I, leash1, leash2, leash3, r, d);
        }
    }
    void checkCatLeash(Inventory I, Clerk c, Register r, int d){//checks for cat leashes
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if(item.name == "leash") {
                Leash leash = (Leash) item;
                if (leash.animal == "cat") {
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.println(c.name + " says there are no cat leashes in stock. They're going to order more.");
            Leash leash1 = new Leash("cat");
            Leash leash2 = new Leash("cat");
            Leash leash3 = new Leash("cat");
            c.placeAnOrder(I, leash1, leash2, leash3, r, d);
        }
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