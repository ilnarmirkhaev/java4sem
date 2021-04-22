package fractals;

public class CircleFractal implements Fractal {
    @Override
    public double evaluate(double x, double y) {
        double rSqr = (x - 100) * (x - 100) + (y - 100) * (y - 100);
        if (rSqr > 6400)
            return 1;
        else
            return 0;
    }
}
