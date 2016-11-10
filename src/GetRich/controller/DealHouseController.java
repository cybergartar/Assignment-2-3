package GetRich.controller;

import GetRich.models.Land;
import GetRich.models.Player;
import GetRich.models.Variable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static GetRich.controller.GamePlayController.convertPriceToString;

public class DealHouseController {
    @FXML Label landNameLabel, sumPriceLabel, priceLandLabel, priceL1Label, priceL2Label, priceL3Label, priceLMLabel, moneyLeftLabel;
    @FXML Button btnBuy, btnCancel;
    @FXML RadioButton radioLand, radioL1, radioL2, radioL3, radioLM;
    Player player;
    Land land;
    Stage dialog;
    int lap;
    ToggleGroup radioGroup = new ToggleGroup();

    public void initializer(Stage dialog, Player player, Land land, String landName, int lap) {
        this.land = land;
        this.player = player;
        this.dialog = dialog;
        this.lap = lap;

        GamePlayController.setLabel(landNameLabel, landName);
        int landIndex = land.getIndex();

        GamePlayController.setLabel(priceLandLabel, convertPriceToString(Variable.calculatedLandPrice(landIndex, 0)));
        GamePlayController.setLabel(priceL1Label, convertPriceToString(Variable.calculatedLandPrice(landIndex, 1)));
        GamePlayController.setLabel(priceL2Label, convertPriceToString(Variable.calculatedLandPrice(landIndex, 2)));
        GamePlayController.setLabel(priceL3Label, convertPriceToString(Variable.calculatedLandPrice(landIndex, 3)));
        GamePlayController.setLabel(priceLMLabel, convertPriceToString(Variable.calculatedLandPrice(landIndex, 4)));

        if (land.getLevel() >= 0) {
            radioLand.setVisible(false);
            priceLandLabel.setVisible(false);
        }
        else {
            radioLand.setToggleGroup(radioGroup);
            radioLand.setUserData(0);
        }

        if (land.getLevel() >= 1) {
            radioL1.setVisible(false);
            priceL1Label.setVisible(false);
        }
        else {
            radioL1.setToggleGroup(radioGroup);
            radioL1.setUserData(1);
        }

        if (land.getLevel() >= 2) {
            radioL2.setVisible(false);
            priceL2Label.setVisible(false);
        }
        else {
            radioL2.setToggleGroup(radioGroup);
            radioL2.setUserData(2);
        }

        if (lap < 1 || land.getLevel() >= 3) {
            radioL3.setVisible(false);
            priceL3Label.setVisible(false);
        }
        else {
            radioL3.setToggleGroup(radioGroup);
            radioL3.setUserData(3);
        }

        if (lap < 2 || land.getLevel() < 3) {
            radioLM.setVisible(false);
            priceLMLabel.setVisible(false);
        } else {
            radioLM.setToggleGroup(radioGroup);
            radioLM.setUserData(4);
        }

        GamePlayController.setLabel(sumPriceLabel, "Total cost: 0");
        GamePlayController.setLabel(moneyLeftLabel, "Money left: " + convertPriceToString(player.getMoney()));

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (radioGroup.getSelectedToggle() != null) {
                    int level = (int) radioGroup.getSelectedToggle().getUserData();
                    Long sum = 0L;
                    for (int current = land.getLevel(); current < level; current++)
                        sum += Variable.calculatedLandPrice(landIndex, current+1);
                    GamePlayController.setLabel(sumPriceLabel, "Total Cost: " + convertPriceToString(sum));
                    GamePlayController.setLabel(moneyLeftLabel, "Money left: " + convertPriceToString(player.getMoney() - sum));
                }
            }
        });
    }

    public void handleButton (ActionEvent event) {
        if (event.getSource() == btnBuy) {
            if (radioGroup.getSelectedToggle() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You haven't select anything!", ButtonType.CLOSE);
                alert.showAndWait();
            }
            else {
                int level = ((int) radioGroup.getSelectedToggle().getUserData());
                land.purchase(player, level);
                dialog.close();
            }
        }
        else {
            dialog.close();
        }
    }
}
