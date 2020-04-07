package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sample3 implements Initializable {

    public TabPane tabpan;
    //Stage stage;
    @FXML
    private Button button2;

    @FXML
    private StackPane rootpane2;

    @FXML
    public void clicked (MouseEvent event) throws IOException {
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        rootpane2.getChildren().setAll(pane3);
        /*stage =(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
