package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import utils.ConnectionsUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class sample4 implements Initializable {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultset= null;
    private ObservableList<ObservableList> data;

    @FXML
    private TabPane tabpan;
    //Stage stage;

    @FXML
    private StackPane rootpane4;

    public void sample4(){
        try {
            connection = ConnectionsUtils.connectdb();
        }catch (Exception e){
            e.printStackTrace();
        }
        String sql = "SHOW TABLES";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                String col = resultset.getString("Tables_in_football_info");
                if(col.compareToIgnoreCase("admins") == 0){
                    System.out.println("lol");
                    continue;
                }
                data = FXCollections.observableArrayList();
                Tab tab = new Tab(col);
                tabpan.getTabs().add(tab);
                TableView tableView = new TableView();
                tab.setContent(tableView);
                String colsquery = "SELECT * FROM " + col + " WHERE league = 'champions'";
                try{
                    PreparedStatement cols = connection.prepareStatement(colsquery);
                    ResultSet columns = cols.executeQuery();

                    for(int i = 0; i<columns.getMetaData().getColumnCount(); i++){
                        final  int j = i;
                        TableColumn tableColumn = new TableColumn(columns.getMetaData().getColumnName(i+1));
                        tableColumn.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                        tableView.getColumns().addAll(tableColumn);
                    }

                    int rowCounter = 0;
                    while(columns.next()){
                        ObservableList row = FXCollections.observableArrayList();
                        for(int i = 1; i<= columns.getMetaData().getColumnCount(); i++){
                            row.add(columns.getString(i));
                        }
                        System.out.println("Row [" + rowCounter + "] added " + row);
                        data.add(row);
                        rowCounter++;
                    }
                    tableView.getItems().addAll(data);
                    data = null;

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void clicked(MouseEvent event)throws IOException {
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        rootpane4.getChildren().setAll(pane3);
        /*stage =(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sample4();
    }
}
