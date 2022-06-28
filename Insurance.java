public class Insurance implements Logger{
    Insurance(){

    }
    void addIns(Item item, int i){
        item.salePrice += 50;
        out("Insurance will be added to the sale for $50.\n", i);
    }

}