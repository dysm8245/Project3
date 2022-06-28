import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public interface Logger{

    default void out(String msg, int day) {
        String file = ("logger-" + day + ".txt");
        try {
            File f1 = new File(file);
            f1.createNewFile();
            FileWriter fileWriter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(msg);
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}