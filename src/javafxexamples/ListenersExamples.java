package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListenersExamples extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 512, 512));

        primaryStage.show();
    }

    private Parent createInterface() {
        // создаем кнопку со стилем
        Button button = new Button("Кнопка");
        button.setStyle("-fx-background-color: #ee3d3d");

        // создаем метку и прикрепляем кнопку снизу метки
        Label label = new Label("НА КНОПКУ НЕ НАЖИМАТЬ");
        label.setGraphic(button);
        label.setContentDisplay(ContentDisplay.BOTTOM);
        label.setStyle("-fx-font-size: 28px");

        // HBox, в котором лежит метка, а потом будет появляться gif
        HBox hb = new HBox(label);
        hb.setAlignment(Pos.CENTER);

        // фразы для метки
        String[] phrases = new String[] {"Больше не нажимай на эту кнопку!",
                "Будут последствия!", "Предупреждаю в последний раз!", "НУ ВСЁ!!!"};

        // поведение кнопки при нажатии
        // в конце удаляет содержимое HBox и добавляет гифку
        button.setOnAction(new EventHandler<>() {
            int i = 0;

            @Override
            public void handle(ActionEvent event) {
                if (i == phrases.length) {
                    hb.getChildren().clear();
                    hb.getChildren().add(
                            new ImageView(new Image("file:images/explosion.gif", 512, 512, false, false))
                    );
                }
                else {
                    label.setText(phrases[i++]);
                }
            }
        });

        // возвращаем HBox
        return hb;
    }
}