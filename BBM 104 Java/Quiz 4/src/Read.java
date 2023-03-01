import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Read {

    public Read(Collection<Contact> contactList,String txt){
        try {

            File myObj = new File(txt);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {

                String[] LineArgs = myReader.nextLine().split(" ");
                Contact contact = new Contact ( LineArgs[0],LineArgs[1],LineArgs[2],LineArgs[3] );
                contactList.add( contact );
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
