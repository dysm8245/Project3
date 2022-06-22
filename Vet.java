public class Vet{
    Vet(){

    }
    void addVisits(Item item, int num){
        item.salePrice += 25*num;;
        System.out.println(num + " Vet visits will be added to the sale for $" + 25*num);
    }
}