package fractals;

import javafx.scene.paint.Color;

public class SimplePalette implements Palette{
    @Override
    public int colorize(double v) {
        if (v > 0.5)
            return 0xFFFF0000;
        else
            return 0xFF0000FF;
    }
}
