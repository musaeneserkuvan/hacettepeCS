import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Layout4 extends Pane {

    public Layout4(Datas datas){

        this.setMinSize(1000, 1000);



        datas.getMovie().relocate(210,25);
        datas.getMovie().setFitHeight(500);
        datas.getMovie().setFitWidth(600);
        this.getChildren().add(datas.getMovie());

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

        /// TEXTS

        datas.getNodes().getTextObj().getText4().setFont(new Font(20));
        datas.getNodes().getTextObj().getText4().relocate(230,550);
        this.getChildren().add(datas.getNodes().getTextObj().getText4());

        /// COMBOBOX

        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().selectFirst();

        datas.getNodes().getComboboxObj().getFilms().relocate(250,600);
        datas.getNodes().getComboboxObj().getFilms().setPrefSize(400,50);
        this.getChildren().add(datas.getNodes().getComboboxObj().getFilms());

    }
}
