import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Objects;

public class Layout9 extends Pane {

    public Layout9(Datas datas){

        this.setMinSize(1000, 1000);

        /// TEXTS SYSTEM INFO
        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());


        /// line film box 2d

        Line line1 = new Line(100,90,900,90);
        this.getChildren().add(line1);

        Line line2 = new Line(100,90,100,790);
        this.getChildren().add(line2);

        Line line3 = new Line(100,790,900,790);
        this.getChildren().add(line3);

        Line line4 = new Line(900,790,900,90);
        this.getChildren().add(line4);

        /// BUTTONS BACK

        datas.getNodes().getButtonsObj().getBack().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getBack().relocate(100,820);
        this.getChildren().add(datas.getNodes().getButtonsObj().getBack());

        /// TEXTS HOVER
        datas.getNodes().getTextObj().getHoverText().setText("    "); /// gir cık yapınca layout 9a layout6dan text takılı kalıyor boş yapmak lazım
        datas.getNodes().getTextObj().getHoverText().relocate(610,825);
        this.getChildren().add(datas.getNodes().getTextObj().getHoverText());


        /// TEXTS FİLM TİTLE
        Text filmtext = new Text();
        filmtext.setText(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getFilmName()+"("+datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getFilmduration()+" minutes)"+" Hall: "+datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getHallname());
        filmtext.setFont(new Font(25));
        filmtext.setWrappingWidth(filmtext.getLayoutBounds().getWidth());
        filmtext.setStrokeWidth(filmtext.getLayoutBounds().getWidth());
        filmtext.relocate(500 - (filmtext.getLayoutBounds().getWidth()  / 2),7);
        filmtext.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(filmtext);

        /// TEXTS ROW COL NUMBERS
        for (int i = 1; i < 11; i++) {

            Text number = new Text(Integer.toString(i));
            number.setFont( new Font(30));
            number.relocate(128+(i-1)*80,50);
            this.getChildren().add(number);

            Text abc = new Text(Integer.toString(i));
            abc.setFont( new Font(30));
            abc.relocate(60,100+(i-1)*70);
            this.getChildren().add(abc);
        }


        /// COMBOBOX






        /// CREATE DİSABLED BUTTONS
        for (int i = 0; i <10 ; i++) {

            for (int j = 0; j <10 ; j++) {

                Button a = new Button();

                ImageView b = new ImageView(datas.getDisabledseat());

                b.setFitWidth(50);
                b.setFitHeight(50);

                a.setGraphic(b);

                a.setDisable(true);

                a.relocate(105+80*j,95+70*i);
                this.getChildren().add(a);

            }

        }

        /// ADD SEAT BUTTONS
        int row =  1+Integer.parseInt(  datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().size()-1).getRow());
        int col =1+Integer.parseInt(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().size()-1).getCol());

        for (int i = 0; (i < row); i++) {

            for (int j = 0; j < col; j++) {



                for(Node b : this.getChildren()){

                    if( b.getLayoutX() == 105+80*j && b.getLayoutY() == 95+70*i){

                        this.getChildren().remove(b);


                        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i*col+j).getSeatbutton().setDisable(false);

                        for(Users u : datas.getUsersArrayList()){

                            if(Objects.equals(  u.getUsername(), datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i * col + j).getOwnername())){


                                ImageView reserved = new ImageView(datas.getReservedseat());
                                reserved.setFitWidth(50);
                                reserved.setFitHeight(50);

                                datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i * col + j).getSeatbutton().setGraphic(reserved);

                                if(!datas.getActiveuser().get(0).isAdmin() && !Objects.equals(datas.getActiveuser().get(0).getUsername(), datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i * col + j).getOwnername() )){


                                    datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i*col+j).getSeatbutton().setDisable(true);
                                }

                                break;
                            }
                        }



                        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i*col+j).getSeatbutton().relocate(105+80*j,95+70*i);
                        this.getChildren().add(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().getSelectedItem().getSeatslist().get(i*col+j).getSeatbutton());

                        break;
                    }
                }
            }
        }

        datas.getObseruserlist().clear();

        datas.setObseruserlist(datas.getUsersArrayList());

        datas.getNodes().getComboboxObj().getUsers().setItems(datas.getObseruserlist());

        datas.getNodes().getComboboxObj().getUsers().getSelectionModel().select(datas.getActiveuser().get(0));

        if(datas.getActiveuser().get(0).isAdmin()){

            datas.getNodes().getComboboxObj().getUsers().relocate(250,820);
            datas.getNodes().getComboboxObj().getUsers().setPrefSize(300,50);
            this.getChildren().add(datas.getNodes().getComboboxObj().getUsers());

        }

    }
}
