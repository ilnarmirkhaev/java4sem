package fractals;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FractalDisplay extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Визуализация фракталов");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Parent initInterface() {
        int w = 640;
        int h = 640;
        double x0 = -1.5;
        double y0 = 3.5;
        double d = 0.5;
        WritableImage fractalImage = new WritableImage(w, h);
        ImageView fractalView = new ImageView(fractalImage);

        final PixelWriter fractalWriter = fractalImage.getPixelWriter();

        ConstantFractal constantFractal = new ConstantFractal();
        CircleFractal circleFractal = new CircleFractal();
        GradientCircle gradientCircle = new GradientCircle();

        SimplePalette palette = new SimplePalette();
        GrayPalette gray = new GrayPalette();
        BuggedPalette bug = new BuggedPalette();

        for (int _x = 0; _x < w; _x++)
            for (int _y = 0; _y < h; _y++) {
                double x = x0 + d * _x;
                double y = y0 + d * _y;
                double v = gradientCircle.evaluate(x, y);
                int color = bug.colorize(v);
//                System.out.println(color);
                fractalWriter.setArgb(_x, _y, color);

            }

        Pane ui = new Pane();
        ui.getChildren().addAll(fractalView);
        return ui;
    }
}
