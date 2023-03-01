
public abstract class GameGrid implements CrushJewels,CheckCoord,SlideJewels {

    private int row;
    private int col;

    private String symbol;

    private int point;


    public GameGrid(String symbol, int row, int col,int point) {

        this.symbol=symbol;
        this.row = row;
        this.col = col;
        this.point=point;

    }



//// GETTER AND SETTERS

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }


}
