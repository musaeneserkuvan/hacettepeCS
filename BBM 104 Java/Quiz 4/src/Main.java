import java.util.ArrayList;
import java.util.*;


public class Main{

    public static void main(String[] args) {

        Writer write = new Writer();

        ArrayList<Contact> contactList = new ArrayList<>();

        Read read = new Read(contactList,args[0]);

        write.WriteTxt(contactList,"contactsArrayList.txt");

/// LAST NAME ///

        Collections.sort(contactList,new LastNameComparator());

        write.WriteTxt(contactList,"contactsArrayListOrderByLastName.txt");


/// MAKING A HASH SET ///

        HashSet<Contact> contactHashSet = new HashSet<>(contactList);

        write.WriteTxt(contactHashSet,"contactsHashSet.txt");

/// MAKING A TREE SET ///

        TreeSet<Contact> contactTreeSet = new TreeSet<>(contactList);

        write.WriteTxt(contactTreeSet,"contactsTreeSet.txt");

/// MAKING A NEW TREE SET ///

        TreeSet<Contact> contactTreeSet2 = new TreeSet<>(  new LastNameComparator()    );

        contactTreeSet2.addAll(contactList);

        write.WriteTxt(contactTreeSet2,"contactsTreeSetOrderByLastName.txt");

/// MAKING A HASH MAP ///

        write.WriteTxtMap(contactList,"contactsHashMap.txt");


    }
}
