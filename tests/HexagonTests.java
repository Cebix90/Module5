import geometric.Hexagon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HexagonTests {
    @Test
    public void givenValidSideShouldReturnNewHexagon() {
        Hexagon hexagon = new Hexagon(4);
        assertNotNull(hexagon);
    }
    @Test
    public void givenValidSideShouldReturnArea(){
        assertEquals(23.38, new Hexagon(3).calculateArea());
        assertEquals(64.95, new Hexagon(5).calculateArea());
        assertEquals(2.6, new Hexagon(1).calculateArea());
    }

    @Test
    public void givenSideIsNegativeNumberShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Hexagon(-1));
    }

    @Test
    public void givenSideIs0ShouldReturnException(){
        assertThrows(IllegalArgumentException.class, () -> new Hexagon(0));
    }
}
