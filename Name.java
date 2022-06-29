public class Name implements Command{
    Clerk c;
    Trainer t;
    Name(Clerk clerk, Trainer trainer){
        c = clerk;
        t = trainer;
    }
    public void execute(){
        System.out.println("The clerk working today is " + c.name + ".");
        System.out.println("The clerk working today is " + t.name + ".");
    }
}
