package javafxexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Hello from JavaFX");

        Button button = initInterface();

        mainStage.setScene(new Scene(button, 640, 480));
        mainStage.show();
    }

    private Button initInterface() {
        Button pressMe = new Button("Нажми меня");
        pressMe.setOnAction(e -> System.out.println("Не нажимайте больше эту кнопку"));
        return pressMe;
    }
}