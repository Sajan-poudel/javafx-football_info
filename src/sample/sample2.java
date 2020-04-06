package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sample2 implements Initializable {

    /*double x=0;
    double y=0;
    @FXML
    void dragged(MouseEvent event) {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();

        stage.setX(event.getSceneX()-x);
        stage.setY(event.getSceneY()-y);
    }
    @FXML
    void pressed(MouseEvent event) {
        x=event.getSceneX();
        y=event.getSceneY();
    }


    @FXML
    void click(MouseEvent event) {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();

        stage.close();
    }*/

    @FXML
    private StackPane rootpane1;//main window

    Stage stage;
    @FXML
    private Button button2;

    @FXML
    public void clicked (MouseEvent event) {
        stage =(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void uefaclicked(MouseEvent event) throws IOException {
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        rootpane1.getChildren().setAll(pane3);
    }

    @FXML
    void championclicked(MouseEvent event) throws IOException {
        StackPane pane4 = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        rootpane1.getChildren().setAll(pane4);
    }

    @FXML
    void adminclicked(MouseEvent event) throws IOException {
        StackPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        rootpane1.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
