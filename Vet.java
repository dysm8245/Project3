public class Vet implements Logger{
    Vet(){

    }
    void addVisits(Item item, int num, int i){
        item.salePrice += 25*num;;
        out(num + " Vet visits will be added to the sale for $" + 25*num + "\n", i);
    }
}