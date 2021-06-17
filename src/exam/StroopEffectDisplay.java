package exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;

public class StroopEffectDisplay extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Эффект Струпа");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }

    private Parent initInterface() {
        // Добавление панелей и кнопки
        GridPane ui = new GridPane();
        VBox ColorsDisplay = new VBox();
        Button addButton = new Button("Добавить");

        ui.add(ColorsDisplay, 0, 0);
        ui.add(addButton, 1, 0);

        // Выравнивание кнопки
        GridPane.setValignment(addButton, VPos.TOP);
        // Размер кнопки
        addButton.setPrefWidth(180);
        addButton.setPrefHeight(60);
        addButton.setMinWidth(180);
        addButton.setMinHeight(60);

        // Constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        ui.getColumnConstraints().addAll(col1);

        // GridPane стиль
        ui.setStyle("-fx-font-size: 30px;");

        // VBox с цветами
        ColorsDisplay.setAlignment(Pos.CENTER);
        ColorsDisplay.setStyle(
                "-fx-font-weight: bold;"
        );

        ColorsDisplay.getChildren().addAll(
                new Label("Синий"),
                new Label("Желтый"),
                new Label("Фиолетовый"),
                new Rectangle(100, 25),
                new Label("Черный"),
                new Rectangle(100, 25)
        );

        // Получаем все содержимое ColorsDisplay и задаем цвета
        List<Node> colors = ColorsDisplay.getChildren();
        colors.get(0).setStyle("-fx-text-fill: magenta;");
        colors.get(1).setStyle("-fx-text-fill: green;");
        colors.get(2).setStyle("-fx-text-fill: darkorange;");
        colors.get(3).setStyle("-fx-fill: blue; -fx-stroke: black;");
        colors.get(4).setStyle("-fx-text-fill: red;");
        colors.get(5).setStyle("-fx-fill: magenta; -fx-stroke: black");

        return ui;
    }
}
