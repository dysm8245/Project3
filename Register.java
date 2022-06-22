public class Register{
    float amount;
    int visits = 0;
    Register(){
        amount = 0;
    }
    float getAmount(){
        return amount;
    }
    float getAmountAdded(){
        return visits*1000;
    }
}