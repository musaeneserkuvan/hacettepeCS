import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Layout10 extends Pane {

    public Layout10(Datas datas){

        this.setMinSize(1000, 1000);

        /// hctp logo

        datas.getHctplogo().relocate(300,50);
        datas.getHctplogo().setFitHeight(400);
        datas.getHctplogo().setFitWidth(400);
        this.getChildren().add(datas.getHctplogo());



        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());

        datas.getNodes().getButtonsObj().getSignup().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getSignup().relocate(550,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getSignup());

        datas.getNodes().getButtonsObj().getLogin().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getLogin().relocate(250,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getLogin());

        /// TEXT


        datas.getNodes().getTextObj().getText1().setFont( new Font(20));
        datas.getNodes().getTextObj().getText1().relocate(260,590);
        this.getChildren().add(datas.getNodes().getTextObj().getText1());

        datas.getNodes().getTextObj().getPassword2().setFont( new Font(20));
        datas.getNodes().getTextObj().getPassword2().relocate(260,650);
        this.getChildren().add(datas.getNodes().getTextObj().getPassword2());

        datas.getNodes().getTextObj().getText2().setFont( new Font(20));
        datas.getNodes().getTextObj().getText2().relocate(260,710);
        this.getChildren().add(datas.getNodes().getTextObj().getText2());


        datas.getNodes().getTextObj().getText16().setFont( new Font(30));
        datas.getNodes().getTextObj().getText16().relocate(155,460);
        this.getChildren().add(datas.getNodes().getTextObj().getText16());

        datas.getNodes().getTextObj().getSign1().setFont( new Font(30));
        datas.getNodes().getTextObj().getSign1().relocate(200,500);
        this.getChildren().add(datas.getNodes().getTextObj().getSign1());

        datas.getNodes().getTextObj().getSign2().setFont( new Font(30));
        datas.getNodes().getTextObj().getSign2().relocate(155,540);
        this.getChildren().add(datas.getNodes().getTextObj().getSign2());


        //// text field

        datas.getNodes().getTextfieldObj().getNamefield().clear();
        datas.getNodes().getTextfieldObj().getNamefield().setPrefWidth(300);
        datas.getNodes().getTextfieldObj().getNamefield().relocate(370,590);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getNamefield());

        datas.getNodes().getTextfieldObj().getPassfield1().clear();
        datas.getNodes().getTextfieldObj().getPassfield1().setPrefWidth(300);
        datas.getNodes().getTextfieldObj().getPassfield1().relocate(370,650);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getPassfield1());

        datas.getNodes().getTextfieldObj().getPassfield2().clear();
        datas.getNodes().getTextfieldObj().getPassfield2().setPrefWidth(300);
        datas.getNodes().getTextfieldObj().getPassfield2().relocate(370,710);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getPassfield2());



    }
}
