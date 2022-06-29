public class ItemFactory{
    public Items createItem(String item){
        if(item == "dog"){
            return new Dog();
        }
        if(item == "cat"){
            return new Cat();
        }
        if(item == "bird"){
            return new Bird();
        }
        if(item == "ferret"){
            return new Ferret();
        }
        if(item == "snake"){
            return new Snake();
        }
        if(item == "treats"){
            return new Treats();
        }
        if(item == "toy"){
            return new Toy();
        }
        if(item == "leash"){
            return new Leash();
        }
        if(item == "food"){
            return new Food();
        }
        if(item == "litter"){
            return new Litter();
        }
        else{
            return null;
        }
    }
}