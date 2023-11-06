package calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calculator.fxml"));

        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setMinHeight(445);
        stage.setMinWidth(405);
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image("/icon/calculator.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
