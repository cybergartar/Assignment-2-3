/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getrich;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author N
 */
public class FXMLGamePlayController implements Initializable {

    @FXML
    private ImageView picPlayer1;
    @FXML
    private Label rankPlayer1;
    @FXML
    private Label moneyPlayer1;
    @FXML
    private Label assetPlayer1;
    @FXML
    private Label timeGame;
    @FXML
    private Label roundGame;
    @FXML
    private Label rankPlayer2;
    @FXML
    private ImageView picPlayer2;
    @FXML
    private Label moneyPlayer2;
    @FXML
    private Label assetPlayer2;
    @FXML
    private Button restartButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView picPlayer3;
    @FXML
    private Label rankPlayer3;
    @FXML
    private Label moneyPlayer3;
    @FXML
    private Label assetPlayer3;
    @FXML
    private Button toss;
    @FXML
    private Label rankPlayer4;
    @FXML
    private ImageView picPlayer4;
    @FXML
    private Label moneyPlayer4;
    @FXML
    private Label assetPlayer4;
    @FXML
    private Pane map17;
    @FXML
    private Label nameMap17;
    @FXML
    private Label priceMap17;
    @FXML
    private Pane map18;
    @FXML
    private Label nameMap18;
    @FXML
    private Label priceMap18;
    @FXML
    private Pane map19;
    @FXML
    private Label nameMap19;
    @FXML
    private Label priceMap19;
    @FXML
    private Pane map20;
    @FXML
    private Label nameMap20;
    @FXML
    private Label priceMap20;
    @FXML
    private Pane map21;
    @FXML
    private Label nameMap21;
    @FXML
    private Label priceMap21;
    @FXML
    private Pane map22;
    @FXML
    private Label nameMap22;
    @FXML
    private Label priceMap22;
    @FXML
    private Pane map23;
    @FXML
    private Label nameMap23;
    @FXML
    private Label priceMap23;
    @FXML
    private Pane map24;
    @FXML
    private Label nameMap24;
    @FXML
    private Label priceMap24;
    @FXML
    private Pane map25;
    @FXML
    private Label nameMap25;
    @FXML
    private Label priceMap25;
    @FXML
    private Pane map26;
    @FXML
    private Label nameMap26;
    @FXML
    private Label priceMap26;
    @FXML
    private Pane map27;
    @FXML
    private Label nameMap27;
    @FXML
    private Label priceMap27;
    @FXML
    private Pane map28;
    @FXML
    private Label nameMap28;
    @FXML
    private Label priceMap28;
    @FXML
    private Pane map29;
    @FXML
    private Label nameMap29;
    @FXML
    private Label priceMap29;
    @FXML
    private Pane map30;
    @FXML
    private Label nameMap30;
    @FXML
    private Label priceMap30;
    @FXML
    private Pane map31;
    @FXML
    private Label nameMap31;
    @FXML
    private Label priceMap31;
    @FXML
    private Pane map32;
    @FXML
    private Label nameMap32;
    @FXML
    private Label priceMap32;
    @FXML
    private Pane map1;
    @FXML
    private Label nameMap1;
    @FXML
    private Label priceMap1;
    @FXML
    private Pane map2;
    @FXML
    private Label nameMap2;
    @FXML
    private Label priceMap2;
    @FXML
    private Pane map3;
    @FXML
    private Label nameMap3;
    @FXML
    private Label priceMap3;
    @FXML
    private Pane map4;
    @FXML
    private Label nameMap4;
    @FXML
    private Label priceMap4;
    @FXML
    private Pane map5;
    @FXML
    private Label nameMap5;
    @FXML
    private Label priceMap5;
    @FXML
    private Pane map6;
    @FXML
    private Label nameMap6;
    @FXML
    private Label priceMap6;
    @FXML
    private Pane map7;
    @FXML
    private Label nameMap7;
    @FXML
    private Label priceMap7;
    @FXML
    private Pane map8;
    @FXML
    private Label nameMap8;
    @FXML
    private Label priceMap8;
    @FXML
    private Pane map9;
    @FXML
    private Label nameMap9;
    @FXML
    private Label priceMap9;
    @FXML
    private Pane map10;
    @FXML
    private Label nameMap10;
    @FXML
    private Label priceMap10;
    @FXML
    private Pane map11;
    @FXML
    private Label nameMap11;
    @FXML
    private Label priceMap11;
    @FXML
    private Pane map12;
    @FXML
    private Label nameMap12;
    @FXML
    private Label priceMap12;
    @FXML
    private Pane map13;
    @FXML
    private Label nameMap13;
    @FXML
    private Label priceMap13;
    @FXML
    private Pane map14;
    @FXML
    private Label nameMap14;
    @FXML
    private Label priceMap14;
    @FXML
    private Pane map15;
    @FXML
    private Label nameMap15;
    @FXML
    private Label priceMap15;
    @FXML
    private Pane map16;
    @FXML
    private Label nameMap16;
    @FXML
    private Label priceMap16;
    @FXML
    private ImageView dice2;
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView cardOpen;
    @FXML
    private ImageView map8House1;
    @FXML
    private ImageView map8House2;
    @FXML
    private ImageView map8House3;
    @FXML
    private ImageView map10House1;
    @FXML
    private ImageView map10House2;
    @FXML
    private ImageView map10House3;
    @FXML
    private ImageView map11House1;
    @FXML
    private ImageView map11House3;
    @FXML
    private ImageView map11House2;
    @FXML
    private ImageView map12House1;
    @FXML
    private ImageView map12House2;
    @FXML
    private ImageView map12House3;
    @FXML
    private ImageView map13House1;
    @FXML
    private ImageView map13House2;
    @FXML
    private ImageView map13House3;
    @FXML
    private ImageView map14House1;
    @FXML
    private ImageView map14House2;
    @FXML
    private ImageView map14House3;
    @FXML
    private ImageView map15House1;
    @FXML
    private ImageView map15House2;
    @FXML
    private ImageView map15House3;
    @FXML
    private ImageView map16House1;
    @FXML
    private ImageView map16House2;
    @FXML
    private ImageView map16House3;
    @FXML
    private ImageView map18House1;
    @FXML
    private ImageView map18House2;
    @FXML
    private ImageView map18House3;
    @FXML
    private ImageView map19House1;
    @FXML
    private ImageView map19House2;
    @FXML
    private ImageView map19House3;
    @FXML
    private ImageView map20House1;
    @FXML
    private ImageView map20House2;
    @FXML
    private ImageView map20House3;
    @FXML
    private ImageView map21House1;
    @FXML
    private ImageView map21House2;
    @FXML
    private ImageView map21House3;
    @FXML
    private ImageView map22House1;
    @FXML
    private ImageView map22House2;
    @FXML
    private ImageView map22House3;
    @FXML
    private ImageView map23House1;
    @FXML
    private ImageView map23House2;
    @FXML
    private ImageView map23House3;
    @FXML
    private ImageView map24House1;
    @FXML
    private ImageView map24House2;
    @FXML
    private ImageView map24House3;
    @FXML
    private ImageView map26House1;
    @FXML
    private ImageView map26House2;
    @FXML
    private ImageView map26House3;
    @FXML
    private ImageView map27House1;
    @FXML
    private ImageView map27House2;
    @FXML
    private ImageView map27House3;
    @FXML
    private ImageView map28House1;
    @FXML
    private ImageView map28House2;
    @FXML
    private ImageView map28House3;
    @FXML
    private ImageView map29House1;
    @FXML
    private ImageView map29House2;
    @FXML
    private ImageView map29House3;
    @FXML
    private ImageView map30House1;
    @FXML
    private ImageView map30House2;
    @FXML
    private ImageView map30House3;
    @FXML
    private ImageView map31House1;
    @FXML
    private ImageView map31House2;
    @FXML
    private ImageView map31House3;
    @FXML
    private ImageView map2House1;
    @FXML
    private ImageView map2House2;
    @FXML
    private ImageView map2House3;
    @FXML
    private ImageView map32House1;
    @FXML
    private ImageView map32House2;
    @FXML
    private ImageView map32House3;
    @FXML
    private ImageView map3House1;
    @FXML
    private ImageView map3House2;
    @FXML
    private ImageView map3House3;
    @FXML
    private ImageView map4House1;
    @FXML
    private ImageView map4House2;
    @FXML
    private ImageView map4House3;
    @FXML
    private ImageView map5House1;
    @FXML
    private ImageView map5House2;
    @FXML
    private ImageView map5House3;
    @FXML
    private ImageView map6House1;
    @FXML
    private ImageView map6House2;
    @FXML
    private ImageView map6House3;
    @FXML
    private ImageView map7House1;
    @FXML
    private ImageView map7House2;
    @FXML
    private ImageView map7House3;
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player4;
    @FXML
    private ImageView player3;
    @FXML
    private ImageView player2;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AudioClip monopo = new AudioClip(this.getClass().getResource("assets/sound/Monopoly_Main_Theme_full.mp3").toExternalForm());
        monopo.play(5.0);
        
    }    

    @FXML
    private void handleRestartButton(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
    }

    @FXML
    private void handleStopButton(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
    }

    @FXML
    private void tossDice(ActionEvent event) {
        AudioClip monopo1 = new AudioClip(this.getClass().getResource("assets/sound/click.mp3").toExternalForm());
        monopo1.play();
    }

    
}
