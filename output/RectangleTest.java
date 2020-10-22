package ca.mcgill.cs.jetuml.geom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void test_add_RectOutside() {
        assertEquals(new Rectangle(0, 0, 80, 60), RectangleUtils.RECT_1.add(new Rectangle(70, 50, 10, 10)));
    }

    @Test
    public void test_add_RectSame() {
        assertEquals(new Rectangle(0, 0, 60, 40), RectangleUtils.RECT_1.add(RectangleUtils.RECT_1));
    }

    @Test
    public void test_add_RectOverlap() {
        assertEquals(new Rectangle(100, 20, 10, 10), RectangleUtils.RECT_2.add(new Rectangle(100, 20, 10, 10)));
    }

    @Test
    public void test_add_PointGreaterX() {
        assertEquals(new Rectangle(0, 0, 70, 40), RectangleUtils.RECT_1.add(new Point(70, 10)));
    }

    @Test
    public void test_add_PointGreaterY() {
        assertEquals(new Rectangle(0, 0, 60, 45), RectangleUtils.RECT_1.add(new Point(0, 45)));
    }

    @Test
    public void test_add_PointGreaterXAndY() {
        assertEquals(new Rectangle(100, 20, 10, 10), RectangleUtils.RECT_2.add(new Point(110, 30)));
    }

    @Test
    public void test_add_PointInside() {
        assertEquals(new Rectangle(0, 0, 60, 40), RectangleUtils.RECT_1.add(new Point(10, 10)));
    }

    @Test
    public void test_equals_Same() {
        assertTrue(RectangleUtils.RECT_1.equals(RectangleUtils.RECT_1));
    }

    @Test
    public void test_equals_Equal() {
        assertTrue(RectangleUtils.RECT_2.equals(new Rectangle(100,20,1,1)));
    }

    @Test
    public void test_equals_NotEqual() {
        assertFalse(RectangleUtils.RECT_1.equals(RectangleUtils.RECT_2));
    }

    @Test
    public void test_equals_NullDim() {
        assertFalse(RectangleUtils.RECT_1.equals((Rectangle) null));
    }

    @Test
    public void test_toString_Rect1() {
        assertEquals("[x=0, y=0, w=60, h=40]", RectangleUtils.RECT_1.toString());
    }

    @Test
    public void test_toString_Rect2() {
        assertEquals("[x=100, y=20, w=1, h=1]", RectangleUtils.RECT_2.toString());
    }

    @Test
    public void test_hashCode_Same() {
        assertEquals(RectangleUtils.RECT_1.hashCode(), RectangleUtils.RECT_1.hashCode());
    }

    @Test
    public void test_hashCode_Equal() {
        assertEquals(RectangleUtils.RECT_2.hashCode(), new Rectangle(100, 20, 1, 1).hashCode());
    }

    @Test
    public void test_contains_RectInside() {
        assertTrue(RectangleUtils.RECT_1.contains(RectangleUtils.RECT_3));
    }

    @Test
    public void test_contains_RectSame() {
        assertTrue(RectangleUtils.RECT_2.contains(RectangleUtils.RECT_2));
    }

    @Test
    public void test_contains_RectOutside() {
        assertFalse(RectangleUtils.RECT_1.contains(RectangleUtils.RECT_2));
    }

    @Test
    public void test_contains_RectOverlap() {
        assertFalse(RectangleUtils.RECT_1.contains(RectangleUtils.RECT_4));
    }

    @Test
    public void test_contains_PointInside() {
        assertTrue(RectangleUtils.RECT_1.contains(new Point(20, 30)));
    }

    @Test
    public void test_contains_PointOnEdge() {
        assertTrue(RectangleUtils.RECT_1.contains(new Point(0, 20)));
    }

    @Test
    public void test_contains_PointOnCorner() {
        assertTrue(RectangleUtils.RECT_1.contains(new Point(60, 40)));
    }

    @Test
    public void test_contains_PointOutside() {
        assertFalse(RectangleUtils.RECT_1.contains(new Point(70, 50)));
    }

    @Test
    public void test_getCenter_Rect1() {
        assertEquals(new Point(30, 20), RectangleUtils.RECT_1.getCenter());
    }

    @Test
    public void test_getCenter_Rect2() {
        assertEquals(new Point(100, 20), RectangleUtils.RECT_2.getCenter());
    }

    @Test
    public void test_getMaxX_Rect1() {
        assertEquals(60, RectangleUtils.RECT_1.getMaxX());
    }

    @Test
    public void test_getMaxX_Rect2() {
        assertEquals(101, RectangleUtils.RECT_2.getMaxX());
    }

    @Test
    public void test_getOrigin_Rect1() {
        assertEquals(new Point(0, 0), RectangleUtils.RECT_1.getOrigin());
    }

    @Test
    public void test_getMaxY_Rect1() {
        assertEquals(40, RectangleUtils.RECT_1.getMaxY());
    }

    @Test
    public void test_getMaxY_Rect2() {
        assertEquals(21, RectangleUtils.RECT_2.getMaxY());
    }

    @Test
    public void test_translated_PosAmt() {
        assertEquals(new Rectangle(15, 40, 60, 40), RectangleUtils.RECT_1.translated(15, 40));
    }

    @Test
    public void test_translated_NegAmt() {
        assertEquals(new Rectangle(80,10,1,1), RectangleUtils.RECT_2.translated(-20, -10));
    }
}
