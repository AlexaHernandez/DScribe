package ca.mcgill.cs.jetuml.geom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    public void test_max_Bottom() {
        assertEquals(Integer.MIN_VALUE, Util.max(Integer.MIN_VALUE));
    }

    @Test
    public void test_max_Top() {
        assertEquals(Integer.MAX_VALUE, Util.max(Integer.MAX_VALUE));
    }

    @Test
    public void test_max_OnlyNegatives() {
        assertEquals(-1, Util.max(-10, -1, -40, -50));
    }

    @Test
    public void test_max_OnlyPositives() {
        assertEquals(200, Util.max(10, 200, 3, 150));
    }

    @Test
    public void test_max_Mix() {
        assertEquals(880, Util.max(10, -2, 450, -35, 260, -540, 880, -53));
    }
}
