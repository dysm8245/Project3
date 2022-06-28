public class Simulation implements Logger{
    Simulation(){

    }
    void run(){
        Employees staff = new Employees();//initializes a staff object
        Inventory stock = new Inventory();//initializes Inventory with 3 of every subclass
        Register r = new Register();//initializes a register with $0
        staff.hire();//creates two clerks and two trainers to work store
        int daysOpen = 31;
        for(int i = 1; i < daysOpen; i++){
            //stock.items();
            clear(i);
            staff.ArriveAtStore(i);//method in employees class
            Clerk c = staff.getClerk();
            Trainer t = staff.getTrainer();
            c.processDeliveries(c, stock, i);//method in clerk class
            t.feedAnimals(stock, t, i);//method in trainer class
            c.checkRegister(c, r, i);//method in clerk class
            c.doInventory(c, stock, r, i);//method in clerk class
            t.trainAnimals(stock, i);
            staff.openStore(stock,c,t,r,i);//method in employees class
            staff.cleanStore(stock, c, t, i);//method in employees class
            staff.leaveStore(c,t, i);//method in employees class
        }
        System.out.println("       -------End Simulation-------");
        stock.summary(r, daysOpen-1);//method in Inventory class
    }
}