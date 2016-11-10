package GetRich.controller;

import GetRich.models.Festival;
import GetRich.models.Land;
import GetRich.models.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class FestivalController {
    @FXML Button btnFest, btnCancel;
    @FXML ChoiceBox<String> ownedList = new ChoiceBox<String>();
    Player thisPlayer;
    int selectedIndex;
    Festival thisFest;
    Stage thisDialog;

    public void initializer(Stage dialog, Player player, Festival festTile) {
        thisFest = festTile;
        thisDialog = dialog;
        thisPlayer = player;

        for (Land i : player.getLand()) {
            ownedList.getItems().add(i.getName() + "(Charge: " + i.getRealCharge() + ")");
        }

        ownedList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                selectedIndex = newValue.intValue();
            }
        });

    }

    public void buttonHandler (ActionEvent event) {
        if (event.getSource() == btnFest) {
            thisFest.trigger(thisPlayer, selectedIndex);
        }
        thisDialog.close();

    }
}
