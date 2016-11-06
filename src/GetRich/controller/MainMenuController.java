package GetRich.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML Button btnStart, btnExit;

    @FXML
    public void handleButtonAction(ActionEvent event) throws Exception{
        try {
            Stage stage;
            Parent root;

            if(event.getSource() == btnStart){
                stage = (Stage) btnStart.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../views/SelectCharacter.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("GetRich");
                stage.show();

            }
            else if(event.getSource() == btnExit)
                Platform.exit();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cannot find files");
            alert.setHeaderText("Oops! There is some problem");
            alert.setContentText("There is an error occurred. Please try again.");
            alert.showAndWait();

            Platform.exit();
        }

    }
}
