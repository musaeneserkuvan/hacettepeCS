import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Seats {

    private String filmname;

    private String hallname;

    private String row;

    private String col;

    private String ownername;

    private String pricesold;

    private Button seatbutton;

    public Seats(String filmname, String hallname, String row, String col, String ownername, String pricesold, ImageView empty) {
        this.filmname = filmname;
        this.hallname = hallname;
        this.row = row;
        this.col = col;
        this.ownername = ownername;
        this.pricesold = pricesold;

        this.seatbutton= new Button();

        empty.setFitWidth(50);
        empty.setFitHeight(50);
        /// add here dataobj get user list and forla döndür null değil /// solved issue at layout9
        this.seatbutton.setGraphic(empty);

    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getPricesold() {
        return pricesold;
    }

    public void setPricesold(String pricesold) {
        this.pricesold = pricesold;
    }

    public Button getSeatbutton() {
        return seatbutton;
    }

    public void setSeatbutton(Button seatbutton) {
        this.seatbutton = seatbutton;
    }
}
