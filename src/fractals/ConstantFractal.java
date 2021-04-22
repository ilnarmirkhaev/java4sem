package fractals;

public class ConstantFractal implements Fractal{
    @Override
    public double evaluate(double x, double y) {
        return 0.5;
    }
}
