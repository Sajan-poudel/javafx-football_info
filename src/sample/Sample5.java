package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import utils.ConnectionsUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Sample5 implements Initializable {
    @FXML
    private TextField team2_1;
    @FXML
    private TextField team1_1;
    @FXML
    private TextField winner1_1;


    @FXML
    private MenuButton selectleague;
    @FXML
    private MenuButton selectday;


    @FXML
    private MenuItem menueuropa;
    @FXML
    private MenuItem menuchampion;
    @FXML
    private MenuItem menuday1;
    @FXML
    private MenuItem menuday2;
    @FXML
    private StackPane rootpane5;
    @FXML
    public StackPane submitstackpane;

    String day;
    String league;
    Connection connection = ConnectionsUtils.connectdb();
    PreparedStatement preparedStatement;
    int resultSet;

    public void Sample5(){
        day = "";
        league = "";
        try {
            connection = ConnectionsUtils.connectdb();
        }catch (Exception e){
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
//        System.out.println("hi");
    }

    @FXML
    void onclicked(MouseEvent event)throws IOException {
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        rootpane5.getChildren().setAll(pane3);

    }
    @FXML
    void onclickunhide(MouseEvent event)throws IOException {
        submitstackpane.setVisible(true);
    }
    @FXML
    void ondeleteclicked(MouseEvent event) throws IOException{
        String team1 = team1_1.getText().toString();
        String team2 = team2_1.getText().toString();
//        String winner = winner1_1.getText().toString();
        String sql = "DELETE  FROM " + day + " WHERE league = ? and (team1 = ? or team1 = ? or team2 = ? or team2 = ?)";
        if (team1.length() > 1 || team2.length() > 1){
            try {
                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, day);
                preparedStatement.setString(1, league);
                preparedStatement.setString(2, team1);
                preparedStatement.setString(3, team2);
                preparedStatement.setString(4, team1);
                preparedStatement.setString(5, team2);
//                preparedStatement.setString(5, winner);
                resultSet = preparedStatement.executeUpdate();
                System.out.println(resultSet);
                if(resultSet != 1){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Something is wrong");
                    alert.setTitle("Failed");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }else{
                    StackPane pane = FXMLLoader.load(getClass().getResource("sample0.fxml"));
                    rootpane5.getChildren().setAll(pane);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("please check the textfield should not be empty");
            alert.setTitle("empty text");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    void onaddclicked(MouseEvent event)  throws IOException{
        String team1 = team1_1.getText().toString();
        String team2 = team2_1.getText().toString();
        String winner = winner1_1.getText().toString();
        String sql = "INSERT INTO " + day + " (league, team1, team2, winner) VALUES "+ "(?, ?, ?, ?)";
//        String sql = "select * FROM admins";
        if (team1.length() > 1 && team2.length() > 1 && winner.length() > 1){
            try {
                System.out.println(connection.isClosed());
                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, day);
                preparedStatement.setString(1, league);
                preparedStatement.setString(2, team1);
                preparedStatement.setString(3, team2);
                preparedStatement.setString(4, winner);
                resultSet = preparedStatement.executeUpdate();
                System.out.println(resultSet);
                if(resultSet != 1){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Something is wrong");
                    alert.setTitle("Failed");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }else{
                    submitstackpane.setVisible(true);
                    StackPane pane3 = FXMLLoader.load(getClass().getResource("sample0.fxml"));
                    rootpane5.getChildren().setAll(pane3);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("please check the textfield should not be empty");
            alert.setTitle("empty text");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Sample5();
    }


    public void setEuropaSelected(ActionEvent actionEvent) {
        league = "europa";
        selectleague.setText("Europa league");
    }

    public void setDay1Selected(ActionEvent actionEvent) {
        day = "day1";
        selectday.setText("DAY 1");
    }

    public void setDay2Selected(ActionEvent actionEvent) {
        day = "day2";
        selectday.setText("DAY 2");
    }

    public void setChampionSelected(ActionEvent actionEvent) {
        league = "champions";
        selectleague.setText("CHampions league");
        System.out.println("champions league is selected");
    }
}
