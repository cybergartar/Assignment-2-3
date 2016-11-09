package GetRich;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TestRotate extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Class<?> clazz = this.getClass();

        Image image = new Image(getClass().getResourceAsStream("assets/images/landmark.png"));

        ImageView imageView = new ImageView(image);

        Button buttonRotate = new Button("Rotate");
        buttonRotate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                double value = imageView.getRotate();
                imageView.setRotate(value + 30);
            }
        });

        Button buttonScale = new Button("Scale X * 2");
        buttonScale.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                imageView.setScaleX(2); ;
            }
        });

        FlowPane root = new FlowPane();
        root.setPadding(new Insets(20));
        root.setHgap(20);

        root.getChildren().addAll(buttonRotate,buttonScale, imageView);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX ImageView (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}