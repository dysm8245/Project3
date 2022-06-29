public class Shop implements Command{
    Inventory I;
    Trainer t;
    Shop(Inventory in, Trainer trainer){
        I = in;
        t=trainer;
    }
    public void execute(){
        System.out.println(t.name + " says the current items in Inventory are.");
        for(int i = 0; i < I.items.size(); i++){
            Item item = I.items.get(i);
            System.out.println(item.name);
        }
    }
}