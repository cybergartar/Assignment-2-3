/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getrich;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

/**
 * FXML Controller class
 *
 * @author N
 */
public class FXMLWinGameController implements Initializable {

    @FXML
    private ImageView picRank2;
    @FXML
    private Label numberRank2;
    @FXML
    private Label nameRank2;
    @FXML
    private ImageView picRank3;
    @FXML
    private Label numberRank3;
    @FXML
    private Label nameRank3;
    @FXML
    private ImageView picRank4;
    @FXML
    private Label numberRank4;
    @FXML
    private Label nameRank4;
    @FXML
    private Button playAgainButton;
    @FXML
    private Button exitButton;
    @FXML
    private ImageView picRank1;
    @FXML
    private Label nameRank1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePlayAgainButton(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
    }

    @FXML
    private void handleExitButton(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
        System.exit(1);
    }
       
}
