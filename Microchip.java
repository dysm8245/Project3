public class Microchip implements Logger{
    Microchip(){

    }
    void addMicro(Item item, int i){
        item.salePrice += 50;
        out("A microchip will be added to the sale for $50.\n", i);
    }
}