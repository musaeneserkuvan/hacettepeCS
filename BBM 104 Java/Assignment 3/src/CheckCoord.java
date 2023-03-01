

public interface CheckCoord {

    default  void setCoord(GameGrid o, GameGrid[][] array,
                           Player ActivePlayer){

        String[] methodargs = null;

        ActivePlayer.setTempPoints(0);


        if(o instanceof JewelD){

            methodargs = ((JewelD) o).method.split(",");


        }
        else if(o instanceof JewelS){

            methodargs = ((JewelS) o).method.split(",");


        }
        else if(o instanceof JewelT){

            methodargs = ((JewelT) o).method.split(",");


        }
        else if(o instanceof JewelW){



            methodargs = ((JewelW) o).method.split(",");


        }
        else if(o instanceof JewelMinus){

            methodargs =  ((JewelMinus) o).method.split(",");


        }
        else if(o instanceof JewelPlus){

            methodargs = ((JewelPlus) o).method.split(",");


        }
        else if(o instanceof JewelPerpendicular){

            methodargs = ((JewelPerpendicular) o).method.split(",");


        }
        else if(o instanceof JewelSlash){

            methodargs = ((JewelSlash) o).method.split(",");


        }
        else if(o instanceof JewelReverseSlash){

            methodargs = ((JewelReverseSlash) o).method.split(",");

        }


        assert methodargs != null;
        for (String methodarg : methodargs) {




            switch (methodarg) {

                case "left diagonal":
                    o.crushJ(o.getRow(),
                            o.getCol(),
                            o.getRow() - 1,
                            o.getCol() - 1,
                            o.getRow() - 2,
                            o.getCol() - 2,
                            o.getRow() + 1,
                            o.getCol() + 1,
                            o.getRow() + 2,
                            o.getCol() + 2, array,ActivePlayer
                    );
                    break;

                case "right diagonal":
                    o.crushJ(o.getRow(),
                            o.getCol(),
                            o.getRow() - 1,
                            o.getCol() + 1,
                            o.getRow() - 2,
                            o.getCol() + 2,
                            o.getRow() + 1,
                            o.getCol() - 1,
                            o.getRow() + 2,
                            o.getCol() - 2, array,ActivePlayer
                    );
                    break;

                case "horizontal":
                    o.crushJ(o.getRow(),
                            o.getCol(),
                            o.getRow(),
                            o.getCol() - 1,
                            o.getRow(),
                            o.getCol() - 2,
                            o.getRow(),
                            o.getCol() + 1,
                            o.getRow(),
                            o.getCol() + 2, array,ActivePlayer
                    );
                    break;

                case "vertical":
                    o.crushJ(o.getRow(),
                            o.getCol(),
                            o.getRow() - 1,
                            o.getCol(),
                            o.getRow() - 2,
                            o.getCol(),
                            o.getRow() + 1,
                            o.getCol(),
                            o.getRow() + 2,
                            o.getCol(), array,ActivePlayer
                    );
                    break;

            }

            if(ActivePlayer.getTemppoints()!= 0 ){
                break;
            }

        }

    }
}
