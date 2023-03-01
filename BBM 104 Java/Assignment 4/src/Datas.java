import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Datas extends DataDefiner {

    private  Stage stage;

    private  Scenes scene;


    private int LoginCount=0;

    private int LoginCounter2=0;

    private  IntegerProperty ActiveScene;



    private  ArrayList<String> userslist;

    private  ArrayList<Users> usersArrayList;

    private ObservableList<Users> obseruserlist;

    private  ArrayList<Users> activeuser;



    private  ArrayList<String> filmlist;

    private  ArrayList<Films> filmsArrayList;

    private ObservableList<Films> obserfilmlist;


    private  ArrayList<String> halslist;

    private  ArrayList<String> seatlist;

    private  ArrayList<String> propertieslist;

    private  Nodes nodes;

    private MediaPlayer errorsound;

    private Image disabledseat;

    private Image emptyseat;

    private ImageView movie;

    private ImageView hctplogo;

    private ImageView halls;

    private Image logo;

    private Image reservedseat;

    private int maxerror=0;

    private int blocktime=0;

    private String title;

    private int discount=0;



    public Datas() {

        this.userslist = new ArrayList<>();
        this.filmlist = new ArrayList<>();
        this.halslist = new ArrayList<>();
        this.seatlist = new ArrayList<>();
        this.propertieslist= new ArrayList<>();
        this.filmsArrayList= new ArrayList<>();
        this.usersArrayList= new ArrayList<>();
        this.nodes= new Nodes();
        this.stage=new Stage();
        this.scene=new Scenes();
        this.activeuser=new ArrayList<>();
        this.ActiveScene = new SimpleIntegerProperty(0);
    }

    public int getMaxerror() {
        return maxerror;
    }

    public int getBlocktime() {
        return blocktime;
    }

    public String getTitle() {
        return title;
    }

    public int getDiscount() {
        return discount;
    }

    public void setmaxerror(Integer a){

        this.maxerror=a;

    }
    public void setdiscount(Integer a){

        this.discount=a;

    }
    public void setblocktime(Integer a){

        this.blocktime=a;

    }
    public void settitle(String s){

        this.title=s;

    }

    public ArrayList<Users> getActiveuser() {
        return activeuser;
    }

    public void setActiveuser(Users u) {
        this.activeuser.add(u);
    }

    public void delActiveuser(){
        this.activeuser.clear();
    }

    public ObservableList<Users> getObseruserlist() {
        return obseruserlist;
    }

    public void setObseruserlist(ArrayList<Users> list) {

        this.obseruserlist = FXCollections.observableArrayList(list);
    }

    public ObservableList<Films> getObserfilmlist() {
        return obserfilmlist;
    }

    public void setObserfilmlist(ArrayList<Films> list) {
        this.obserfilmlist = FXCollections.observableArrayList(list);
    }

    public Scenes getScene() {
        return scene;
    }



    public Stage getStage() {
        return stage;
    }


    public IntegerProperty getactiveSceneProperty() {
        return ActiveScene;
    }

    public void setActiveScene(int activeScene) {
        this.ActiveScene.setValue(activeScene);

    }

    public Integer getActiveScene(){

        return this.ActiveScene.get();
    }

    public int getLoginCounter2() {
        return LoginCounter2;
    }

    public void setLoginCounter2(Integer a ) {

        if(a == 1){
            this.LoginCounter2+=a;
        }
        else if(a == 0){
            this.LoginCounter2 = a;
        }

    }

    public int getLoginCount() {
        return LoginCount;
    }

    public void setLoginCount(Integer a) {
        LoginCount +=a;
    }

    public void resetLoginCount(){

        LoginCount=0;
    }

    public Nodes getNodes() {
        return nodes;
    }

    public ImageView getHalls() {
        return halls;
    }

    public void setHalls(Image halls) {
        this.halls = new ImageView(halls);
    }

    public ArrayList<Films> getFilmsArrayList() {
        return filmsArrayList;
    }

    public void setFilmsArrayList(Films f) {
        this.filmsArrayList.add(f);
    }

    public ArrayList<Users> getUsersArrayList() {
        return usersArrayList;
    }

    public void setUsersArrayList(Users u) {
        this.usersArrayList.add(u);
    }

    public Image getEmptyseat() {
        return emptyseat;
    }

    public void setEmptyseat(FileInputStream empty) {
        this.emptyseat = new Image(empty);
    }

    public ImageView getMovie() {
        return movie;
    }

    public void setMovie(Image movie) {
        this.movie = new ImageView(movie);
    }

    public ImageView getHctplogo() {
        return hctplogo;
    }

    public void setHctplogo(Image image) {
        this.hctplogo = new ImageView(image);
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(FileInputStream logo) {
        this.logo = new Image(logo);
    }

    public Image getReservedseat() {
        return reservedseat;
    }

    public void setReservedseat(FileInputStream reserved) {
        this.reservedseat = new Image(reserved);
    }

    public Image getDisabledseat() {
        return disabledseat;
    }

    public void setDisabledseat(FileInputStream disabledseat) {
        this.disabledseat = new Image(disabledseat);
    }

    public MediaPlayer getErrorsound() {
        return errorsound;
    }

    public void setErrorsound(Media errorsound) {
        this.errorsound = new MediaPlayer(errorsound);
    }

    public ArrayList<String> getPropertieslist() {
        return propertieslist;
    }

    public void setPropertieslist(String s) {
        this.propertieslist.add(s);
    }

    public ArrayList<String> getUserslist() {
        return userslist;
    }

    public ArrayList<String> getFilmlist() {
        return filmlist;
    }

    public ArrayList<String> getHalslist() {
        return halslist;
    }

    public ArrayList<String> getSeatlist() {
        return seatlist;
    }


    public void setUserslist(String s) {
        this.userslist.add(s);
    }

    public void setFilmlist(String s) {
        this.filmlist.add(s);
    }

    public void setHalslist(String s) {
        this.halslist.add(s);
    }

    public void setSeatlist(String s) {
        this.seatlist.add(s);
    }

}
