package ca.mcgill.cs.jetuml.geom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void test_toString_Four() {
        assertEquals("[Direction: x=0.71 y=0.71]", DirectionUtils.FOUR.toString());
    }

    @Test
    public void test_toString_Zero() {
        assertEquals("[Direction: x=0.00 y=0.00]", DirectionUtils.ZERO.toString());
    }

    @Test
    public void test_turn_FourClockwise90() {
        Direction obj = DirectionUtils.FOUR.turn(-90);
        assertEquals(1 / Math.sqrt(2), obj.getX(), 0.0001);
        assertEquals(-1 / Math.sqrt(2), obj.getY(), 0.0001);
    }

    @Test
    public void test_turn_ZeroClockwise40() {
        Direction obj = DirectionUtils.ZERO.turn(-40);
        assertEquals(0, obj.getX(), 0);
        assertEquals(0, obj.getY(), 0);
    }

    @Test
    public void test_turn_FourCounterClockwise90() {
        Direction obj = DirectionUtils.FOUR.turn(90);
        assertEquals(-1 / Math.sqrt(2), obj.getX(), 0.0001);
        assertEquals(1 / Math.sqrt(2), obj.getY(), 0.0001);
    }

    @Test
    public void test_turn_FourClockwise0() {
        Direction obj = DirectionUtils.FOUR.turn(0);
        assertEquals(1 / Math.sqrt(2), obj.getX(), 0.0001);
        assertEquals(1 / Math.sqrt(2), obj.getY(), 0.0001);
    }

    @Test
    public void test_Direction_OneToTwo() {
        Direction obj = new Direction(new Point(1, 2), new Point(2, 4));
        assertEquals(1 / Math.sqrt(5), obj.getX());
        assertEquals(2 / Math.sqrt(5), obj.getY());
    }

    @Test
    public void test_Direction_Four() {
        Direction obj = new Direction(4, 4);
        assertEquals(1 / Math.sqrt(2), obj.getX());
        assertEquals(1 / Math.sqrt(2), obj.getY());
    }

    @Test
    public void test_Direction_Zero() {
        Direction obj = new Direction(0, 0);
        assertEquals(0, obj.getX());
        assertEquals(0, obj.getY());
    }
}
