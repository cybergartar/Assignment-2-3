package GetRich.controller;

import GetRich.models.Lucky;
import GetRich.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created by ultimate on 11/9/16.
 */
public class LuckyController {
    @FXML Button btnClose;
    @FXML ImageView cardImage;
    Player thisPlayer;
    int selectedIndex;
    Lucky thisLucky;
    Stage dialog;

    public void initializer(Stage pDialog, Player player, Lucky luckyTile) {
        dialog = pDialog;
        thisLucky = luckyTile;
        thisPlayer = player;
        selectedIndex = (int)(Math.random() * 16) + 1;

        cardImage.setImage(new Image(getClass().getResourceAsStream("../assets/images/" + selectedIndex + ".png")));

    }

    public void buttonHandler (ActionEvent event) {
        if (event.getSource() == btnClose) {
            thisLucky.trigger(thisPlayer, selectedIndex);
        }
        dialog.close();
    }
}
