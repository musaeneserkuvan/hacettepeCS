import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Layout1 extends Pane {

    public Layout1(Datas datas){

        this.setMinSize(1000, 1000);

        datas.getNodes().getTextObj().getText16().setText("Welcome to the "+datas.getTitle()+"!");

        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());


        datas.getHctplogo().relocate(300,80);
        datas.getHctplogo().setFitHeight(400);
        datas.getHctplogo().setFitWidth(400);
        this.getChildren().add(datas.getHctplogo());

        /// BUTTONS

        datas.getNodes().getButtonsObj().getLogin().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getLogin().relocate(550,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getLogin());

        datas.getNodes().getButtonsObj().getSignup().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getSignup().relocate(250,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getSignup());

        datas.getNodes().getTextObj().getText16().setFont( new Font(30));
        datas.getNodes().getTextObj().getText16().relocate(155,500);
        this.getChildren().add(datas.getNodes().getTextObj().getText16());

        datas.getNodes().getTextObj().getText17().setFont( new Font(30));
        datas.getNodes().getTextObj().getText17().relocate(150,540);
        this.getChildren().add(datas.getNodes().getTextObj().getText17());

        datas.getNodes().getTextObj().getText18().setFont( new Font(30));
        datas.getNodes().getTextObj().getText18().relocate(130,580);
        this.getChildren().add(datas.getNodes().getTextObj().getText18());

        datas.getNodes().getTextObj().getText1().setFont( new Font(20));
        datas.getNodes().getTextObj().getText1().relocate(260,650);
        this.getChildren().add(datas.getNodes().getTextObj().getText1());

        datas.getNodes().getTextObj().getText2().setFont( new Font(20));
        datas.getNodes().getTextObj().getText2().relocate(260,710);
        this.getChildren().add(datas.getNodes().getTextObj().getText2());

        /// TEXTFIELDS

        datas.getNodes().getTextfieldObj().getText1field().clear();
        datas.getNodes().getTextfieldObj().getText1field().setPrefWidth(300);
        datas.getNodes().getTextfieldObj().getText1field().relocate(370,650);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText1field());

        datas.getNodes().getTextfieldObj().getText2field().clear();
        datas.getNodes().getTextfieldObj().getText2field().setPrefWidth(300);
        datas.getNodes().getTextfieldObj().getText2field().relocate(370,710);
        this.getChildren().add(datas.getNodes().getTextfieldObj().getText2field());

    }
}
