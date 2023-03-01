import java.util.*;

public class PlayGame implements Reader,Writer,GridMaker{

    public PlayGame(){}
    public void StartGame(ArrayList<String> commands,
                          ArrayList<String> output,
                          GameGrid[][] array,
                          Player ActivePlayer,
                          ArrayList<Player> playerlist){

        output.add("Game grid: \n");

        GridOutPut(output,array);


        for(int i = 0; i < commands.size()-2; i++){

            String[] args = commands.get(i).split(" ");


            output.add("\nSelect coordinate or enter E to end the game: "+args[0]+" "+args[1]);

            try{
                if(Objects.equals(array[Integer.parseInt(args[0]) + 2][Integer.parseInt(args[1]) + 2].getSymbol(), " ")){
                    output.add("\nPlease enter a valid coordinate");
                }
                else{
                    array[Integer.parseInt(args[0])+2][Integer.parseInt(args[1])+2].
                            setCoord(array[Integer.parseInt(args[0])+2][Integer.parseInt(args[1])+2],array,ActivePlayer);

                    array[Integer.parseInt(args[0])+2][Integer.parseInt(args[1])+2].Slide(array);

                    GridOutPut(output,array);

                    output.add("\nScore: "+ ActivePlayer.getTemppoints()+" points");
                }

            }
            catch (Exception e ){
                output.add("\nPlease enter a valid coordinate");
            }


        }

        output.add("\nSelect coordinate or enter E to end the game: E");

        output.add("\nTotal score: "+ActivePlayer.getPoints()+" points");

        output.add("\nEnter name: "+ ActivePlayer.getName());

        output.add(ActivePlayer.SortandBinary(playerlist,ActivePlayer));

        output.add("\nGood bye!");


    }


    public void GridOutPut(ArrayList<String> output,
                           GameGrid[][] array){

        for (int i = 0; i < 10; i++) {

            StringBuilder onerow = new StringBuilder();

            for (int j = 0; j < 10; j++) {

                onerow.append(array[i+2][j+2].getSymbol()).append(" ");

            }

            output.add(String.valueOf(onerow));

        }



    }
}
