import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Writer{

    public Writer() {

    }
    public void WriteTxt(Collection<Contact> obj, String str){
        try {

            FileWriter myWriter = new FileWriter(str);
            Iterator<Contact> itr1 =obj.iterator();

            while(itr1.hasNext()){

                Contact st= itr1.next();
                myWriter.write(st.getPhoneNumber()+" "+st.getFirstName()+" "+st.getLastName()+" "+st.getSocialSecurityNumber()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteTxtMap(Collection<Contact> obj, String str) {
        try {

            FileWriter myWriter = new FileWriter(str);

            HashMap<String,Contact> contactHashMap = new HashMap<>();

            Iterator<Contact> itr1 =obj.iterator();

            while(itr1.hasNext()){

                Contact st= itr1.next();

                contactHashMap.put(st.getPhoneNumber(),st);
            }

            Iterator<Contact> itr2 =contactHashMap.values().iterator();

            while(itr2.hasNext()){

                Contact st= itr2.next();

                myWriter.write(st.getPhoneNumber()+" "+st.getFirstName()+" "+st.getLastName()+" "+st.getSocialSecurityNumber()+"\n");

            }


            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}