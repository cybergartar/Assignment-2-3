package GetRich.controller;

import GetRich.Main;
import GetRich.models.Beach;
import GetRich.models.Land;
import GetRich.models.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LandController {
    public static void onPlayerStepped (Stage pStage, Player player, Land land, String landName) {
        if(land.getOwner() != null && land.getOwner() != player) {
            land.payCharge(player);
            if (player.getMoney() >= land.getBuyPrice() && land.isPurchasable()){
                try {
                    Stage dialog = new Stage();
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/TakeOverForm.fxml"));
                    Parent root = loader.load();
                    TakeOverController controller = loader.getController();

                    controller.initializer(dialog, player, land, landName);

                    dialog.initStyle(StageStyle.UNDECORATED);
                    dialog.initModality(Modality.WINDOW_MODAL);
                    dialog.initOwner(pStage);
                    dialog.setScene(new Scene(root, 500, 300));
                    dialog.setTitle("Take over?");
                    dialog.showAndWait();

                    while (dialog.isShowing());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if ((land.getOwner() == null || land.getOwner() == player) && player.getMoney() > land.getBuyPrice() && land.isPurchasable()) {
            if( !((player.getLapPassed() < 1 && land.getLevel() == 2) || (player.getLapPassed() < 2 && land.getLevel() == 3))) {
                if(!(land instanceof Beach)) {
                    try {
                        Stage dialog = new Stage();
                        FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/DealHouseForm.fxml"));
                        Parent root = loader.load();
                        DealHouseController controller = loader.getController();

                        controller.initializer(dialog, player, land, landName, player.getLapPassed());

                        dialog.initStyle(StageStyle.UNDECORATED);
                        dialog.initModality(Modality.WINDOW_MODAL);
                        dialog.initOwner(pStage);
                        dialog.setScene(new Scene(root, 500, 500));
                        dialog.setTitle("Buy property?");
                        dialog.showAndWait();

                        while (dialog.isShowing());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        Stage dialog = new Stage();
                        FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/DealBeachForm.fxml"));
                        Parent root = loader.load();
                        DealBeachController controller = loader.getController();

                        controller.initializer(dialog, player, land);

                        dialog.initStyle(StageStyle.UNDECORATED);
                        dialog.initModality(Modality.WINDOW_MODAL);
                        dialog.initOwner(pStage);
                        dialog.setScene(new Scene(root, 500, 300));
                        dialog.setTitle("Buy beach?");
                        dialog.showAndWait();

                        while (dialog.isShowing());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
