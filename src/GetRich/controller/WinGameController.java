package GetRich.controller;

import GetRich.Main;
import GetRich.models.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ultimate on 11/9/16.
 */
public class WinGameController {
    @FXML Button btnExit;
    @FXML static Label nameR1Label, nameR2Label, nameR3Label, nameR4Label;

    public static void endGame (ArrayList<Player> ranks) {
        System.out.printf(ranks.size() + "");

        nameR1Label.setText(ranks.get(0).getName());
        nameR2Label.setText(ranks.get(1).getName());
        nameR3Label.setText(ranks.get(2).getName());
        nameR4Label.setText(ranks.get(3).getName());

        try {
            Stage dialog = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/WinGame.fxml"));
            Parent root = loader.load();

            dialog.initStyle(StageStyle.UNDECORATED);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setScene(new Scene(root, 1280, 720));
            dialog.setTitle("WIN");
            dialog.showAndWait();

            while (dialog.isShowing());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void buttonHandler (ActionEvent event) {
        Platform.exit();
    }

}
