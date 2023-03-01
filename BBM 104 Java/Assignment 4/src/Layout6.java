import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class Layout6 extends Pane {

    public Layout6(Datas datas){

        this.setMinSize(1000, 1000);

        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());

        /// BUTTONS


        datas.getNodes().getButtonsObj().getBack().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getBack().relocate(250,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getBack());

        datas.getNodes().getButtonsObj().getOk().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getOk().relocate(700,600);
        this.getChildren().add(datas.getNodes().getButtonsObj().getOk());

        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().getSelectionModel().selectFirst();
        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().setPrefSize(400,50);
        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().relocate(250,600);
        this.getChildren().add(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls());

        if(datas.getActiveuser().get(0).isAdmin()){

            datas.getNodes().getButtonsObj().getAddhall().setPrefSize(150,50);
            datas.getNodes().getButtonsObj().getAddhall().relocate(250,685);
            this.getChildren().add(datas.getNodes().getButtonsObj().getAddhall());

            datas.getNodes().getButtonsObj().getRemovehall().setPrefSize(150,50);
            datas.getNodes().getButtonsObj().getRemovehall().relocate(500,685);
            this.getChildren().add(datas.getNodes().getButtonsObj().getRemovehall());


        }

        datas.getNodes().getButtonsObj().getPlaybutton().relocate(950,105);
        this.getChildren().add(datas.getNodes().getButtonsObj().getPlaybutton());

        datas.getNodes().getButtonsObj().getBackwardbutton().relocate(950,155);
        this.getChildren().add(datas.getNodes().getButtonsObj().getBackwardbutton());

        datas.getNodes().getButtonsObj().getForwardbutton().relocate(950,205);
        this.getChildren().add(datas.getNodes().getButtonsObj().getForwardbutton());

        datas.getNodes().getButtonsObj().getReplaybutton().relocate(950,255);
        this.getChildren().add(datas.getNodes().getButtonsObj().getReplaybutton());

        datas.getNodes().getButtonsObj().getVolumeslide().setRotate(90);
        datas.getNodes().getButtonsObj().getVolumeslide().setPrefWidth(220);
        datas.getNodes().getButtonsObj().getVolumeslide().relocate(865,415);
        this.getChildren().add(datas.getNodes().getButtonsObj().getVolumeslide());

        /// TEXTS

        datas.getNodes().getTextObj().getText9().setFont(new Font(30));
        datas.getNodes().getTextObj().setText9(datas.getNodes().getComboboxObj().getFilms().getValue().getFilmName()+" "+"("+datas.getNodes().getComboboxObj().getFilms().getValue().getFilmduration()+" minutes)");
        datas.getNodes().getTextObj().getText9().relocate(360,47);
        this.getChildren().add(datas.getNodes().getTextObj().getText9());

        /// MEDIA


        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaview().relocate(50,75);
        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaview().setFitWidth(854);
        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaview().setFitHeight(480);

        this.getChildren().add(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getMediaview());

    }
}
