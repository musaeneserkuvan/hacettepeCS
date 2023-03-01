import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class WildCrush extends GameGrid{


    static ArrayList<String> types = new ArrayList<>(Arrays.asList("D", "T", "S","W"));

    public WildCrush(String symbol, int row, int col, int point) {
        super(symbol, row, col, point);
    }

    @Override
    public void crushJ(int row,
                int col,
                int row1,
                int col1,
                int row2,
                int col2,
                int row3,
                int col3,
                int row4,
                int col4,
                GameGrid[][] array,
                       Player ActivePlayer){





        if(Objects.equals(array[row1][col1].getSymbol(), array[row2][col2].getSymbol()) ){

            if(types.contains(array[row1][col1].getSymbol())){

                CRUSH(row,col,row1,col1,row2,col2,array,ActivePlayer,array[row1][col1],array[row2][col2]);
            }

        }
        else if(Objects.equals(array[row1][col1].getSymbol(), "W")  || Objects.equals(array[row2][col2].getSymbol(), "W") ){

            if(types.contains(array[row1][col1].getSymbol()) && types.contains(array[row2][col2].getSymbol())){

                CRUSH(row,col,row1,col1,row2,col2,array,ActivePlayer,array[row1][col1],array[row2][col2]);

            }
        }

        else if(Objects.equals(array[row3][col3].getSymbol(), array[row4][col4].getSymbol()) ){

            if(types.contains(array[row3][col3].getSymbol())){

                CRUSH(row,col,row3,col3,row4,col4,array,ActivePlayer,array[row3][col3],array[row4][col4]);
            }

        }
        else if(Objects.equals(array[row3][col3].getSymbol(), "W")  || Objects.equals(array[row4][col4].getSymbol(), "W") ){

            if(types.contains(array[row3][col3].getSymbol()) && types.contains(array[row4][col4].getSymbol())){

                CRUSH(row,col,row3,col3,row4,col4,array,ActivePlayer,array[row3][col3],array[row4][col4]);
            }
        }




    }


}
