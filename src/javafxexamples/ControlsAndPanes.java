package javafxexamples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControlsAndPanes extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про панельки и элементы управления");

        // сцена создается на основе Parent
        Parent ui = createInterface();
        // высота и ширина, если указаны, используются как preferred size для ui
        primaryStage.setScene(new Scene(ui, 640, 480));
//        primaryStage.setScene(new Scene(ui));

        primaryStage.show();
    }

    private Parent createInterface() {
        GridPane mainGridPane = new GridPane();
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        BorderPane bp = new BorderPane();

        // метод add добавляет один элемент на сетку
        mainGridPane.add(vb1, 0, 0);
        mainGridPane.add(vb2, 1, 1);
        mainGridPane.add(hb, 0, 1);
        mainGridPane.add(bp, 1, 0);
        mainGridPane.setStyle("-fx-font-size: 3em");

        // изменение цвета панелей
        // способ 1. CSS. Не забываем -fx- в начале
        vb1.setStyle("-fx-background-color: red");
        // Background, как и в CSS, может быть очень разным
        vb2.setBackground(new Background(new BackgroundFill( // Fill - цвет
                Color.GREEN, // Color extends Paint
                new CornerRadii(0), // border radius
                null // padding/margin
        )));
        hb.setStyle("-fx-background-color: blue");
        bp.setStyle("-fx-background-color: #800069");

        // add elements
        // vb1
        vb1.getChildren()
                .add(new Button("Первая кнопка"));
        vb1.getChildren().addAll(
                new Button("Вторая кнопка"),
                new Button("?!"),
                new Label("Это метка с текстом")
        );

        // vb2
        vb2.getChildren().addAll(
                new Button("Первая кнопка"),
                new ColorPicker(),
                new Button("?!"),
                new Label("Это метка с текстом")
        );

        // hb
        hb.getChildren().addAll(
                new Button("Кн 1"),
                new Label("short txt"),
                new Button("Кн 2")
        );

        // bp

        // ограничения элементам
        // GridPane
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        mainGridPane.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();

        RowConstraints row2 = new RowConstraints();
        // Ctrl + Shift + Space
        // Ctrl + Space
        // Ctrl + Alt + Space
        row2.setVgrow(Priority.ALWAYS); // растягиваемость по вертикали
        // растягивать всегда
        mainGridPane.getRowConstraints().addAll(row1, row2);

        vb2.setAlignment(Pos.BOTTOM_RIGHT);

        //как задать расположение конкретного элемента. Нужно добавить ограничение,
        //связанное с элементом. Универсальный способ добавлять ограничения на элементы интерфейса
//        VBox.setVgrow(vb2.getChildren().get(2), Priority.ALWAYS);
        VBox.setMargin(vb2.getChildren().get(2), new Insets(10));

        // borderPane
        final Button bottom = new Button("снизу");
        BorderPane.setAlignment(bottom, Pos.CENTER);
        bp.setBottom(bottom);
        bp.setLeft(new Button("слева"));
        bp.setRight(new Button("справа"));
        bp.setTop(new Button("сверху"));
        bp.setCenter(new Button("центр"));

        return mainGridPane;
    }
}
