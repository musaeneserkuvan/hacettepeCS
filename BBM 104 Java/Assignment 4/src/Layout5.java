import javafx.scene.layout.Pane;

import java.util.Objects;

public class Layout5 extends Pane {

    public Layout5(Datas datas){

        this.setMinSize(1000, 1000);

        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());

        /// BUTTONS

        datas.getNodes().getButtonsObj().getBack().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getBack().relocate(200,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getBack());

        datas.getNodes().getButtonsObj().getPromotemember().setPrefSize(250,50);
        datas.getNodes().getButtonsObj().getPromotemember().relocate(325,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getPromotemember());

        datas.getNodes().getButtonsObj().getPromoteadmin().setPrefSize(200,50);
        datas.getNodes().getButtonsObj().getPromoteadmin().relocate(600,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getPromoteadmin());

        /// TEXTS

        /// TEXTFIELDS

        /// COMBOBOX

        datas.getNodes().getTableviewObj().getTableview().getItems().clear();

        for(Users u : datas.getUsersArrayList()){

            if(!Objects.equals(u.getUsername(), "admin")){

                datas.getNodes().getTableviewObj().getTableview().getItems().add(u);
            }
        }

        datas.getNodes().getTableviewObj().getTableview().setPrefSize(600,650);
        datas.getNodes().getTableviewObj().getTableview().relocate(200,100);
        this.getChildren().add(datas.getNodes().getTableviewObj().getTableview());

    }
}
