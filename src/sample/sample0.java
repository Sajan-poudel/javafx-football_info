package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sample0 implements Initializable {

    @FXML
    private StackPane rootpane0;
    @FXML
    public void onokclicked(MouseEvent event)throws IOException {
        StackPane pane = FXMLLoader.load(getClass().getResource("sample5.fxml"));
        rootpane0.getChildren().setAll(pane);


    }
    @FXML
    public void oncancelclicked(MouseEvent event) throws IOException {
        StackPane pane = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        rootpane0.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}