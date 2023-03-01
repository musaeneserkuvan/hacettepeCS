import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Layout2 extends Pane {

    public Layout2(Datas datas){


        this.setMinSize(1000, 1000);

        /// COMBOBOX

        datas.getNodes().getTextObj().getInfo().setText("");
        this.getChildren().add(datas.getNodes().getTextObj().getInfo());

        this.getChildren().add(datas.getNodes().getTextObj().getSystem());

        datas.getNodes().getComboboxObj().getFilms().getSelectionModel().selectFirst();

        datas.getNodes().getComboboxObj().getFilms().setPrefSize(400,50);
        datas.getNodes().getComboboxObj().getFilms().relocate(250,600);
        this.getChildren().add(datas.getNodes().getComboboxObj().getFilms());

        datas.getMovie().relocate(210,25);
        datas.getMovie().setFitHeight(500);
        datas.getMovie().setFitWidth(600);
        this.getChildren().add(datas.getMovie());

        /// BUTTONS


        if( datas.getActiveuser().get(0).isAdmin()){

            datas.getNodes().getButtonsObj().getAddfilm().setPrefSize(100,50);
            datas.getNodes().getButtonsObj().getAddfilm().relocate(250,685);
            this.getChildren().add(datas.getNodes().getButtonsObj().getAddfilm());

            datas.getNodes().getButtonsObj().getRemovefilm().setPrefSize(120,50);
            datas.getNodes().getButtonsObj().getRemovefilm().relocate(383,685);
            this.getChildren().add(datas.getNodes().getButtonsObj().getRemovefilm());

            datas.getNodes().getButtonsObj().getEdituser().setPrefSize(100,50);
            datas.getNodes().getButtonsObj().getEdituser().relocate(550,685);
            this.getChildren().add(datas.getNodes().getButtonsObj().getEdituser());

            datas.getNodes().getTextObj().getText19().setFont(new Font(20));
            datas.getNodes().getTextObj().getText19().relocate(275,558);
            this.getChildren().add(datas.getNodes().getTextObj().getText19());

            if(datas.getActiveuser().get(0).isAdmin() && datas.getActiveuser().get(0).isMember()){
                datas.getNodes().getTextObj().setText3("Welcome "+datas.getActiveuser().get(0).getUsername()+" (Admin - Club Member)!");
            }
            else{
                datas.getNodes().getTextObj().setText3("Welcome "+datas.getActiveuser().get(0).getUsername()+" (Admin)!");
            }

        }
        else{
            datas.getNodes().getTextObj().getText20().setFont(new Font(20));
            datas.getNodes().getTextObj().getText20().relocate(275,558);
            this.getChildren().add(datas.getNodes().getTextObj().getText20());

            if(datas.getActiveuser().get(0).isMember()){
                datas.getNodes().getTextObj().setText3("Welcome "+datas.getActiveuser().get(0).getUsername()+" (Club Member)!");
            }
            else{
                datas.getNodes().getTextObj().setText3("Welcome "+datas.getActiveuser().get(0).getUsername()+"!");
            }
        }

        datas.getNodes().getTextObj().getText3().setFont(new Font(20));
        datas.getNodes().getTextObj().getText3().relocate(275,535);
        this.getChildren().add(datas.getNodes().getTextObj().getText3());

        datas.getNodes().getButtonsObj().getOk().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getOk().relocate(700,600);
        this.getChildren().add(datas.getNodes().getButtonsObj().getOk());

        datas.getNodes().getButtonsObj().getLogout().setPrefSize(100,50);
        datas.getNodes().getButtonsObj().getLogout().relocate(250,770);
        this.getChildren().add(datas.getNodes().getButtonsObj().getLogout());

    }
}
