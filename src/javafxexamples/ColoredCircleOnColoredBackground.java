package javafxexamples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColoredCircleOnColoredBackground extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Цветной круг на цветном фоне");

        Parent ui = createInterface();

        primaryStage.setScene(new Scene(ui, 800, 600));
        primaryStage.show();
    }

    private Parent createInterface() {
        // Creating basic interface
        GridPane mainGridPane = new GridPane();
        VBox circleSettings = new VBox();
        Pane circleDisplay = new Pane();

        mainGridPane.add(circleSettings, 0, 0);
        mainGridPane.add(circleDisplay, 1, 0);

        // Adding Constraints to mainGridPane
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(240);
        col1.setMinWidth(240);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);

        mainGridPane.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        mainGridPane.getRowConstraints().add(row1);

        // circleSettings
        // Style
        circleSettings.setStyle("-fx-background-color: lightgrey;" +
                "-fx-padding: 20px;" +
                "-fx-font-size: 20px;");
        circleSettings.setAlignment(Pos.TOP_CENTER);

        // Adding elements
        // Radius slider
        Label radius = new Label("Радиус");
        Slider slider = new Slider(0, 100, Double.MIN_VALUE);
        radius.setGraphic(slider);
        radius.setContentDisplay(ContentDisplay.BOTTOM);

        // Circle color picker
        Label circleColor = new Label("Цвет круга");
        ColorPicker circleColorPicker = new ColorPicker();
        circleColor.setGraphic(circleColorPicker);
        circleColor.setContentDisplay(ContentDisplay.BOTTOM);

        // Background color picker
        Label backgroundColor = new Label("Цвет фона");
        ColorPicker backgroundColorPicker = new ColorPicker();
        backgroundColor.setGraphic(backgroundColorPicker);
        backgroundColor.setContentDisplay(ContentDisplay.BOTTOM);

        circleSettings.getChildren().addAll(radius, circleColor, backgroundColor);

        // circleDisplay
        // Style
        circleDisplay.setBackground(new Background(new BackgroundFill(
                Color.FORESTGREEN,
                new CornerRadii(0),
                Insets.EMPTY
        )));

        // Adding elements
        Circle circle = new Circle();

        circle.setRadius(50);
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setFill(Color.CORAL);

        circleDisplay.getChildren().add(circle);

        // Bindings
        // radius
        circle.radiusProperty().bind(slider.valueProperty());
        // X and Y center position
        circle.centerXProperty().bind(Bindings.divide(circleDisplay.widthProperty(), 2));
        circle.centerYProperty().bind(Bindings.divide(circleDisplay.heightProperty(), 2));
        // circle color
        circle.fillProperty().bind(circleColorPicker.valueProperty());
        // background color
        circleDisplay.backgroundProperty().bind(Bindings.createObjectBinding(() -> {
            BackgroundFill fill = new BackgroundFill(
                    backgroundColorPicker.getValue(),
                    CornerRadii.EMPTY,
                    Insets.EMPTY
            );
            return new Background(fill);
        }, backgroundColorPicker.valueProperty()));
        // max radius
        slider.maxProperty().bind(Bindings.divide(
                Bindings.min(circleDisplay.heightProperty(), circleDisplay.widthProperty()), 2
        ));

        return mainGridPane;
    }
}
