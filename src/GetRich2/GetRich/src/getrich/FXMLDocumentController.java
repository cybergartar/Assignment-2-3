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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author N
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane bg;
    @FXML
    private ImageView play;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void handlePlayButton(MouseEvent event) {
        AudioClip monopo = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo.play();
        
        play.setDisable(true);
        System.out.println("play");
        
        FadeTransition ft = new FadeTransition(Duration.millis(500), bg);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.play();
        ft.setOnFinished((ActionEvent actionevent) -> {
            Parent character_parent = null;
            try {
                character_parent = FXMLLoader.load(FXMLDocumentController.this.getClass().getResource("FXMLCharacter.fxml"));
            }catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }   Scene character_scene = new Scene(character_parent);
            Stage character_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            character_stage.setScene(character_scene);
            character_stage.show();
        });
    }
    
}
