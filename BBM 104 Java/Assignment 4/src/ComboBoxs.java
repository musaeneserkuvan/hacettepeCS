import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class ComboBoxs {

    public ComboBox<Users> users = new ComboBox<>();

    public ComboBox<Users> getUsers() {
        return users;
    }



    public ComboBox<Films> films = new ComboBox<>();
    public ComboBox<Films> getFilms() {
        return films;
    }






    public ComboBox<String> row = new ComboBox<>();

    public ComboBox<String> getRow() {
        return row;
    }



    public ComboBox<String> col = new ComboBox<>();

    public ComboBox<String> getCol() {
        return col;
    }

    public ComboBoxs(Datas datas){

        CreateFilmBox(datas);
        CreateUserBox(datas);
        CreateRowColBox();
        CreateHallBox(datas);

    }

    public void CreateFilmBox(Datas datas){


        this.films.setItems(datas.getObserfilmlist());



        Callback<ListView<Films>, ListCell<Films>> factory = lv2 -> new ListCell<Films>() {


            @Override
            protected void updateItem(Films item, boolean empty) {
                super.updateItem(item, empty);


                if (item == null || empty) {

                    setGraphic(null);
                    this.setTextFill(Color.BLACK);

                } else {

                    String s = item.getFilmName();

                    setText(s);
                    this.setTextFill(Color.BLACK);
                }


            }

        };

        this.films.setCellFactory(factory);
        this.films.setButtonCell(factory.call(null));



        this.films.getSelectionModel().selectFirst();

    }

    public void CreateUserBox(Datas datas){


        this.users.setItems(datas.getObseruserlist());


        Callback<ListView<Users>, ListCell<Users>> factory2 = lv3 -> new ListCell<Users>() {


            @Override
            protected void updateItem(Users item, boolean empty) {
                super.updateItem(item, empty);


                if (item == null || empty) {

                    setGraphic(null);
                    this.setTextFill(Color.BLACK);

                } else {

                    String s = item.getUsername();

                    setText(s);
                    this.setTextFill(Color.BLACK);
                }


            }

        };

        this.users.setCellFactory(factory2);
        this.users.setButtonCell(factory2.call(null));



        this.users.getSelectionModel().selectFirst();



    }



    public void CreateHallBox(Datas datas){

        for(Films f : datas.getFilmsArrayList()){

            f.CreateHallBox();

        }



    }


    public void CreateRowColBox(){


        for (int i = 3; i <11; i++) {

            this.row.getItems().add(String.valueOf(i));
            this.col.getItems().add(String.valueOf(i));

        }

        this.row.getSelectionModel().selectFirst();
        this.col.getSelectionModel().selectFirst();

    }






}
