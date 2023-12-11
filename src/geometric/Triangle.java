package geometric;

public class Triangle implements GeometricFigure {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Length and width must be positive number.");
        }

        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        double area = (base * height / 2.0);

        return (double) Math.round(area * 100) / 100;
    }
}
