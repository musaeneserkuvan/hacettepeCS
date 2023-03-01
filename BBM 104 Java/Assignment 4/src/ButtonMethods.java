import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Objects;

public interface ButtonMethods {

    default void loginMethod(Datas datas ){


        if(datas.getActiveScene() == 0 || datas.getActiveScene() == 1 ){
            if(datas.getLoginCount() != datas.getMaxerror()){

                if(!Objects.equals("", datas.getNodes().getTextfieldObj().getText1field().getText()) && !Objects.equals("", datas.getNodes().getTextfieldObj().getText2field().getText())){

                    for(Users u : datas.getUsersArrayList() ){

                        if(Objects.equals(u.getUsername(), datas.getNodes().getTextfieldObj().getText1field().getText()) && Objects.equals(u.getPasswordBase64encoded(),datas.hashPassword(datas.getNodes().getTextfieldObj().getText2field().getText()) )){

                            datas.setLoginCounter2(0);

                            datas.setActiveuser(u);

                            datas.setActiveScene(2);


                            datas.getStage().setScene( datas.getScene().getScene2());

                            datas.getNodes().getTextfieldObj().getText1field().clear();
                            datas.getNodes().getTextfieldObj().getText2field().clear();

                            break;

                        }
                        else{

                            datas.setLoginCounter2(1);

                            if(datas.getLoginCounter2()==datas.getUsersArrayList().size()){

                                if(datas.getLoginCount()  == (datas.getMaxerror()-1)){


                                    datas.setLoginCount(1);
                                    datas.setLoginCounter2(0);
                                    datas.getNodes().getTextObj().getInfo().setText("ERROR: Please wait 5 seconds to make a new operation");
                                    datas.getErrorsound().play();
                                    /// ERROR: Please wait 5 seconds to make a new operation

                                    datas.DelayTime(datas);


                                }
                                else{
                                    datas.setLoginCounter2(0);
                                    datas.getNodes().getTextfieldObj().getText2field().clear();
                                    datas.setLoginCount(1);
                                    datas.getNodes().getTextObj().getInfo().setText("ERROR: There is no such a credential!");
                                    datas.getErrorsound().play();

                                }

                            }

                        }

                    }
                }
                else{

                    if(datas.getLoginCount()  == (datas.getMaxerror()-1)){
                        datas.setLoginCount(1);

                        datas.getErrorsound().play();
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: Please wait 5 seconds to make a new operation");
                        /// ERROR: Please wait 5 seconds to make a new operation
                        datas.DelayTime(datas);


                    }
                    else{

                        if(!Objects.equals("", datas.getNodes().getTextfieldObj().getText1field().getText()) && Objects.equals("", datas.getNodes().getTextfieldObj().getText2field().getText())){
                            datas.setLoginCount(1);
                            datas.getNodes().getTextObj().getInfo().setText("ERROR: Password can not be empty!");
                            datas.getErrorsound().play();

                        }
                        else{
                            datas.getNodes().getTextfieldObj().getText2field().clear();
                            datas.getErrorsound().play();
                            datas.getNodes().getTextObj().getInfo().setText("ERROR: Username can not be empty!");
                            datas.setLoginCount(1);
                        }

                    }

                }

            }

            else{


                datas.getErrorsound().play();
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Please wait until the end of the 5 seconds to make a new operation!");
                datas.getNodes().getTextfieldObj().getText2field().clear();
                ///ERROR: Please wait until the end of the 5 seconds to make a new operation!

            }
        }
        else if(datas.getActiveScene()== 10){
            datas.setActiveScene(1);
            datas.getStage().setScene( datas.getScene().getScene1());
        }


    }



    default void addfilmMethod(Datas datas ){

        datas.setActiveScene(3);

        datas.getStage().setScene( datas.getScene().getScene3());
        

    }
    default void removefilmMethod(Datas datas){

        datas.setActiveScene(4);

        datas.getStage().setScene( datas.getScene().getScene4());


    }


    default void backMethod(Datas datas){

        if(datas.getActiveScene()==3 || datas.getActiveScene()==4 || datas.getActiveScene()==5 || datas.getActiveScene()==6){

            datas.setActiveScene(2);
            datas.getStage().setScene( datas.getScene().getScene2());
        }
        else if (datas.getActiveScene()==7 || datas.getActiveScene()==8 || datas.getActiveScene()==9){
            datas.setActiveScene(6);
            datas.getStage().setScene( datas.getScene().getScene6());
        }


    }

    default void logoutMethod(Datas datas){

        /// if logout stop media go to seek 0
        for(Films  f : datas.getFilmsArrayList()){
            f.getMediaplayer().seek(Duration.millis(0));
        }
        datas.setActiveScene(1);
        datas.getStage().setScene( datas.getScene().getScene1());
        datas.delActiveuser();

    }


    default void okMethod(Datas datas)  {

        if(datas.getActiveScene()==2){

            if(datas.getFilmsArrayList().size() == 0){

                datas.getNodes().getTextObj().getInfo().setText("ERROR: There is no film to display!");
                datas.getErrorsound().play();

            }
            else{
                datas.setActiveScene(6);
                datas.getStage().setScene( datas.getScene().getScene6());
            }


        }
        else if (datas.getActiveScene()==6){

            if(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().size() == 0){

                datas.getNodes().getTextObj().getInfo().setText("ERROR: There is no hall!");
                datas.getErrorsound().play();

            }
            else{
                datas.setActiveScene(9);
                datas.getStage().setScene( datas.getScene().getScene9());
            }



        }
        else if (datas.getActiveScene()==7){/// add hall

            if(Objects.equals(datas.getNodes().getTextfieldObj().getText6field().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Name can not be empty!");
                datas.getErrorsound().play();

            }
            else if(Objects.equals(datas.getNodes().getTextfieldObj().getText7field().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Price can not be empty!");
                datas.getErrorsound().play();
            }

            else{

                int counter5 = 0;
                int counter6 =0;

                for(Films f : datas.getFilmsArrayList()){

                    int counter4 = 0;

                    for (Halls h : f.getHallslist()){

                        if(Objects.equals(h.getHallname(), datas.getNodes().getTextfieldObj().getText6field().getText())){
                            datas.getNodes().getTextObj().getInfo().setText("ERROR: This Hall Name already exist!");
                            counter6++;
                            datas.getErrorsound().play();
                            break;
                        }
                        else{
                            counter4++;
                            counter6++;
                        }

                    }
                    counter5 +=counter4;

                }


                if(counter5 == counter6 ){
                    counter5=0;
                    counter6=0;


                    try{
                        int a = Integer.parseInt(datas.getNodes().getTextfieldObj().getText7field().getText());
                    }
                    catch (Exception e){
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: Price must be positive integer!");
                        datas.getErrorsound().play();

                    }
                    int b = Integer.parseInt(datas.getNodes().getTextfieldObj().getText7field().getText());
                    if(b<= 0 ){
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: Price must be positive integer!");
                        datas.getErrorsound().play();

                    }
                    else{

                        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().setHallslist(new Halls(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getFilmName(),
                                datas.getNodes().getTextfieldObj().getText6field().getText(),
                                datas.getNodes().getTextfieldObj().getText7field().getText(),
                                datas.getNodes().getComboboxObj().getRow().getSelectionModel().getSelectedItem(),
                                datas.getNodes().getComboboxObj().getCol().getSelectionModel().getSelectedItem()
                        ));


                        for (int i = 0; i < Integer.parseInt(datas.getNodes().getComboboxObj().getRow().getSelectionModel().getSelectedItem()); i++) {

                            for (int j = 0; j < Integer.parseInt(datas.getNodes().getComboboxObj().getCol().getSelectionModel().getSelectedItem()); j++) {

                                datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().get(
                                        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().size()-1).setSeatslist
                                        (new Seats(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getFilmName(),
                                                datas.getNodes().getTextfieldObj().getText6field().getText(),
                                                Integer.toString(i),
                                                Integer.toString(j),
                                                "empty",
                                                "0",
                                                new ImageView(datas.getEmptyseat()))
                                        );
                                datas.HoverCreater( datas,datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().get(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().size()-1).getSeatslist().get(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().get(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().size()-1).getSeatslist().size()-1));

                            }

                        }
                        datas.getNodes().getComboboxObj().getRow().getSelectionModel().selectFirst();
                        datas.getNodes().getComboboxObj().getCol().getSelectionModel().selectFirst();

                        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().setObserhalllist(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist());

                        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().CreateHallBox();

                        datas.getNodes().getTextfieldObj().getText6field().clear();
                        datas.getNodes().getTextfieldObj().getText7field().clear();

                        datas.getNodes().getTextObj().getInfo().setText("New Hall successfully added!");

                    }

                }

            }





        }
        else if(datas.getActiveScene()==8){/// remove hall

            for(Halls h : datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist()){
                if(Objects.equals(h.getHallname(), datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getHallname())){

                    datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist().remove(h);
                    datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getObserhalllist().clear();

                    datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().setObserhalllist(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHallslist());
                    // belkide gethalls list sonrası get halldan da remove et

                    datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().setItems(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getObserhalllist());
                    datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().selectFirst();


                    datas.getNodes().getTextObj().getInfo().setText("Hall successfully removed!");

                    break;
                }
            }


        }
        else if (datas.getActiveScene()==4){ /// remove film

            datas.getFilmsArrayList().remove(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem());

            datas.getObserfilmlist().clear();

            datas.setObserfilmlist(datas.getFilmsArrayList());


            datas.getNodes().getComboboxObj().getFilms().setItems(datas.getObserfilmlist()); /// boş cıkmazsa

            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().selectFirst();



            datas.getNodes().getTextObj().getInfo().setText("Film successfully removed!");


        }

        else if (datas.getActiveScene()==3){ /// add film screen

            if(Objects.equals(datas.getNodes().getTextfieldObj().getText3field().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Film name could not be empty!");
                datas.getErrorsound().play();

            }
            else if (Objects.equals(datas.getNodes().getTextfieldObj().getText4field().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Trailer path could not be empty!");
                datas.getErrorsound().play();
            }
            else{

                int counter3 =0;
                for(Films f : datas.getFilmsArrayList()){

                    if(Objects.equals(f.getFilmName(), datas.getNodes().getTextfieldObj().getText3field().getText()) || Objects.equals(f.getTrailerpath(), datas.getNodes().getTextfieldObj().getText4field().getText())){
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: This Film already exist!");
                        datas.getErrorsound().play();
                        break;
                    }
                    else{
                        counter3++;
                    }
                }

                if(counter3 == datas.getFilmsArrayList().size()){

                    counter3=0;
                    try{
                        if(Objects.equals(datas.getNodes().getTextfieldObj().getText5field().getText(), "") || Integer.parseInt(datas.getNodes().getTextfieldObj().getText5field().getText()) <= 0){
                            datas.getNodes().getTextObj().getInfo().setText("ERROR: Duration must be positive integer!");
                            datas.getErrorsound().play();


                        }
                        else{

                            datas.setFilmsArrayList(new Films(datas.getNodes().getTextfieldObj().getText3field().getText(),datas.getNodes().getTextfieldObj().getText4field().getText(),datas.getNodes().getTextfieldObj().getText5field().getText()));

                            datas.getFilmsArrayList().get(datas.getFilmsArrayList().size()-1).setMediaplayer(new MediaPlayer(new Media(new File("assets\\trailers\\"+datas.getFilmsArrayList().get(datas.getFilmsArrayList().size()-1).getTrailerpath()).toURI().toURL().toString())));
                            datas.getFilmsArrayList().get(datas.getFilmsArrayList().size()-1).setMediaview(datas.getFilmsArrayList().get(datas.getFilmsArrayList().size()-1).getMediaplayer());

                            datas.CreateMediaAction(datas,datas.getFilmsArrayList().get(datas.getFilmsArrayList().size()-1).getMediaplayer());

                            datas.getObserfilmlist().clear();
                            datas.setObserfilmlist(datas.getFilmsArrayList());
                            datas.getNodes().getComboboxObj().getFilms().setItems(datas.getObserfilmlist()); /// boş cıkmazsa
                            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().selectFirst();

                            datas.getNodes().getTextObj().getInfo().setText("New Film Successfully added!");



                        }
                    }
                    catch (NumberFormatException e ){
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: Duration must be positive integer!");
                        datas.getErrorsound().play();

                    }
                    catch (MediaException | MalformedURLException e){
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: There is no such a trailer!");
                        datas.getErrorsound().play();

                    }
                }
            }
        }
    }

    default void edituserMethod(Datas datas){
        datas.setActiveScene(5);
        datas.getStage().setScene( datas.getScene().getScene5());

    }

    default void addhallMethod(Datas datas){

        datas.setActiveScene(7);
        datas.getStage().setScene( datas.getScene().getScene7());

    }

    default void removehallMethod(Datas datas){

        datas.setActiveScene(8);
        datas.getStage().setScene( datas.getScene().getScene8());

    }
    default void promoteMemberMethod(Datas datas){

        /// olmazsa remove filmdeki işlemi yap refresh methodu da kullan
        datas.getNodes().getTableviewObj().getTableview().getSelectionModel().getSelectedItem().setMember(!datas.getNodes().getTableviewObj().getTableview().getSelectionModel().getSelectedItem().isMember());

        datas.getNodes().getTableviewObj().getTableview().refresh();

    }
    default void promoteAdminMethod(Datas datas){

        datas.getNodes().getTableviewObj().getTableview().getSelectionModel().getSelectedItem().setAdmin(!datas.getNodes().getTableviewObj().getTableview().getSelectionModel().getSelectedItem().isAdmin());

        datas.getNodes().getTableviewObj().getTableview().refresh();

    }

    default void PlayButtonMethod(Datas datas){


        MediaPlayer.Status status = datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getStatus();

        if(status != MediaPlayer.Status.PLAYING ){

            if(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getCurrentTime().toMillis() ==datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getStopTime().toMillis()-500 ){
                datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().seek(Duration.millis(0));
                datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().play();
            }
            else{
                datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().play();
            }


        }

        else {

            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().pause();

        }




    }

    default void ForwardMethod(Datas datas){


        if(  datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getCurrentTime().toMillis()+5000L < datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getStopTime().toMillis()){

            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().seek(Duration.millis(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getCurrentTime().toMillis()+5000L) );

        }
        else{

            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().seek(Duration.millis(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getCycleDuration().toMillis()-500));
            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().pause();

        }


    }

    default void BackwardMethod(Datas datas){

        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().seek(Duration.millis(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getCurrentTime().toMillis()-5000L));

    }

    default void ReplayMethod(Datas datas){

        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().seek(Duration.millis(0));

        if(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().getStatus() == MediaPlayer.Status.PLAYING){
            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().play();
        }
        else{
            datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaplayer().pause();
        }


    }



    default void signupmethod(Datas datas){

        if(datas.getActiveScene() == 0 || datas.getActiveScene() == 1){

            datas.setActiveScene(10);
            datas.getStage().setScene( datas.getScene().getScene10());

        }

        else if(datas.getActiveScene() == 10){

            if(Objects.equals(datas.getNodes().getTextfieldObj().getNamefield().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Username can not be empty!");
                datas.getErrorsound().play();
            }
            else if (Objects.equals(datas.getNodes().getTextfieldObj().getPassfield1().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Password can not be empty!");
                datas.getErrorsound().play();
            }
            else if (Objects.equals(datas.getNodes().getTextfieldObj().getPassfield2().getText(), "")){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Password can not be empty!");
                datas.getErrorsound().play();
            }
            else if (!Objects.equals(datas.hashPassword(datas.getNodes().getTextfieldObj().getPassfield2().getText()) ,datas.hashPassword(datas.getNodes().getTextfieldObj().getPassfield1().getText())) ){
                datas.getNodes().getTextObj().getInfo().setText("ERROR: Passwords does not match!");
                datas.getErrorsound().play();
            }
            else{

                int counter=0;

                for (Users u : datas.getUsersArrayList()){

                    if(Objects.equals(datas.getNodes().getTextfieldObj().getNamefield().getText(), u.getUsername())){
                        datas.getNodes().getTextObj().getInfo().setText("ERROR: This Username already exist!");
                        datas.getErrorsound().play();
                    }
                    else{
                        counter++;
                    }
                }

                if(counter == datas.getUsersArrayList().size()){

                    counter=0;

                    datas.setUsersArrayList(new Users(datas.getNodes().getTextfieldObj().getNamefield().getText(),datas.hashPassword(datas.getNodes().getTextfieldObj().getPassfield2().getText()),false,false ));
                    datas.getNodes().getTextObj().getInfo().setText("SUCCESS: You have successfully registered with your new credentials!");
                    datas.getNodes().getTextfieldObj().getNamefield().clear();
                    datas.getNodes().getTextfieldObj().getPassfield1().clear();
                    datas.getNodes().getTextfieldObj().getPassfield2().clear();
                }


            }

        }

    }
}
