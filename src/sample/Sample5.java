package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sample5 implements Initializable {
    String day;
    String league;


    @FXML
    private MenuButton selectleague;
    @FXML
    private MenuButton selectday;


    public void Sample5(){
        day = "";
        league = "";
    }

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
        StackPane pane = FXMLLoader.load(getClass().getResource("sample0.fxml"));
        rootpane5.getChildren().setAll(pane);
    }

    @FXML
    void onaddclicked(MouseEvent event)  throws IOException{
        submitstackpane.setVisible(true);
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample0.fxml"));
        rootpane5.getChildren().setAll(pane3);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void setEuropaSelected(ActionEvent actionEvent) {
        league = "europa";
        selectleague.setText("Europa league");
        System.out.println("europa league is selected");
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
        league = "europa";
        selectleague.setText("CHampions league");
        System.out.println("champions league is selected");
    }
}
