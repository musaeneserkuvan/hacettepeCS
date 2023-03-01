public interface CrushJewels {

    void crushJ(int row,
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
                Player ActivePlayer);

    default void CRUSH(int row, int col, int row1, int col1, int row2, int col2, GameGrid[][] array, Player ActivePlayer, GameGrid gameGrid, GameGrid gameGrid2) {

        array[row1][col1].setSymbol(" ");
        array[row2][col2].setSymbol(" ");
        array[row][col].setSymbol(" ");

        ActivePlayer.setTempPoints(gameGrid.getPoint()+ gameGrid2.getPoint()+array[row][col].getPoint());
        ActivePlayer.setPoints(gameGrid.getPoint()+ gameGrid2.getPoint()+array[row][col].getPoint());

    }



}
