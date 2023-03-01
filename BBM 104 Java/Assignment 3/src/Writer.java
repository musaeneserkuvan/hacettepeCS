import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public interface Writer {



    default void Write(ArrayList<String> output,ArrayList<Player> playerlist){

        try {

/// monitoring

            FileWriter monitoring = new FileWriter("monitoring.txt");
            for (String str: output ) {
                monitoring.write(str+"\n");
            }
            monitoring.close();

//// leaderboard

            FileWriter leaderboard = new FileWriter("leaderboard.txt");

            for (Player player_arrayList_of_object : playerlist) {
                leaderboard.write(player_arrayList_of_object.getName() + " " + player_arrayList_of_object.getPoints() + "\n");
            }
            leaderboard.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
