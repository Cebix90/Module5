package geometric;

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public double calculateDiameter(){
        return 4 * super.getLength();
    }
}
