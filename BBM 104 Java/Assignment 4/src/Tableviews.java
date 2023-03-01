
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Objects;



public class Tableviews {

    private final TableView<Users> tableview;

    public Tableviews(Datas datas){


        this.tableview = new TableView<>();

        TableColumn<Users,String> firstcol = new TableColumn<>("Username");
        TableColumn<Users,Boolean> secondcol = new TableColumn<>("Club Member");
        TableColumn<Users,Boolean> thircol = new TableColumn<>("Admin");

        firstcol.setMinWidth(200);
        secondcol.setMinWidth(200);
        thircol.setMinWidth(200);

        firstcol.setCellValueFactory(new PropertyValueFactory<>("username"));
        secondcol.setCellValueFactory(new PropertyValueFactory<>("member"));
        thircol.setCellValueFactory(new PropertyValueFactory<>("admin"));

        this.tableview.getColumns().add(firstcol);
        this.tableview.getColumns().add(secondcol);
        this.tableview.getColumns().add(thircol);




        for(Users u : datas.getUsersArrayList()){

            if(!Objects.equals(u.getUsername(), "admin")){

                this.tableview.getItems().add(u);
            }
        }


    }

    public TableView<Users> getTableview() {
        return tableview;
    }
}
