import geometric.Square;
import geometric.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTests {
    @Test
    public void givenValidSideShouldReturnNewSquare() {
        Square square = new Square(2);
        assertNotNull(square);
    }
    @Test
    public void givenValidSideShouldReturnArea(){
        assertEquals(4, new Square(2).calculateArea());
        assertEquals(16, new Square(4).calculateArea());
        assertEquals(0.25, new Square(0.5).calculateArea());
    }

    @Test
    public void givenSideIsNegativeNumberShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Square(-1));
    }



    @Test
    public void givenSideIs0ShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Square(0));
    }

    @Test
    public void givenValidSideShouldReturnDiameter(){
        assertEquals(8, new Square(2).calculateDiameter());
        assertEquals(16, new Square(4).calculateDiameter());
        assertEquals(2, new Square(0.5).calculateDiameter());
    }
}
