package ca.mcgill.cs.jetuml.geom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void test_equals_Same() {
        assertTrue(LineUtils.TWO_TO_SIX.equals(LineUtils.TWO_TO_SIX));
    }

    @Test
    public void test_equals_Equal() {
        assertTrue(LineUtils.TWO_TO_SIX.equals(new Line(LineUtils.TWO, LineUtils.SIX)));
    }

    @Test
    public void test_equals_NotEqual() {
        assertFalse(LineUtils.TWO_TO_SIX.equals(LineUtils.ONE_TO_TWO));
    }

    @Test
    public void test_equals_NullDim() {
        assertFalse(LineUtils.ONE_TO_TWO.equals((Line) null));
    }

    @Test
    public void test_toString_TwoToSix() {
        assertEquals("[(x=2,y=2), (x=6,y=6)]", LineUtils.TWO_TO_SIX.toString());
    }

    @Test
    public void test_toString_OneToTwo() {
        assertEquals("[(x=1,y=1), (x=2,y=2)]", LineUtils.ONE_TO_TWO.toString());
    }

    @Test
    public void test_hashCode_Same() {
        assertEquals(LineUtils.TWO_TO_SIX.hashCode(), LineUtils.TWO_TO_SIX.hashCode());
    }

    @Test
    public void test_hashCode_Equal() {
        assertEquals(LineUtils.TWO_TO_SIX.hashCode(), new Line(LineUtils.TWO, LineUtils.SIX).hashCode());
    }

    @Test
    public void test_clone_TwoToSix() {
        Line initial = LineUtils.TWO_TO_SIX;
        Line cloned = initial.clone();
        assertNotSame(initial, cloned);
        assertEquals(initial, cloned);
    }

    @Test
    public void test_clone_OneToTwo() {
        Line initial = LineUtils.ONE_TO_TWO;
        Line cloned = initial.clone();
        assertNotSame(initial, cloned);
        assertEquals(initial, cloned);
    }

    @Test
    public void test_spanning_TwoToSix() {
        assertEquals(new Rectangle(2, 2, 4, 4), LineUtils.TWO_TO_SIX.spanning());
    }

    @Test
    public void test_spanning_OneToTwo() {
        assertEquals(new Rectangle(1, 1, 1, 1), LineUtils.ONE_TO_TWO.spanning());
    }
}
