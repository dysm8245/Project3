public class Item implements Items{
    String name;
    float purchasePrice;
    float listPrice;
    float salePrice;
    int dayArrived;
    int daySold;
    Item(String n){
        name = n;
    }

    public void setArrivalDate(int i) {
        dayArrived = i;
    }
}