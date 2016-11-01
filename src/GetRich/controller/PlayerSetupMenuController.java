package GetRich.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerSetupMenuController {
    @FXML Button btnPlay, btnBack;
    @FXML TextField[] playerName = new TextField[4];
    @FXML Button[] btnPrevAvatar = new Button[4];
    @FXML Button[] btnNextAvatar = new Button[4];

    @FXML
    public void handleButtonAction (ActionEvent event) throws Exception{
        try {
            Stage stage;
            Parent root;

            if(event.getSource() == btnPlay){
                for(int i = 0; i < 4; i++){
//                    Initializer.createPlayer(game);
                }

                stage = (Stage) btnPlay.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../views/Board.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("GetRich");
                stage.show();
            }
            else if(event.getSource() == btnBack){
                stage = (Stage) btnBack.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../views/MainMenu.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("GetRich");
                stage.show();
            }
        } catch (IOException e){

        }
    }
}
