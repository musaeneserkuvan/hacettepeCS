import java.util.ArrayList;

public interface GridMaker  {


    default void gridMaker(ArrayList<ArrayList<String>> gamegrid,
                           Object[][] array ) {



        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                switch (gamegrid.get(i).get(j)){

                    case "D": array[i+2][j+2] =(new JewelD("D",i+2,j+2,30));
                        break;

                    case "S": array[i+2][j+2] =(new JewelS("S",i+2,j+2,15));
                        break;

                    case "T": array[i+2][j+2] =(new JewelT("T",i+2,j+2,15));
                        break;

                    case "W": array[i+2][j+2] =(new JewelW("W",i+2,j+2,10));
                        break;

                    case "-": array[i+2][j+2] =(new JewelMinus("-",i+2,j+2,20));
                        break;

                    case "+": array[i+2][j+2] =(new JewelPlus("+",i+2,j+2,20));
                        break;

                    case "|": array[i+2][j+2] =(new JewelPerpendicular("|",i+2,j+2,20));
                        break;

                    case "/": array[i+2][j+2] =(new JewelSlash("/",i+2,j+2,20));
                        break;

                    case "\\": array[i+2][j+2] =(new JewelReverseSlash("\\",i+2,j+2,20));
                        break;


                }

                for (int k = 0; k < 14; k++) {
                    for (int l = 0; l < 14; l++) {

                        if(array[k][l] == null){
                            array[k][l] = new NormalCrush(null,999,999,999);
                        }

                    }

                }


            }
        }



    }


}
