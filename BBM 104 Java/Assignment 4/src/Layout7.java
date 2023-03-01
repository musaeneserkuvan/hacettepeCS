import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class Layout7 extends Pane {

    public Layout7(Datas datas){

        this.setMinSize(1000, 1000);

        /// IMAGE HALL
        datas.getHalls().relocate(200,200);
        datas.getHalls().setFitHeight(500);
        datas.getHalls().setFitWidth(600);
        this.getChildren().add(datas.getHalls());

        /// INFO TEXT
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

        datas.getNodes().getTextObj().getText9().setFont(new Font(30));
        datas.getNodes().getTextObj().getText9().relocate(500 - (datas.getNodes().getTextObj().getText9().getLayoutBounds().getWidth()/2),125);
        this.getChildren().add(datas.getNodes().getTextObj().getText9());



        datas.getNodes().getTextObj().getText10().relocate(350,300);
        this.getChildren().add(datas.getNodes().getTextObj().getText10());

        datas.getNodes().getTextObj().getText11().relocate(350,350);
        this.getChildren().add(datas.getNodes().getTextObj().getText11());

        datas.getNodes().getTextObj().getText12().relocate(350,400);
        this.getChildren().add(datas.getNodes().getTextObj().getText12());

        datas.getNodes().getTextObj().getText13().relocate(350,450);
        this.getChildren().add(datas.getNodes().getTextObj().getText13());

        /// TEXTFIELDS

        datas.getNodes().getTextfieldObj().getText6field().clear();
        datas.getNodes().getTextfieldObj().getText6field().relocate(450,400);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText6field());

        datas.getNodes().getTextfieldObj().getText7field().clear();
        datas.getNodes().getTextfieldObj().getText7field().relocate(450,450);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText7field());

        /// COMBOBOX



        datas.getNodes().getComboboxObj().getRow().relocate(450,295);
        datas.getNodes().getComboboxObj().getRow().resize(60,31);
        this.getChildren().add(datas.getNodes().getComboboxObj().getRow());

        datas.getNodes().getComboboxObj().getCol().relocate(450,345);
        datas.getNodes().getComboboxObj().getCol().resize(60,31);
        this.getChildren().add(datas.getNodes().getComboboxObj().getCol());

    }
}
