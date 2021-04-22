package fractals;

import javafx.scene.paint.Color;

public interface Palette {

    /**
     * Определяет цвет для числа в диапозоне от 0 до 1
     * @param v число от 0 до 1
     * @return цвет числа
     */
    int colorize(double v);
}
