import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        PlayGame Game = new PlayGame();

//// read txt files

        ArrayList<String> commands = new ArrayList<>();

        ArrayList<ArrayList<String>> gamegrid = new ArrayList<>();

        ArrayList<Player> playerlist = new ArrayList<>();

        ArrayList<String> output = new ArrayList<>();


        Game.Read(commands,gamegrid,playerlist,args[0],args[1]);


//// create jewel objects

        GameGrid[][] array = new GameGrid[14][14];

        Game.gridMaker(gamegrid,array);

//// define active player

        Player Admin = new Player(9999,"ADMIN");

        Player ActivePlayer = new Player(0,"null");

        Admin.ActivePlayerChecker(playerlist,commands,ActivePlayer);

//// play game

        Game.StartGame(commands,output,array,ActivePlayer,playerlist);

        Game.Write(output,playerlist);

    }
}
