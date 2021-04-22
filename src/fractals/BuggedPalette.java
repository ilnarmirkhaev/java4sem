package fractals;

public class BuggedPalette implements Palette {

    @Override
    public int colorize(double v) {
        double a = (1 - v) * 255;
        return (int) -((a * 256 * 256) + (a * 256) + a);
    }
}
