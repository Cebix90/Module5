package geometric;

public class Hexagon implements GeometricFigure {
    private final double side;

    public Hexagon(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Length and width must be positive number.");
        }

        this.side = side;
    }

    @Override
    public double calculateArea() {
        double area = (3 * Math.pow(side, 2) * Math.sqrt(3)) / 2;

        return (double) Math.round(area * 100) / 100;
    }
}
