package GetRich;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage pStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            Parent root = FXMLLoader.load(getClass().getResource("views/StartPage.fxml"));
            primaryStage.setTitle("Monopoly");
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.setTitle("GetRich");
            primaryStage.show();

        } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cannot find files");
                alert.setHeaderText("Oops! There is some problem");
                alert.setContentText("There is an error occurred. Please try again.");
                alert.showAndWait();
            e.printStackTrace();
        }
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
