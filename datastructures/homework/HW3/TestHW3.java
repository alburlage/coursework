import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestHW3 {

    @Test
    public void testDoubleIntNodeDefaultConstructor() {
        DoubleIntNode n1 = new DoubleIntNode(10);
        assertEquals(10, n1.data);
        assertNull(n1.prev);
        assertNull(n1.next);
    }

    @Test
    public void testDoubleIntNodeConstructor() {
        DoubleIntNode n1 = new DoubleIntNode(null, 5, null);
        DoubleIntNode n2 = new DoubleIntNode(null, 7, n1);
        n1.prev = n2;
        assertEquals(5, n1.data);
        assertEquals(n2, n1.prev);
        assertNull(n1.next);
        assertEquals(7, n2.data);
        assertNull(n2.prev);
        assertEquals(n1, n2.next);
    }

    @Test
    public void testDoubleIntListDefaultConstructor() {
        DoubleIntList l = new DoubleIntList();
        assertEquals(0, l.size());
        assertNull(l.getFront());
        assertNull(l.getEnd());
    }

    @Test
    public void test1add() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        assertEquals(5, l.getFront().data);
        assertEquals(7, l.getEnd().data);
        assertEquals(2, l.size());
        assertEquals(5, l.getEnd().prev.data);
        assertEquals(7, l.getFront().next.data);
        assertNull(l.getEnd().next);
        assertNull(l.getFront().prev);
    }

    @Test
    public void test2add() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(1, 6);
        assertEquals(5, l.getFront().data);
        assertEquals(7, l.getEnd().data);
        assertEquals(3, l.size());
        assertEquals(6, l.getEnd().prev.data);
        assertEquals(6, l.getFront().next.data);
        assertEquals(5, l.getFront().next.prev.data);
        assertEquals(7, l.getEnd().prev.next.data);
        assertNull(l.getEnd().next);
        assertNull(l.getFront().prev);
    }

    @Test
    public void test1print() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(1, 6);
        l.add(8);
        assertEquals("[5,6,7,8]", l.toString());

    }

    @Test
    public void testsetget() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(1, 6);
        l.add(8);
        l.set(2, 10);
        assertEquals(10, l.get(2));
        assertEquals(5, l.get(0));
    }

    @Test
    public void testempty() {
        DoubleIntList l = new DoubleIntList();
        DoubleIntList l2 = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(1, 6);
        l.add(8);
        assertFalse(l.isEmpty());
        assertTrue(l2.isEmpty());
    }

    @Test
    public void test1search() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(1, 6);
        l.add(8);
        assertEquals(3, l.indexOf(8));
        assertEquals(-1, l.indexOf(0));
    }

    @Test
    public void testremove() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(1, 6);
        l.add(8);
        l.remove(1);
        assertEquals("[5,7,8]", l.toString());
    }

    @Test
    public void testsort() {
        DoubleIntList l = new DoubleIntList();
        l.add(-1);
        l.add(7);
        l.add(2);
        l.add(8);
        l.add(4);
        l.sort();
        assertEquals("[-1,2,4,7,8]", l.toString());
    }
}
