import java.io.*;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
/// READ PEOPLE    ///
        People[] pLs = new People[100];
        File txtpeople = new File("people.txt");
        BufferedReader txtpeopleread = new BufferedReader(new FileReader(txtpeople));
        String linepeople = txtpeopleread.readLine();
        int p = 0;
        while (linepeople != null) {
            List<String> templistpeople = new ArrayList<>(Arrays.asList(linepeople.split("\t")));
            pLs[p] = new People(templistpeople.get(0), templistpeople.get(1), templistpeople.get(2), templistpeople.get(3), templistpeople.get(4), templistpeople.get(5));
            p++;
            linepeople = txtpeopleread.readLine();
        }
        txtpeopleread.close();
/// READ FOOD    ///
        Food[] fLs = new Food[100];
        File txtfood = new File("food.txt");
        BufferedReader txtfoodread = new BufferedReader(new FileReader(txtfood));
        String linefood = txtfoodread.readLine();
        int f = 0;
        while (linefood != null) {
            List<String> templistfood = new ArrayList<>(Arrays.asList(linefood.split("\t")));
            fLs[f] = new Food(templistfood.get(0), templistfood.get(1), templistfood.get(2));
            f++;
            linefood = txtfoodread.readLine();
        }

        txtfoodread.close();
/// READ SPORT    ///
        Sport[] sLs = new Sport[100];
        File txtsport = new File("sport.txt");
        BufferedReader txtsportread = new BufferedReader(new FileReader(txtsport));
        String linesport = txtsportread.readLine();
        int s = 0;
        while (linesport != null) {
            List<String> templistsport = new ArrayList<>(Arrays.asList(linesport.split("\t")));
            sLs[s] = new Sport(templistsport.get(0), templistsport.get(1), templistsport.get(2));
            s++;
            linesport = txtsportread.readLine();
        }
        txtsportread.close();

        File txtcommand = new File(args[0]);
        BufferedReader txtcommandread = new BufferedReader(new FileReader(txtcommand));
        String linecommand = txtcommandread.readLine();

        LinkedHashSet<Integer> ID = new LinkedHashSet<>();
        LinkedHashSet<Integer> W = new LinkedHashSet<>();


        try (FileWriter monitoring = new FileWriter("monitoring.txt")) {
            while (linecommand != null)
            {
                List<String> templistcommand = new ArrayList<>(Arrays.asList(linecommand.split("\t")));

                for (int i = 0; i < p; i++)
                {
                    for (int j = 0; j < f; j++)
                    {
                        if (Objects.equals(pLs[i].getpID(), templistcommand.get(0)) && Objects.equals(fLs[j].getFoodID(), templistcommand.get(1)))
                        {
                            ID.add(i);
                            pLs[i].CalTaken += Integer.parseInt(fLs[j].getFoodCal()) * Integer.parseInt(templistcommand.get(2));
                            monitoring.write(pLs[i].getpID() + "\thas\ttaken\t" + Integer.parseInt(fLs[j].getFoodCal()) * Integer.parseInt(templistcommand.get(2)) + "kcal\tfrom\t" + fLs[j].getFoodName() + "\n");
                        }
                    }
                    for (int k = 0; k <s ; k++)
                    {
                        if (Objects.equals(pLs[i].getpID(), templistcommand.get(0)) && Objects.equals(sLs[k].getSportID(), templistcommand.get(1)))
                        {
                            ID.add(i);
                            pLs[i].CalBurn += Integer.parseInt(sLs[k].getSportCal()) * ((Integer.parseInt(templistcommand.get(2))))/60;
                            monitoring.write(pLs[i].getpID() + "\thas\tburned\t" + Integer.parseInt(sLs[k].getSportCal()) * ((Integer.parseInt(templistcommand.get(2))))/60 + "kcal\tthank to\t" + sLs[k].getSportName() + "\n");
                        }
                    }
                    if(Objects.equals(pLs[i].getpGender(), "male")){
                        pLs[i].DailyCalNeeds =(int) Math.round ( 66 +(13.75 * Integer.parseInt(pLs[i].getpW())) +( 5 * Integer.parseInt(pLs[i].getpH())) - (6.8 * (2022 - ( Integer.parseInt( pLs[i].getpBD())))) );

                    }
                    else{
                        pLs[i].DailyCalNeeds = (int) Math.round ( 665 +(9.6 * Integer.parseInt(pLs[i].getpW())) +( 1.7 * Integer.parseInt(pLs[i].getpH())) - (4.7 * (2022 - ( Integer.parseInt( pLs[i].getpBD())))) );
                    }

                    if (Objects.equals(templistcommand.get(0), "print(" + pLs[i].getpID() + ")")){
                        if (pLs[i].CalTaken -  pLs[i].CalBurn -  pLs[i].DailyCalNeeds>0){
                            monitoring.write(pLs[i].getpName()+"\t"+ (2022 - ( Integer.parseInt( pLs[i].getpBD()))) + "\t"+ pLs[i].DailyCalNeeds+"kcal\t"+pLs[i].CalTaken+"kcal\t"+pLs[i].CalBurn+"kcal\t"+"+" +(  pLs[i].CalTaken -  pLs[i].CalBurn -  pLs[i].DailyCalNeeds  )+"kcal\n");
                        }
                        else {
                            monitoring.write(pLs[i].getpName()+"\t"+ (2022 - ( Integer.parseInt( pLs[i].getpBD()))) + "\t"+ pLs[i].DailyCalNeeds+"kcal\t"+pLs[i].CalTaken+"kcal\t"+pLs[i].CalBurn+"kcal\t"+(  pLs[i].CalTaken -  pLs[i].CalBurn -  pLs[i].DailyCalNeeds  )+"kcal\n");
                        }
                    }
                }
                if(Objects.equals(templistcommand.get(0), "printList")){
                    for ( int a : ID){
                        if (pLs[a].CalTaken -  pLs[a].CalBurn -  pLs[a].DailyCalNeeds>0){
                            monitoring.write(pLs[a].getpName()+"\t"+ (2022 - ( Integer.parseInt( pLs[a].getpBD()))) + "\t"+ pLs[a].DailyCalNeeds+"kcal\t"+pLs[a].CalTaken+"kcal\t"+pLs[a].CalBurn+"kcal\t"+"+" +(  pLs[a].CalTaken -  pLs[a].CalBurn -  pLs[a].DailyCalNeeds  )+"kcal\n");
                        }
                        else {
                            monitoring.write(pLs[a].getpName()+"\t"+ (2022 - ( Integer.parseInt( pLs[a].getpBD()))) + "\t"+ pLs[a].DailyCalNeeds+"kcal\t"+pLs[a].CalTaken+"kcal\t"+pLs[a].CalBurn+"kcal\t"+(  pLs[a].CalTaken -  pLs[a].CalBurn -  pLs[a].DailyCalNeeds  )+"kcal\n");
                        }
                    }
                }

                else if(Objects.equals(templistcommand.get(0), "printWarn")){

                    for ( int x : ID){

                        if ( (pLs[x].CalTaken)-(pLs[x].CalBurn)-(pLs[x].DailyCalNeeds) > 0){
                            W.add(x);

                        }

                    }
                    if (W.isEmpty()){
                        monitoring.write("there is no such person\n");
                    }
                    else{
                        for (int x :W){
                            monitoring.write(pLs[x].getpName()+"\t"+ (2022 - ( Integer.parseInt( pLs[x].getpBD()))) + "\t"+ pLs[x].DailyCalNeeds+"kcal\t"+pLs[x].CalTaken+"kcal\t"+pLs[x].CalBurn+"kcal\t"+"+"+ (  pLs[x].CalTaken -  pLs[x].CalBurn -  pLs[x].DailyCalNeeds  )+"kcal\n");
                        }
                    }
                }

                linecommand = txtcommandread.readLine();
                if (linecommand != null) {
                    monitoring.write("***************\n");
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }}

