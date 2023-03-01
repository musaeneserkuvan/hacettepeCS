import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ActivePlayerCheck {

    public void  ActivePlayerChecker(ArrayList<Player> playerlist,
                         ArrayList<String> commands,Player ActivePlayer){


//// IF ACTIVE PLAYER IS EXIST IN THE LEADERBOARD , MAKE HIM ACTIVE PLAYER

        ArrayList<String> names = new ArrayList<>();


        for(Player p : playerlist){

            names.add(p.getName());
        }

        for(Player p : playerlist){
            if(Objects.equals(p.getName(), commands.get(commands.size() - 1))){

                ActivePlayer.setPoints(p.getPoints());
                ActivePlayer.setName(p.getName());

            }

        }

        if(!names.contains(commands.get(commands.size() - 1))){

            ActivePlayer.setPoints(0);
            ActivePlayer.setName(commands.get(commands.size() - 1));
            playerlist.add(ActivePlayer);

        }

    }


////     USING SORT AND BINARY-SEARCH METHODS FOR MONITORING TXT
    public String SortandBinary(ArrayList<Player> playerlist,Player ActivePlayer){

        ArrayList<Player> listclone = new ArrayList<>(playerlist);

        Collections.sort(listclone);

        int a = Collections.binarySearch(listclone,ActivePlayer);


        int b = listclone.size();

        String s ;

        if(a == 0){

            int c = ( listclone.get(a+1).getPoints() )   -    ( listclone.get(a).getPoints() );
            String d = listclone.get(a).getName();

            s = "\nYour rank is "+b+"/"+b+", your score is "+c+" points lower than "+d;
        }
        else if (a == b-1){

            int c = ( listclone.get(a).getPoints() )   -    ( listclone.get(a-1).getPoints() );
            String d = listclone.get(a-1).getName();

            s = "\nYour rank is "+1+"/"+b+", your score is "+c+" points higher than "+d;

        }
        else{

            int c = ( listclone.get(a+1).getPoints() )   -    ( listclone.get(a).getPoints() );
            String d = listclone.get(a+1).getName();

            int e = ( listclone.get(a).getPoints() )   -    ( listclone.get(a-1).getPoints() );
            String f = listclone.get(a-1).getName();

            int g = 4-a;

            s = "\nYour rank is "+g+"/"+b+", your score is "+c+" points lower than "+d+" and "+e+" points higher than "+f;

        }

        return s;

    }

}
