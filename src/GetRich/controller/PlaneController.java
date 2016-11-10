package GetRich.controller;

import GetRich.models.Area;
import GetRich.models.Plane;
import GetRich.models.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PlaneController {
    @FXML Button btnGo, btnCancel;
    @FXML ChoiceBox<String> ownedList = new ChoiceBox<String>();
    Player thisPlayer;
    int selectedIndex;
    Plane thisPlane;
    Stage dialog;

    public void initializer(Stage pDialog, Player player, Plane planeTile, ArrayList<Area> allTile) {
        dialog = pDialog;
        thisPlane = planeTile;
        thisPlayer = player;

        for (Area i : allTile) {
            ownedList.getItems().add(i.getName());
        }

        ownedList.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                selectedIndex = newValue.intValue();
            }
        });

    }

    public void buttonHandler (ActionEvent event) {
        if (event.getSource() == btnGo) {
            thisPlane.trigger(thisPlayer, selectedIndex);
        }
        dialog.close();
    }
}
