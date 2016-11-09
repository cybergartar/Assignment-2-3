package GetRich.controller;

import GetRich.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by ultimate on 11/6/16.
 */
public class SelectCharacterController {
    int readyPerson = 0;
    @FXML ToggleButton btnReadyP1, btnReadyP2, btnReadyP3, btnReadyP4;
    @FXML Button btnGo;
    @FXML TextField nameP1, nameP2, nameP3, nameP4;

    public void handleReadyButton(ActionEvent event){
        toggle((ToggleButton) event.getSource());
    }

    public void handleGoButton () {
        if(readyPerson != 4) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Caution");
            alert.setHeaderText("Oops! There is some problem");
            alert.setContentText("There is an unready player(s). Please wait them");
            alert.showAndWait();
        }
        else if (!filledName()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Caution");
            alert.setHeaderText("Oops! There is some problem");
            alert.setContentText("There is an unnamed player(s). Please fill the name");
            alert.showAndWait();
        }
        else {
            String textNameP1 = nameP1.getText();
            String textNameP2 = nameP2.getText();
            String textNameP3 = nameP3.getText();
            String textNameP4 = nameP4.getText();
            ArrayList<Player> players = Initializer.createPlayer(textNameP1, textNameP2, textNameP3, textNameP4);

            AudioClip sLetsGo = new AudioClip(this.getClass().getResource("../assets/sounds/letsgo.mp3").toExternalForm());
            sLetsGo.play();
            while (sLetsGo.isPlaying());

            try {
                Stage stage = (Stage) btnGo.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/GamePlay.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                GamePlayController controller = loader.getController();
                controller.createGamePlay(players);

                stage.setScene(scene);
                stage.setTitle("GetRich");
                stage.show();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cannot find files");
                alert.setHeaderText("Oops! There is some problem");
                alert.setContentText("There is an error occurred. Please try again.");
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    private void toggle (ToggleButton btn) {
        if (btn.isSelected()) {
            btn.setText("Unready");
            readyPerson ++;
            System.out.println(readyPerson);
        }
        else {
            btn.setText("Ready");
            readyPerson --;
            System.out.println(readyPerson);
        }
    }

    private boolean filledName() {
        if(nameP1.getText().length() == 0)
            return false;
        if(nameP2.getText().length() == 0)
            return false;
        if(nameP3.getText().length() == 0)
            return false;
        if(nameP4.getText().length() == 0)
            return false;

        return true;
    }

}
