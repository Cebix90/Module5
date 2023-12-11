package geometric;

public class Rectangle implements GeometricFigure {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive numbers.");
        }

        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
