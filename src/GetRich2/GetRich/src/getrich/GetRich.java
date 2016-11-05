/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getrich;

import java.io.File;
import java.net.URL;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayerBuilder;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.print.attribute.standard.Media;

/**
 *
 * @author N
 */
public class GetRich extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        AudioClip monopo = new AudioClip(this.getClass().getResource("assets/sound/monopoly.mp3").toExternalForm());
        monopo.play();

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        FadeTransition ft = new FadeTransition(Duration.millis(3000), root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setAutoReverse(true);
        ft.play();
        
        stage.setTitle("GetRich");
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
