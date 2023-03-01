import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String args[])
            throws IOException
    {

        File myFile = new File(args[0]);
        List<String> mainlist = new ArrayList<>();

        List<Integer> armL = new ArrayList<>(); // for arm numbers
        List<Integer> asL = new ArrayList<>(); // asc sort list
        List<Integer> dsL = new ArrayList<>(); // dsc sort list

        BufferedReader bf = new BufferedReader(new FileReader(myFile));

        String line = bf.readLine();
        while (line != null) {
            mainlist.add(line);
            line = bf.readLine();
        }
        bf.close();

        int mainlistlen = mainlist.size();

        int Asc = 0;
        int Dsc = 0;
        int Ext = 0;
        String[] array = mainlist.toArray(new String[0]);

        for (int i = 0; i < mainlistlen; i++) {
            if (Objects.equals(array[i], "Ascending order sorting")) {
                Asc = Asc + i;
                for (int i1 = 1; i1 < i; i1++) {
                    int intt = Integer.parseInt(array[i1]);
                    Collections.addAll(armL, intt);
                }
            } else if (Objects.equals(array[i], "Descending order sorting")) {
                Dsc = Dsc + i;
                for (int i9 = Asc + 1; i9 < i; i9++) {
                    if (Objects.equals(array[i9], "-1")) {

                        for (int i2 = Asc + 1; i2 < i9; i2++) {
                            int intt2 = Integer.parseInt(array[i2]);
                            Collections.addAll(asL, intt2);
                        }
                    }
                }
            } else if (Objects.equals(array[i], "Exit")) {
                Ext = Ext + i;
                for (int i9 = Dsc + 1; i9 < i; i9++) {
                    if (Objects.equals(array[i9], "-1")) {
                        for (int i3 = Dsc + 1; i3 < i9; i3++) {
                            int intt3 = Integer.parseInt(array[i3]);
                            Collections.addAll(dsL, intt3);
                        }
                    }
                }

            }
        }


        List<List<Integer>> armresult2 = new ArrayList<>();

        for (Integer value : armL) {
            List<Integer> armresult = new ArrayList<>();
            for (int n1 = 99; n1 < value; n1++) {
                int length = String.valueOf(n1).length();
                String n2 = String.valueOf(n1);
                List<Integer> arr1 = new ArrayList<>();
                for (int n3 = 0; n3 < length; n3++) {
                    String str = n2.substring(n3, n3 + 1);
                    int str1 = Integer.parseInt(str);
                    double str2 = Math.pow(str1, length);
                    int str3 = (int) str2;
                    Collections.addAll(arr1, str3);
                }
                int sum = 0;
                for (Integer integer : arr1) {
                    sum += integer;
                }
                if (n1 == sum) {
                    Collections.addAll(armresult, n1);
                }
            }
            armresult2.add(armresult);
        }

        List<List<Integer>> aslresult = new ArrayList<>();

        int asLlen = asL.size();
        int a = 1;
        for (int i10 = 0; i10 < asLlen; i10++) {
            List<Integer> asl1 = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                Collections.addAll(asl1, asL.get(i));
            }
            Collections.sort(asl1);
            a = a + 1;
            aslresult.add(asl1);
        }

        List<List<Integer>> dslresult = new ArrayList<>();

        int dsLlen = dsL.size();
        int b = 1;
        for (int i10 = 0; i10 < dsLlen; i10++) {
            List<Integer> dsl1 = new ArrayList<>();
            for (int i = 0; i < b; i++) {
                Collections.addAll(dsl1, dsL.get(i));
            }
            dsl1.sort(Collections.reverseOrder());
            b = b + 1;
            dslresult.add(dsl1);
        }

        PrintWriter writer = new PrintWriter(args[1]);
        writer.println("Calculating Armstrong numbers");
        for (List<Integer> integers : armresult2) {
            writer.println(integers.toString().replace("[", "").replace(",", "").replace("]", ""));

        }
        writer.println("Ascending order sorting" );
        for (List<Integer> integers : aslresult) {
            writer.println(integers.toString().replace("[", "").replace(",", "").replace("]", ""));

        }
        writer.println("Descending order sorting" );

        for (List<Integer> integers : dslresult) {
            writer.println(integers.toString().replace("[", "").replace(",", "").replace("]", ""));
        }
        writer.println("Terminated..");
        writer.close();

    }
}