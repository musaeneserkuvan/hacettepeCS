
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.util.Objects;

public class DataDefiner implements Reader,OperationTimer,PasswordCoder,ButtonMethods,Writer{

    public void DefineData(Datas datas){

        try{

            ReadBackupdat(datas);

            ReadPropertiesDat(datas);
            DefineProperties(datas);

            ReadEffects(datas);

            ReadIcons(datas);

            DefineUser(datas);
            DefineFilm(datas);
            DefineHall(datas);
            DefineSeat(datas);

            ReadTrailers(datas);


            CreateNodes(datas);

            for(Films f : datas.getFilmsArrayList()){

                CreateMediaAction(datas,f.getMediaplayer());
            }



            CreateScenes(datas);

            CreateButtonActions(datas);

            SlideDefine(datas);

            for(Films f : datas.getFilmsArrayList()){
                for(Halls h : f.getHallslist()){
                    for(Seats s : h.getSeatslist()){

                        HoverCreater(datas,s);

                    }
                }
            }

            for(Films f : datas.getFilmsArrayList()){

                CreateMediaAction(datas,f.getMediaplayer());
            }



            CreateFirstStage(datas);

            StageActiviy(datas);



        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    public void DefineUser(Datas datas){

        for(String s : datas.getUserslist()){
            String[] argsline = s.split("\t");
            datas.setUsersArrayList(new Users(argsline[1],argsline[2],Boolean.parseBoolean(argsline[3]),Boolean.parseBoolean(argsline[4])));
        }

        datas.setObseruserlist(datas.getUsersArrayList());
    }

    public void DefineFilm(Datas datas){


        for(String s : datas.getFilmlist()){
            String[] argsline = s.split("\t");
            datas.setFilmsArrayList(new Films(argsline[1],argsline[2],argsline[3]));
        }

        datas.setObserfilmlist(datas.getFilmsArrayList());
    }

    public void DefineHall(Datas datas){

        for (String s : datas.getHalslist()){

            for(Films f : datas.getFilmsArrayList()){
                String[] argsline = s.split("\t");

                if(Objects.equals(argsline[1], f.getFilmName())){
                    f.setHallslist(new Halls(argsline[1],argsline[2],argsline[3],argsline[4],argsline[5]));

                }

                f.setObserhalllist(f.getHallslist());
            }
        }

    }

    public void DefineSeat(Datas datas){

        for (String s : datas.getSeatlist()){
            String[] argsline = s.split("\t");
            for(Films f : datas.getFilmsArrayList()){
                for (Halls h : f.getHallslist()){

                    if(Objects.equals(h.getFilmname(), argsline[1])){

                        int counter=0;

                        for(Users u : datas.getUsersArrayList()){

                            if(Objects.equals(argsline[5], u.getUsername())){
                                h.setSeatslist(new Seats(argsline[1],argsline[2],argsline[3],argsline[4],argsline[5],argsline[6],new ImageView(datas.getEmptyseat())));
                                break;
                            }
                            else{
                                counter++;

                            }


                        }
                        if(counter == datas.getUsersArrayList().size()){
                            h.setSeatslist(new Seats(argsline[1],argsline[2],argsline[3],argsline[4],"empty","0",new ImageView(datas.getEmptyseat())));

                        }

                    }
                }
            }
        }

    }

    public void CreateNodes(Datas datas){

        datas.getNodes().setButtonsObj(new Buttons());
        datas.getNodes().setTextObj(new Texts());
        datas.getNodes().setComboboxObj(new ComboBoxs(datas));
        datas.getNodes().setTextfieldObj(new Textfields());
        datas.getNodes().setTableviewObj(new Tableviews(datas));

    }

    public void CreateScenes(Datas datas){

        datas.getactiveSceneProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.intValue() == 1){

                datas.getScene().setScene1(new Scene(new Layout1(datas)));
            }
            else if(newValue.intValue() == 2){

                datas.getScene().setScene2(new Scene(new Layout2(datas)));

            }
            else if(newValue.intValue() == 3){

                datas.getScene().setScene3(new Scene(new Layout3(datas)));

            }
            else if(newValue.intValue() == 4){

                datas.getScene().setScene4(new Scene(new Layout4(datas)));

            }
            else if(newValue.intValue() == 5){

                datas.getScene().setScene5(new Scene(new Layout5(datas)));

            }
            else if(newValue.intValue() == 6){

                datas.getScene().setScene6(new Scene(new Layout6(datas)));

            }
            else if(newValue.intValue() == 7){

                datas.getScene().setScene7(new Scene(new Layout7(datas)));

            }
            else if(newValue.intValue() == 8){

                datas.getScene().setScene8(new Scene(new Layout8(datas)));

            }
            else if(newValue.intValue() == 9){

                datas.getScene().setScene9(new Scene(new Layout9(datas)));

                datas.getNodes().getButtonsObj().getVolumeslide().setValue(50);
                for (Films f : datas.getFilmsArrayList()){

                    f.getMediaplayer().setVolume( 1 - (datas.getNodes().getButtonsObj().getVolumeslide().getValue()/100) );

                }


            }
            else if(newValue.intValue() == 10){

                datas.getScene().setScene10(new Scene(new Layout10(datas)));

            }
        });

    }

    public void CreateButtonActions(Datas datas){

        datas.getNodes().getButtonsObj().getLogin().setOnAction(e -> loginMethod(datas));

        datas.getNodes().getButtonsObj().getAddfilm().setOnAction(e -> addfilmMethod(datas));
        datas.getNodes().getButtonsObj().getRemovefilm().setOnAction(e -> removefilmMethod(datas));
        datas.getNodes().getButtonsObj().getEdituser().setOnAction(e -> edituserMethod(datas));
        datas.getNodes().getButtonsObj().getLogout().setOnAction(e -> logoutMethod(datas));
        datas.getNodes().getButtonsObj().getOk() .setOnAction(e -> okMethod(datas));
        datas.getNodes().getButtonsObj().getBack().setOnAction(e -> backMethod(datas));
        datas.getNodes().getButtonsObj().getAddhall().setOnAction(e -> addhallMethod(datas));
        datas.getNodes().getButtonsObj().getRemovehall().setOnAction(e -> removehallMethod(datas));

        datas.getNodes().getButtonsObj().getPromotemember().setOnAction(e -> promoteMemberMethod(datas));
        datas.getNodes().getButtonsObj().getPromoteadmin().setOnAction(e -> promoteAdminMethod(datas));

        datas.getNodes().getButtonsObj().getPlaybutton().setOnAction( e -> PlayButtonMethod(datas));

        datas.getNodes().getButtonsObj().getForwardbutton().setOnAction(e -> ForwardMethod(datas));

        datas.getNodes().getButtonsObj().getBackwardbutton().setOnAction(e -> BackwardMethod(datas));

        datas.getNodes().getButtonsObj().getReplaybutton().setOnAction( e-> ReplayMethod(datas));

        datas.getNodes().getButtonsObj().getSignup().setOnAction( e-> signupmethod(datas));

    }

    public void HoverCreater(Datas datas, Seats seat){

        seat.getSeatbutton().setOnMouseEntered(e-> {

            if(datas.getActiveuser().get(0).isAdmin()) {

                for (Users u : datas.getUsersArrayList()) {

                    if (Objects.equals(seat.getOwnername(), u.getUsername())) {

                        datas.getNodes().getTextObj().getHoverText().setText("Bought by " + u.getUsername() + " for " + seat.getPricesold()+ " TL!");


                        break;

                    } else {

                        datas.getNodes().getTextObj().getHoverText().setText("Not bought yet!");



                    }

                }
            }
        });

        seat.getSeatbutton().setOnMouseExited(e-> datas.getNodes().getTextObj().getHoverText().setText(""));

        seat.getSeatbutton().setOnAction( e-> {


            ImageView empty = new ImageView(datas.getEmptyseat());
            ImageView reserved = new ImageView(datas.getReservedseat());

            empty.setFitWidth(50);
            empty.setFitHeight(50);

            reserved.setFitWidth(50);
            reserved.setFitHeight(50);

            int counter =0;

            for(Users u : datas.getUsersArrayList()){


                if(Objects.equals(u.getUsername(), seat.getOwnername())){

                    seat.setOwnername("empty");
                    datas.getNodes().getTextObj().getInfo().setText("Seat at "+ (Integer.parseInt(seat.getRow()) + 1) +"-"+(Integer.parseInt(seat.getCol()) + 1) +" is refunded successfully!");
                    seat.setPricesold("0");
                    seat.getSeatbutton().setGraphic(empty);
                    counter=0;
                    break;

                }

                else{

                    counter++;
                }
            }

            if(counter == datas.getUsersArrayList().size()){



                if(datas.getActiveuser().get(0).isAdmin()){

                    if(datas.getNodes().getComboboxObj().getUsers().getSelectionModel().getSelectedItem().isMember()){
                        seat.setOwnername(datas.getNodes().getComboboxObj().getUsers().getSelectionModel().getSelectedItem().getUsername());

                        int a = Integer.parseInt(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getPriceperseat()) * ((100 -datas.getDiscount()) / 100);

                        seat.setPricesold(String.valueOf(a));
                        datas.getNodes().getTextObj().getInfo().setText("Seat at "+(Integer.parseInt(seat.getRow()) + 1) +"-"+(Integer.parseInt(seat.getCol()) +1) +" is bought for "+datas.getNodes().getComboboxObj().getUsers().getSelectionModel().getSelectedItem().getUsername()+" for "+seat.getPricesold()+" TL successfully!");

                    }
                    else{
                        seat.setOwnername(datas.getNodes().getComboboxObj().getUsers().getSelectionModel().getSelectedItem().getUsername());
                        seat.setPricesold(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getPriceperseat());
                        datas.getNodes().getTextObj().getInfo().setText("Seat at "+(Integer.parseInt(seat.getRow()) + 1) +"-"+(Integer.parseInt(seat.getCol()) + 1) +" is bought for "+datas.getNodes().getComboboxObj().getUsers().getSelectionModel().getSelectedItem().getUsername()+" for "+seat.getPricesold()+" TL successfully!");

                    }

                }
                else{

                    if(datas.getActiveuser().get(0).isMember()){

                        seat.setOwnername(datas.getActiveuser().get(0).getUsername());

                        int b = Integer.parseInt(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getPriceperseat() ) * ((100 -datas.getDiscount()) / 100)  ;

                        seat.setPricesold(String.valueOf(b));
                        datas.getNodes().getTextObj().getInfo().setText("Seat at "+(Integer.parseInt(seat.getRow()) + 1) +"-"+(Integer.parseInt(seat.getCol()) + 1) +" is bought for "+seat.getPricesold()+" TL successfully!");


                    }
                    else{
                        seat.setOwnername(datas.getActiveuser().get(0).getUsername());
                        seat.setPricesold(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getPriceperseat());

                        datas.getNodes().getTextObj().getInfo().setText("Seat at "+(Integer.parseInt(seat.getRow()) + 1) +"-"+(Integer.parseInt(seat.getCol()) + 1) +" is bought for "+seat.getPricesold()+" TL successfully!");

                    }

                }

                seat.getSeatbutton().setGraphic(reserved);


            }



        });

    }

    public void CreateFirstStage(Datas datas){


        datas.getStage().getIcons().add(datas.getLogo());
        datas.getStage().setTitle(datas.getTitle());
        datas.getStage().setResizable(false);

        datas.getStage().setX(450);
        datas.getStage().setY(10);

        datas.getScene().setScene1(new Scene(new Layout1(datas)));
        datas.getStage().setScene(datas.getScene().getScene1());

        datas.getStage().show();


    }
    
    public void CreateMediaAction(Datas datas,MediaPlayer media){

        /// listener 1 change symbol
        media.statusProperty().addListener((observable, oldValue, newValue) -> {

            if(observable.getValue() == MediaPlayer.Status.PLAYING){
                datas.getNodes().getButtonsObj().getPlaybutton().setText(" [|] ");
            }
            else{
                datas.getNodes().getButtonsObj().getPlaybutton().setText("  >  ");
            }

        });

        datas.getErrorsound().setOnEndOfMedia( ()-> datas.getErrorsound().stop());

        /// listener 2 stop
        media.setOnEndOfMedia(()-> {

            media.seek(Duration.millis(media.getCycleDuration().toMillis()-500));
            media.pause();

        });

        /// listener 3 screen tracker
        datas.getactiveSceneProperty().addListener(  (observable, oldValue, newValue) -> {

            if(newValue.intValue() !=6){

                media.pause();

            }
        });









        
    }

    public void StageActiviy(Datas datas){


        datas.getStage().showingProperty().addListener((observable, oldValue, newValue) -> {

            if(!newValue){

                datas.Write(datas);
            }

        });


    }

    public void SlideDefine(Datas datas){

        datas.getNodes().getButtonsObj().getVolumeslide().valueProperty().addListener((observable1, oldValue1, newValue1) -> {

            if(!Objects.equals(newValue1, oldValue1)){

                for (Films f : datas.getFilmsArrayList()){
                    f.getMediaplayer().setVolume(1-(newValue1.doubleValue()/100));
                }
            }



        });
    }

    public void DefineProperties(Datas datas){


        for(String s : datas.getPropertieslist()){

            if(!Objects.equals(s, "#Properties of Cinema System") && !s.equals("#Wed Apr 20 03:09:50 EET 2022")){

                String[] args = s.split("=");

                if(Objects.equals(args[0], "maximum-error-without-getting-blocked")){
                    datas.setmaxerror(Integer.parseInt(args[1]));
                }
                else if(Objects.equals(args[0], "title")){
                    datas.settitle(args[1]);
                }
                else if(Objects.equals(args[0], "discount-percentage")){
                    datas.setdiscount(Integer.parseInt(args[1]));
                }
                else if(Objects.equals(args[0], "block-time")){
                    datas.setblocktime(Integer.parseInt(args[1]));
                }

            }



        }
    }




}
