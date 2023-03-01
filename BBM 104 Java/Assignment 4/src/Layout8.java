import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Layout8 extends Pane {

    public Layout8(Datas datas){

        this.setMinSize(1000, 1000);

        datas.getHalls().relocate(200,200);
        datas.getHalls().setFitHeight(500);
        datas.getHalls().setFitWidth(600);
        this.getChildren().add(datas.getHalls());

        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());

        /// BUTTONS

        datas.getNodes().getButtonsObj().getBack().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getBack().relocate(200,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getBack());

        datas.getNodes().getButtonsObj().getOk().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getOk().relocate(700,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getOk());

        /// TEXTS

        datas.getNodes().getTextObj().getText14().setText("Select the hall that you desire to remove from "+datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getFilmName()+" and then click OK.");
        datas.getNodes().getTextObj().getText14().setFont(new Font(20));
        datas.getNodes().getTextObj().getText14().relocate(500 - (datas.getNodes().getTextObj().getText14().getLayoutBounds().getWidth()/2),125);
        this.getChildren().add(datas.getNodes().getTextObj().getText14());


        /// COMBOBOX



        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().relocate(350,350);
        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls().setPrefSize(300,50);
        this.getChildren().add(datas.getNodes().getComboboxObj().getFilms().getSelectionModel().getSelectedItem().getHalls());

    }
}
