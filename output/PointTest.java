package ca.mcgill.cs.jetuml.geom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void test_equals_Same() {
        assertTrue(PointUtils.ZERO.equals(PointUtils.ZERO));
    }

    @Test
    public void test_equals_Equal() {
        assertTrue(PointUtils.TWO.equals(new Point(2, 2)));
    }

    @Test
    public void test_equals_NotEqual() {
        assertFalse(PointUtils.ZERO.equals(PointUtils.M_ONE));
    }

    @Test
    public void test_equals_NullDim() {
        assertFalse(PointUtils.TWO.equals((Point) null));
    }

    @Test
    public void test_toString_Zero() {
        assertEquals("(x=0,y=0)", PointUtils.ZERO.toString());
    }

    @Test
    public void test_toString_Two() {
        assertEquals("(x=2,y=2)", PointUtils.TWO.toString());
    }

    @Test
    public void test_hashCode_Same() {
        assertEquals(PointUtils.ZERO.hashCode(), PointUtils.ZERO.hashCode());
    }

    @Test
    public void test_hashCode_Equal() {
        assertEquals(PointUtils.TWO.hashCode(), new Point(2, 2).hashCode());
    }

    @Test
    public void test_clone_Two() {
        Point initial = PointUtils.TWO;
        Point cloned = initial.clone();
        assertNotSame(initial, cloned);
        assertEquals(initial, cloned);
    }

    @Test
    public void test_clone_Zero() {
        Point initial = PointUtils.ZERO;
        Point cloned = initial.clone();
        assertNotSame(initial, cloned);
        assertEquals(initial, cloned);
    }

    @Test
    public void test_distance_ZeroZero() {
        assertEquals(0, PointUtils.ZERO.distance(PointUtils.ZERO), 0);
    }

    @Test
    public void test_distance_ZeroTwo() {
        assertEquals(2.8284, PointUtils.ZERO.distance(PointUtils.TWO), 0.0001);
    }

    @Test
    public void test_distance_TwoMOne() {
        assertEquals(4.2426, PointUtils.TWO.distance(PointUtils.M_ONE), 0.0001);
    }
}
