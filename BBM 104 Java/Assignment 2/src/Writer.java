import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
public class Writer{

    public Writer() {

    }

    public void WriteTxt(MethodSquare funcobj){
        try {

            FileWriter myWriter = new FileWriter("output.txt");

            for (String s : funcobj.getOutputList()) {
                myWriter.write(s + "\n");
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}