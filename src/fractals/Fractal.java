package fractals;

public interface Fractal {

    /**
     * Для каждой точки плоскости выдает число от 0 до 1, которое потом можно
     * раскрасить и нарисовать.
     * @param x координата по X для точки
     * @param y координата по Y для точки
     * @return число от 0 до 1, которое потом нужно покрасить с помощью палитры.
     */
    double evaluate(double x, double y);

}
