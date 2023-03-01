import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    private static final ArrayList<String> CommandList= new ArrayList<>();

    public ArrayList<String> getCommandList() {
        return CommandList;
    }


    public Reader(String txt) {
        try {
            File myObj = new File(txt);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String Line = myReader.nextLine();
                CommandList.add(Line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
