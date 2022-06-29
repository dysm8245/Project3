import java.text.SimpleDateFormat;
import java.util.Date;

public class Time implements Command{
    Clerk c;
    Time(Clerk clerk){
        c = clerk;
    }
    public void execute(){
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        System.out.println(c.name + " says it's " + dateFormat.format(dt));
    }
}