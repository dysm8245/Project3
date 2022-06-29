import java.util.*;
public class Employees implements Logger{
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

    void getCommand(Command command){
        command.execute();
    }//command pattern to get command from user
    void interact(Inventory I, Employees staff){//so user can interact with employees at the store
        boolean flag = true;
        Clerk c = getClerk();
        Trainer t = getTrainer();
        while(flag){
            System.out.println("How may we help you today?");
            System.out.println("Enter 1 to select your store");
            System.out.println("Enter 2 to ask for the employee names");
            System.out.println("Enter 3 to get the time");
            System.out.println("Enter 4 to shop");
            System.out.println("Enter 5 for more information about an item");
            System.out.println("Enter 6 to purchase an item");
            System.out.println("Enter 7 to quit");
            Scanner scan = new Scanner(System.in);
            String a = scan.nextLine();
            switch(a){//switch case for issuing commands
                case "1":
                    System.out.println("boop");
                    break;
                case "2":
                    Name name = new Name(c,t);
                    staff.getCommand(name);
                    break;
                case "3":
                    Time time = new Time(c);
                    staff.getCommand(time);
                    break;
                case "4":
                    Shop shop = new Shop(I,t);
                    staff.getCommand(shop);
                    break;
                case "5":
                    System.out.println("boop");
                    break;
                case "6":
                    System.out.println("boop");
                    break;
                case "7":
                    flag = false;
                    break;
                default:
                    System.out.println("That is an invalid input.");
                    break;

            }
        }
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
                    out(clerks[i].name + " the clerk arrives at the store on day " + days + ".\n", days);
                    workingC = clerks[i];
                    clerks[i].daysWorked++;
                    break;
                }
            }
            clerks[num].daysWorked=0;
        }
        else{
            out(clerks[num].name + " the clerk arrives at the store on day " + days + ".\n", days);
            workingC = clerks[num];
            clerks[num].daysWorked++;
        }
        if(trainers[num1].daysWorked == 3) {
            for(int i = 0; i < trainers.length; i++){
                if(trainers[num1] == trainers[i]){
                    continue;
                }
                else{
                    out(trainers[i].name + " the trainer arrives at the store on day " + days + ".\n", days);
                    workingT = trainers[i];
                    trainers[i].daysWorked++;
                    break;
                }
            }
            trainers[num1].daysWorked = 0;
        }
        else{
            out(trainers[num1].name + " the trainer arrives at the store on day " + days + ".\n", days);
            workingT = trainers[num1];
            trainers[num1].daysWorked++;
        }
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
            out("Customer " + cust + " has entered the store.\n", day);
            for(int j = 0; j < I.items.size(); j++){
                Item item = I.items.get(j);
                buyChance = rand.nextInt(10);
                if(buyChance == 0){
                    if(item.name == "pet"){
                        Pet pet = (Pet) item;
                        if(pet.health){
                            out("Customer " + cust + " is thinking about buying a " + pet.breed +".\n", day);
                            noDeal = rand.nextInt(2);
                            if(noDeal == 0){
                                add = rand.nextInt(4);
                                out(c.name + " says Customer " + cust + " will pay for the " + pet.breed +" at list price.\n", day);
                                pet.salePrice = pet.listPrice;
                                pet.daySold = day;
                                I.items.remove(pet);
                                I.soldItems.add(pet);
                                r.amount += pet.salePrice;
                                if(add == 0){
                                    Insurance addOn = new Insurance();
                                    addOn.addIns(pet, day);
                                }
                                else if(add == 1){
                                    amount = rand.nextInt(5);
                                    if(amount == 0){
                                        amount = 1;
                                    }
                                    Vet addOn = new Vet();
                                    addOn.addVisits(pet,amount, day);
                                }
                                else{
                                    Microchip addOn = new Microchip();
                                    addOn.addMicro(pet, day);
                                }
                                out(c.name + " is adding $" + pet.salePrice + " to the register.\n", day);
                                j = I.items.size();
                                out("Customer " + cust + " has left the store after buying a " + pet.breed + ".\n", day);
                            }
                            else{
                                out(t.name + " offered Customer " + cust + " a 10% discount on the " + pet.breed + "\n", day);
                                deal = rand.nextInt(4);
                                if(deal != 0){
                                    add = rand.nextInt(4);
                                    out("Customer " + cust + " will pay for the " + pet.breed +" with a 10% discount\n", day);
                                    pet.salePrice = (float) (pet.listPrice*0.9);
                                    pet.daySold = day;
                                    I.items.remove(pet);
                                    I.soldItems.add(pet);
                                    r.amount += pet.salePrice;
                                    if(add == 0){
                                        Insurance addOn = new Insurance();
                                        addOn.addIns(pet, day);
                                    }
                                    else if(add == 1){
                                        amount = rand.nextInt(5);
                                        if(amount == 0){
                                            amount = 1;
                                        }
                                        Vet addOn = new Vet();
                                        addOn.addVisits(pet,amount, day);
                                    }
                                    else{
                                        Microchip addOn = new Microchip();
                                        addOn.addMicro(pet, day);
                                    }
                                    out(c.name + " is adding $" + pet.salePrice + " to the register.\n", day);
                                    j = I.items.size();
                                    out("Customer " + cust + " has left the store after buying a " + pet.breed + ".\n", day);
                                }
                                else{
                                    out("Customer " + cust + " will continue to look at other items.\n", day);
                                }
                            }
                        }
                    }
                    else{
                        out("Customer " + cust + " is thinking about buying a " + item.name +".\n", day);
                        noDeal = rand.nextInt(2);
                        if(noDeal == 0){
                            out(c.name + " says Customer " + cust + " will pay for the " + item.name +" at list price.\n", day);
                            item.salePrice = item.listPrice;
                            item.daySold = day;
                            I.items.remove(item);
                            I.soldItems.add(item);
                            r.amount += item.salePrice;
                            out(c.name + " is adding $" + item.salePrice + " to the register.\n", day);
                            j = I.items.size();
                            out("Customer " + cust + " has left the store after buying a " + item.name + ".\n", day);
                        }
                        else{
                            out(t.name + " offered Customer " + cust + " a 10% discount on the " + item.name + "\n", day);
                            deal = rand.nextInt(4);
                            if(deal != 0){
                                out("Customer " + cust + " will pay for the " + item.name +" with a 10% discount\n", day);
                                item.salePrice = (float) (item.listPrice*0.9);
                                item.daySold = day;
                                I.items.remove(item);
                                I.soldItems.add(item);
                                r.amount += item.salePrice;
                                out(c.name + " is adding $" + item.salePrice + " to the register.\n", day);
                                j = I.items.size();
                                out("Customer " + cust + " has left the store after buying a " + item.name + ".\n", day);
                            }
                            else{
                                out("Customer " + cust + " will continue to look at other items.\n", day);
                            }
                        }
                    }
                }
                if(j == I.items.size()-1){
                    out("Customer " + cust + " has left the store without buying an item.\n", day);
                }
            }
        }
    }
    void cleanStore(Inventory I, Clerk c, Trainer t, int day){
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
                        out(t.name + " is cleaning a " + pet.breed + " cage. Oh no the " + pet.breed + " escaped.\n", day);
                    }
                    else{
                        out(t.name + " is cleaning a sick " + pet.breed + "'s cage. Oh no the " + pet.breed + " escaped.\n", day );
                    }
                    if(num1 == 0){
                        out(t.name + " has caught the " + pet.breed + " and returned it to the cage.\n", day);
                    }
                    if(num1 == 1){
                        out(c.name + " has caught the " + pet.breed + " and returned it to the cage.\n", day);
                    }
                }
                else{
                    if(pet.health){
                        out(t.name + " is cleaning a " + pet.breed + " cage.\n", day);
                    }
                    else{
                        out(t.name + " is cleaning a sick " + pet.breed + "'s cage.\n", day);
                    }
                }
            }
        }
    }
    void leaveStore(Clerk c, Trainer t, int day){
        out(c.name + " is locking up the store. " + c.name + " and " + t.name + " are leaving the store.\n", day);
    }
}