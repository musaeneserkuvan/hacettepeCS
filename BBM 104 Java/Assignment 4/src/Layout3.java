import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


//// ADD FILM SCREEN

public class Layout3 extends Pane {

    public Layout3(Datas datas){


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

        datas.getNodes().getTextObj().getText5().setFont( new Font(20));
        datas.getNodes().getTextObj().getText5().relocate(200,535);
        this.getChildren().add(datas.getNodes().getTextObj().getText5());

        datas.getNodes().getTextObj().getText6().relocate(300,590);
        this.getChildren().add(datas.getNodes().getTextObj().getText6());

        datas.getNodes().getTextObj().getText7().relocate(300,640);
        this.getChildren().add(datas.getNodes().getTextObj().getText7());

        datas.getNodes().getTextObj().getText8().relocate(300,690);
        this.getChildren().add(datas.getNodes().getTextObj().getText8());

        /// TEXTFIELDS

        datas.getNodes().getTextfieldObj().getText3field().clear();
        datas.getNodes().getTextfieldObj().getText3field().relocate(400,585);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText3field());

        datas.getNodes().getTextfieldObj().getText4field().clear();
        datas.getNodes().getTextfieldObj().getText4field().relocate(400,635);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText4field());

        datas.getNodes().getTextfieldObj().getText5field().clear();
        datas.getNodes().getTextfieldObj().getText5field().relocate(400,685);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText5field());


    }
}
