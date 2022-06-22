public class Microchip{
    Microchip(){

    }
    void addMicro(Item item){
        item.salePrice += 50;
        System.out.println("A microchip will be added to the sale for $50.");
    }
}