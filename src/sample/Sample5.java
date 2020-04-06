package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sample5 implements Initializable {

    @FXML
    private StackPane rootpane5;

    @FXML
    void onclicked(MouseEvent event)throws IOException {
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        rootpane5.getChildren().setAll(pane3);

    }
    @FXML
    private StackPane submitstackpane;
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
    void oninsertclicked(MouseEvent event)  throws IOException{
        StackPane pane = FXMLLoader.load(getClass().getResource("sample0.fxml"));
        rootpane5.getChildren().setAll(pane);
    }

    @FXML
    void onmodifyclicked(MouseEvent event)  throws IOException{
        StackPane pane = FXMLLoader.load(getClass().getResource("sample0.fxml"));
        rootpane5.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}
