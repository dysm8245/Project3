import java.util.*;
public class Employees{
    Clerk[] clerks = new Clerk[3];
    Clerk workingC;
    Trainer workingT;
    Trainer[] trainers = new Trainer[3];
    void hire(){
        trainers[0] = new Trainer("Bob", new Positive());
        trainers[1] = new Trainer("Julie", new Negative());
        trainers[2] = new Trainer("Harry", new Haphazard());
        clerks[0] = new Clerk("Greg");
        clerks[1] = new Clerk("Lisa");
        clerks[2] = new Clerk("Mike");
    }
    void staff(){
        for(int i = 0; i < 3; i++){
            System.out.println(clerks[i].name);
            System.out.println(trainers[i].name);
        }
    }
    Clerk getClerk(){
        return workingC;
    }
    Trainer getTrainer(){
        return workingT;
    }
    void ArriveAtStore(int days){//starts day off
            Random rand = new Random();
            int num = rand.nextInt(3);
            int num1 = rand.nextInt(3);
            System.out.println("      ------New Day------");
            if(clerks[num].daysWorked == 3){
                for(int i =0; i < clerks.length; i++){
                    if(clerks[num] == clerks[i]){
                        continue;
                    }
                    else{
                        System.out.println(clerks[i].name + " the clerk arrives at the store on day " + days + ".");
                        workingC = clerks[i];
                        clerks[i].daysWorked++;
                        break;
                    }
                }
                clerks[num].daysWorked=0;
            }
            else{
                System.out.println(clerks[num].name + " the clerk arrives at the store on day " + days + ".");
                workingC = clerks[num];
                clerks[num].daysWorked++;
            }
            if(trainers[num1].daysWorked == 3) {
                for(int i = 0; i < trainers.length; i++){
                    if(trainers[num1] == trainers[i]){
                        continue;
                    }
                    else{
                        System.out.println(trainers[i].name + " the trainer arrives at the store on day " + days + ".");
                        workingT = trainers[i];
                        trainers[i].daysWorked++;
                        break;
                    }
                }
                trainers[num1].daysWorked = 0;
            }
            else{
                System.out.println(trainers[num1].name + " the trainer arrives at the store on day " + days + ".");
                workingT = trainers[num1];
                trainers[num1].daysWorked++;
            }
//            if(clerks[num].daysWorked == 3) {//checks to see if they worked 3 days in a row
//                if(num == 1){
//                    num = num - 1;
//                    System.out.println(clerks[num].name + " the clerk arrives at the store on day " + days + ".");
//                    workingC = clerks[num];
//                    clerks[num].daysWorked++;
//                    clerks[num+1].daysWorked = 0;
//                    num = num+1;
//                }
//                else if(num == 0){
//                    num = num + 1;
//                    System.out.println(clerks[num].name + " the clerk arrives at the store on day " + days + ".");
//                    workingC = clerks[num];
//                    clerks[num].daysWorked++;
//                    clerks[num-1].daysWorked = 0;
//                    num = num-1;
//                }
//            }
//            if(trainers[num].daysWorked == 3){//check for days worked
//                if(num == 1){
//                    num = num-1;
//                    System.out.println(trainers[num].name + " the trainer arrives at the store on day " + days + ".");
//                    workingT = trainers[num];
//                    trainers[num].daysWorked++;
//                    trainers[num+1].daysWorked = 0;
//                    num=num+1;
//                }
//                else if(num == 0){
//                    num = num+1;
//                    System.out.println(trainers[num].name + " the trainer arrives at the store on day " + days + ".");
//                    workingT = trainers[num];
//                    trainers[num].daysWorked++;
//                    trainers[num-1].daysWorked = 0;
//                    num=num-1;
//                }
//            }
//            else{
//                System.out.println(clerks[num].name + " the clerk arrives at the store on day " + days + ".");
//                workingC = clerks[num];
//                clerks[num].daysWorked++;
//                System.out.println(trainers[num].name + " the trainer arrives at the store on day " + days + ".");
//                workingT = trainers[num];
//                trainers[num].daysWorked++;
//            }
    }
    
    private static int getPoissonRandom(double mean) { // https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }
    
    void openStore(Inventory I, Clerk c, Trainer t, Register r, int day){
        Random rand = new Random();
        int num = getPoissonRandom(3);
        int baseCust = 2;
        int custAmmt = baseCust + num;
        int buyChance = 0;
        int noDeal = 0;
        int deal = 0;
        int add = 0;
        int amount = 0;
    
        for(int i = 0; i < custAmmt; i++){
            int cust = i+1;
            System.out.println("Customer " + cust + " has entered the store.");
            for(int j = 0; j < I.items.size(); j++){
                Item item = I.items.get(j);
                buyChance = rand.nextInt(10);
                if(buyChance == 0){
                    if(item.name == "pet"){
                        Pet pet = (Pet) item;
                        if(pet.health){
                            System.out.println("Customer " + cust + " is thinking about buying a " + pet.breed +".");
                            noDeal = rand.nextInt(2);
                            if(noDeal == 0){
                                add = rand.nextInt(4);
                                System.out.println(c.name + " says Customer " + cust + " will pay for the " + pet.breed +" at list price.");
                                pet.salePrice = pet.listPrice;
                                pet.daySold = day;
                                I.items.remove(pet);
                                I.soldItems.add(pet);
                                r.amount += pet.salePrice;
                                if(add == 0){
                                    Insurance addOn = new Insurance();
                                    addOn.addIns(pet);
                                }
                                else if(add == 1){
                                    amount = rand.nextInt(5);
                                    if(amount == 0){
                                        amount = 1;
                                    }
                                    Vet addOn = new Vet();
                                    addOn.addVisits(pet,amount);
                                }
                                else{
                                    Microchip addOn = new Microchip();
                                    addOn.addMicro(pet);
                                }
                                System.out.println(c.name + " is adding $" + pet.salePrice + " to the register.");
                                j = I.items.size();
                                System.out.println("Customer " + cust + " has left the store after buying a " + pet.breed + ".");
                            }
                            else{
                                System.out.println(t.name + " offered Customer " + cust + " a 10% discount on the " + pet.breed);
                                deal = rand.nextInt(4);
                                if(deal != 0){
                                    add = rand.nextInt(4);
                                    System.out.println("Customer " + cust + " will pay for the " + pet.breed +" with a 10% discount");
                                    pet.salePrice = (float) (pet.listPrice*0.9);
                                    pet.daySold = day;
                                    I.items.remove(pet);
                                    I.soldItems.add(pet);
                                    r.amount += pet.salePrice;
                                    if(add == 0){
                                        Insurance addOn = new Insurance();
                                        addOn.addIns(pet);
                                    }
                                    else if(add == 1){
                                        amount = rand.nextInt(5);
                                        if(amount == 0){
                                            amount = 1;
                                        }
                                        Vet addOn = new Vet();
                                        addOn.addVisits(pet,amount);
                                    }
                                    else{
                                        Microchip addOn = new Microchip();
                                        addOn.addMicro(pet);
                                    }
                                    System.out.println(c.name + " is adding $" + pet.salePrice + " to the register.");
                                    j = I.items.size();
                                    System.out.println("Customer " + cust + " has left the store after buying a " + pet.breed + ".");
                                }
                                else{
                                    System.out.println("Customer " + cust + " will continue to look at other items.");
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("Customer " + cust + " is thinking about buying a " + item.name +".");
                        noDeal = rand.nextInt(2);
                        if(noDeal == 0){
                            System.out.println(c.name + " says Customer " + cust + " will pay for the " + item.name +" at list price.");
                            item.salePrice = item.listPrice;
                            item.daySold = day;
                            I.items.remove(item);
                            I.soldItems.add(item);
                            r.amount += item.salePrice;
                            System.out.println(c.name + " is adding $" + item.salePrice + " to the register.");
                            j = I.items.size();
                            System.out.println("Customer " + cust + " has left the store after buying a " + item.name + ".");
                        }
                        else{
                            System.out.println(t.name + " offered Customer " + cust + " a 10% discount on the " + item.name);
                            deal = rand.nextInt(4);
                            if(deal != 0){
                                System.out.println("Customer " + cust + " will pay for the " + item.name +" with a 10% discount");
                                item.salePrice = (float) (item.listPrice*0.9);
                                item.daySold = day;
                                I.items.remove(item);
                                I.soldItems.add(item);
                                r.amount += item.salePrice;
                                System.out.println(c.name + " is adding $" + item.salePrice + " to the register.");
                                j = I.items.size();
                                System.out.println("Customer " + cust + " has left the store after buying a " + item.name + ".");
                            }
                            else{
                                System.out.println("Customer " + cust + " will continue to look at other items.");
                            }
                        }
                    }
                }
                if(j == I.items.size()-1){
                    System.out.println("Customer " + cust + " has left the store without buying an item.");
                }
            }
        }
    }
    void cleanStore(Inventory I, Clerk c, Trainer t){
        for(int i = 0; i < I.items.size(); i++){
            Random rand = new Random();
            int num = 0;
            int num1 = 0;
            Item item = I.items.get(i);
            if(item.name == "pet"){
                Pet pet = (Pet) item;
                num = rand.nextInt();
                if(num%20==0){
                    num1 = rand.nextInt(2);
                    if(pet.health){
                        System.out.println(t.name + " is cleaning a " + pet.breed + " cage. Oh no the " + pet.breed + " escaped." );
                    }
                    else{
                        System.out.println(t.name + " is cleaning a sick " + pet.breed + "'s cage. Oh no the " + pet.breed + " escaped." );
                    }
                    if(num1 == 0){
                        System.out.println(t.name + " has caught the " + pet.breed + " and returned it to the cage.");
                    }
                    if(num1 == 1){
                        System.out.println(c.name + " has caught the " + pet.breed + " and returned it to the cage.");
                    }
                }
                else{
                    if(pet.health){
                        System.out.println(t.name + " is cleaning a " + pet.breed + " cage.");
                    }
                    else{
                        System.out.println(t.name + " is cleaning a sick " + pet.breed + "'s cage.");
                    }
                }
            }
        }
    }
    void leaveStore(Clerk c, Trainer t){
        System.out.println(c.name + " is locking up the store. " + c.name + " and " + t.name + " are leaving the store.");
    }
}