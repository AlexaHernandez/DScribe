package ca.mcgill.cs.jetuml.geom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class DimensionTest {

    @Test
    public void test_equals_Same() {
        assertTrue(DimensionUtils.ZERO.equals(DimensionUtils.ZERO));
    }

    @Test
    public void test_equals_Equal() {
        assertTrue(DimensionUtils.ZERO.equals(new Dimension(0, 0)));
    }

    @Test
    public void test_equals_NotEqual() {
        assertFalse(DimensionUtils.ZERO.equals(DimensionUtils.FIVE));
    }

    @Test
    public void test_equals_NullDim() {
        assertFalse(DimensionUtils.ZERO.equals((Dimension) null));
    }

    @Test
    public void test_hashCode_Same() {
        assertEquals(DimensionUtils.EIGHT.hashCode(), DimensionUtils.EIGHT.hashCode());
    }

    @Test
    public void test_hashCode_Equal() {
        assertEquals(DimensionUtils.FIVE.hashCode(), new Dimension(5, 5).hashCode());
    }

    @Test
    public void test_include_Grow() {
        assertEquals(DimensionUtils.EIGHT, DimensionUtils.FIVE.include(8, 8));
    }

    @Test
    public void test_include_Zero() {
        assertEquals(DimensionUtils.FIVE, DimensionUtils.FIVE.include(1, 4));
    }
}
