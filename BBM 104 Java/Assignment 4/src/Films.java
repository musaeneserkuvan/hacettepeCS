import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.util.ArrayList;


public class Films {

    private  StringProperty filmName;
    private  String filmduration;
    private  StringProperty trailerpath;


    private  ArrayList<Halls> hallslist;

    private ObservableList<Halls> obserhalllist;

    public ComboBox<Halls> halls = new ComboBox<>();


    private MediaPlayer mediaplayer;

    private MediaView mediaview;



    public Films(String filmname,String trailerpath,String duration) {

        this.filmName = new SimpleStringProperty(this,filmname,filmname);
        this.filmduration= duration;
        this.trailerpath= new SimpleStringProperty(this,trailerpath,trailerpath);
        this.hallslist= new ArrayList<>();


    }

    public ObservableList<Halls> getObserhalllist() {
        return obserhalllist;
    }

    public MediaView getMediaview() {
        return mediaview;
    }

    public void setMediaview(MediaPlayer media) {
        this.mediaview = new MediaView(media);
    }

    public void setObserhalllist(ArrayList<Halls> list) {

        this.obserhalllist = FXCollections.observableArrayList(list);
    }

    public ComboBox<Halls> getHalls() {
        return halls;
    }

    public void CreateHallBox(){

        this.halls.setItems(this.obserhalllist);

        Callback<ListView<Halls>, ListCell<Halls>> factory = lv3 -> new ListCell<Halls>() {

            @Override
            protected void updateItem(Halls item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {

                    setGraphic(null);
                    this.setTextFill(Color.BLACK);
                } else {
                    String s = item.getHallname();
                    setText(s);
                    this.setTextFill(Color.BLACK);
                }


            }

        };

        this.halls.setCellFactory(factory);
        this.halls.setButtonCell(factory.call(null));
        this.halls.getSelectionModel().selectFirst();

    }

    public MediaPlayer getMediaplayer() {
        return mediaplayer;
    }

    public void setMediaplayer(MediaPlayer mediaplayer) {
        this.mediaplayer = mediaplayer;
    }

    public ArrayList<Halls> getHallslist() {
        return hallslist;
    }

    public void setHallslist(Halls h) {
        this.hallslist.add(h);
    }

    public String getFilmName() {
        return filmName.get();
    }





    public String getFilmduration() {
        return filmduration;
    }



    public String getTrailerpath() {
        return trailerpath.get();
    }




}
