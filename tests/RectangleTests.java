import geometric.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {
    @Test
    public void givenValidLengthAndWidthShouldReturnNewRectangle() {
        Rectangle rectangle = new Rectangle(4, 6);
        assertNotNull(rectangle);
    }
    @Test
    public void givenValidLengthAndWidthShouldReturnArea(){
        assertEquals(20, new Rectangle(4,5).calculateArea());
        assertEquals(1, new Rectangle(1,1).calculateArea());
        assertEquals(0.25, new Rectangle(0.5,0.5).calculateArea());
    }

    @Test
    public void givenLengthOrWidthIsNegativeNumberShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(8, -3));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-2, -2));
    }

    @Test
    public void givenLengthOrWidthIs0ShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(8, 0));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 0));
    }
}
