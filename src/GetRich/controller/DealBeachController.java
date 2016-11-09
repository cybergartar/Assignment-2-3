package GetRich.controller;

import GetRich.models.Land;
import GetRich.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by ultimate on 11/8/16.
 */
public class DealBeachController {
    @FXML Label priceLabel;
    @FXML Button btnBuy, btnCancel;
    Long price;
    Player player;
    Land land;
    Stage dialog;

    public void initializer(Stage dialog, Player player, Land land) {
        this.land = land;
        this.player = player;
        this.dialog = dialog;
        price = land.getBuyPrice();

        GamePlayController.setLabel(priceLabel, "Price: " + GamePlayController.convertPriceToString(price));
    }

    public void buttonHandler (ActionEvent event) {
        if (event.getSource() == btnBuy) {
            System.out.println("LEVEL TAKE: " + land.getLevel());
            land.purchase(player, 4);
        }
        dialog.close();
    }
}
