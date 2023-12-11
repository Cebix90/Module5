import geometric.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTests {
    @Test
    public void givenValidBaseAndHeightShouldReturnNewTriangle() {
        Triangle triangle = new Triangle(4, 6);
        assertNotNull(triangle);
    }
    @Test
    public void givenValidBaseAndHeightShouldReturnArea(){
        assertEquals(10, new Triangle(4,5).calculateArea());
        assertEquals(0.5, new Triangle(1,1).calculateArea());
        assertEquals(50, new Triangle(10,10).calculateArea());
    }

    @Test
    public void givenBaseOrHeightIsNegativeNumberShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(8, -3));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-2, -2));
    }

    @Test
    public void givenBaseOrHeightIs0ShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(8, 0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0));
    }
}