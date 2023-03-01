import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Reader {

    default void Read(
            ArrayList<String> commands,
            ArrayList<ArrayList<String>> gamegrid,
            ArrayList<Player> playerlist,String txt1,String txt2)  {

        try {

/// command

            File commandObj = new File(txt2);
            Scanner commandobj2 = new Scanner(commandObj);

            while (commandobj2.hasNextLine()) {

                String Line = commandobj2.nextLine();
                commands.add(Line);

            }

            commandobj2.close();

/// game grid

            File gamegridobj = new File(txt1);
            Scanner gamegridobj2 = new Scanner(gamegridobj);

            int a =0;



            while (gamegridobj2.hasNextLine()) {

                String[] Line = gamegridobj2.nextLine().split(" ");

                gamegrid.add(new ArrayList<>());
                
                for (int i = 0; i < 10; i++) {
                    
                    gamegrid.get(a).add(Line[i]);
                    
                }
                
                a +=1;

            }

            gamegridobj2.close();

/// leaderboard

            File leaderboardobj = new File("leaderboard.txt");
            Scanner leaderboardobj2 = new Scanner(leaderboardobj);

            while (leaderboardobj2.hasNextLine()) {

                String[] LineArgs = leaderboardobj2.nextLine().split(" ");
                playerlist.add(new Player(Integer.parseInt(LineArgs[1]) ,LineArgs[0]));

            }

            leaderboardobj2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
