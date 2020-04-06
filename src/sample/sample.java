package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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

public class sample implements Initializable {

    @FXML
    private PasswordField textpassword;

    @FXML
    private TextField textusername;

    @FXML
    private Button button2;

    @FXML
    private StackPane rootpane1;

    Connection connection = ConnectionsUtils.connectdb();
    PreparedStatement preparedStatement = null;
    ResultSet resultset = null;

    public void Sample() {
        try {
            connection = ConnectionsUtils.connectdb();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Stage stage;
    @FXML
    void onclicked (MouseEvent event)throws IOException {
        StackPane pane3 = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        rootpane1.getChildren().setAll(pane3);
        /*stage =(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();*/
    }
    @FXML
    void onloggedin(MouseEvent event)throws IOException {
        String username = textusername.getText().toString();
        String password = textpassword.getText().toString();
        String sql = "SELECT * FROM admins WHERE user_name = ? and password = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultset = preparedStatement.executeQuery();
            if(!resultset.next()){
                infoBox("Enter correct username and password", "Failed", null);
            }else{
                infoBox("Successfully loged in!!", "Success", null);
                StackPane pane = FXMLLoader.load(getClass().getResource("sample5.fxml"));
                rootpane1.getChildren().setAll(pane);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
