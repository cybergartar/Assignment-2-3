package GetRich;

import GetRich.controller.GamePlayController;
import GetRich.controller.Initializer;
import GetRich.models.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("views/StartPage.fxml"));
//        primaryStage.setTitle("Monopoly");
        ArrayList<Player> players = Initializer.createPlayer("A", "B", "C", "D");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("views/GamePlay.fxml"));
            Parent root = loader.load();
            GamePlayController controller = loader.getController();
            controller.createGamePlay(players);

            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.setTitle("GetRich");
            primaryStage.show();

        } catch (Exception e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Cannot find files");
//                alert.setHeaderText("Oops! There is some problem");
//                alert.setContentText("There is an error occurred. Please try again.");
//                alert.showAndWait();
            e.printStackTrace();
        }
//        primaryStage.setScene(new Scene(root, 1280, 720));
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
