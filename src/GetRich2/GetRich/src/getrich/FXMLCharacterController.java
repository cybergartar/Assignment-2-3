/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getrich;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author N
 */
public class FXMLCharacterController implements Initializable {


    @FXML
    private TextField namePlayer1;
    @FXML
    private TextField namePlayer2;
    @FXML
    private TextField namePlayer3;
    @FXML
    private TextField namePlayer4;
    
    private int readyCount = 0;
    @FXML
    private AnchorPane bg;
    @FXML
    private ImageView picPlayer1;
    @FXML
    private ImageView picPlayer2;
    @FXML
    private ImageView picPlayer3;
    @FXML
    private ImageView picPlayer4;
    @FXML
    private ToggleButton readyButton1;
    @FXML
    private ToggleButton readyButton2;
    @FXML
    private ToggleButton readyButton5;
    @FXML
    private ToggleButton readyButton4;
    @FXML
    private ImageView letgo;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        letgo.setVisible(false);
    }    

    @FXML
    private void player1Ready(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
        if (namePlayer1.isDisable()) {
            System.out.println("player1 Not Ready");
            namePlayer1.setDisable(false);
            readyCount-=1;
        } else {
            System.out.println("player1 Ready");
            namePlayer1.setDisable(true);
            readyCount+=1;
        }
        if (readyCount > 1) letgo.setVisible(true);
        else letgo.setVisible(false);
    }

    @FXML
    private void player2Ready(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
        if (namePlayer2.isDisable()) {
            System.out.println("player2 Not Ready");
            namePlayer2.setDisable(false);
            readyCount-=1;
        } else {
            System.out.println("player2 Ready");
            namePlayer2.setDisable(true);
            readyCount+=1;
        }
        if (readyCount > 1) letgo.setVisible(true);
        else letgo.setVisible(false);
    }

    @FXML
    private void player3Ready(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
        if (namePlayer3.isDisable()) {
            System.out.println("player3 Not Ready");
            namePlayer3.setDisable(false);
            readyCount-=1;
        } else {
            System.out.println("player3 Ready");
            namePlayer3.setDisable(true);
            readyCount+=1;
        }
        if (readyCount > 1) letgo.setVisible(true);
        else letgo.setVisible(false);
    }

    @FXML
    private void player4Ready(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
        if (namePlayer4.isDisable()) {
            System.out.println("player4 Not Ready");
            namePlayer4.setDisable(false);
            readyCount-=1;
        } else {
            System.out.println("player4 Ready");
            namePlayer4.setDisable(true);
            readyCount+=1;
        }
        if (readyCount > 1) letgo.setVisible(true);
        else letgo.setVisible(false);
    }

    @FXML
    private void handleLetGoButton(MouseEvent event) {
        System.out.println("let's Start!");
        
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
        AudioClip monopo2 = new AudioClip(this.getClass().getResource("assets/sound/เริ่มเกม.mp3").toExternalForm());
        monopo2.play();
        
        FadeTransition ft = new FadeTransition(Duration.millis(500), bg);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
        ft.setOnFinished((ActionEvent actionevent) -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(FXMLCharacterController.this.getClass().getResource("FXMLGamePlay.fxml"));
            }catch (IOException ex) {
                Logger.getLogger(FXMLCharacterController.class.getName()).log(Level.SEVERE, null, ex);
            }   Scene scene = new Scene(root);
            Stage stage = (Stage) bg.getScene().getWindow();
            stage.setTitle("GetRich");
            stage.setScene(scene);
            stage.show();
        });
    }

    
}
