import java.util.ArrayList;

public class Halls {

    private  String filmname;

    private  String hallname;

    private  String priceperseat;

    private String row;

    private String col;

    private  ArrayList<Seats> seatslist;

    public Halls(String filmname, String hallname, String priceperseat, String row, String col) {
        this.filmname = filmname;
        this.hallname = hallname;
        this.priceperseat = priceperseat;
        this.row = row;
        this.col = col;
        this.seatslist=new ArrayList<>();
    }

    public String getFilmname() {
        return filmname;
    }



    public String getHallname() {
        return hallname;
    }



    public String getPriceperseat() {
        return priceperseat;
    }


    public String getRow() {
        return row;
    }

    public String getCol() {
        return col;
    }

    public void setRow(String row) {
        this.row = row;
    }



    public void setCol(String col) {
        this.col = col;
    }

    public ArrayList<Seats> getSeatslist() {
        return seatslist;
    }

    public void setSeatslist(Seats s) {
        this.seatslist.add(s);
    }
}
