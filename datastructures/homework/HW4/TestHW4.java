import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TestHW4 {

    @Test
    public void testDoubleIntIterator1() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(-6);
        l.add(8);
        Integer[] expected = {5,7,-6,8};
        TestUtilities.check(expected, new DoubleIntIterator(l));
    }

    @Test
    public void testDoubleIntIterator2() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(-6);
        l.add(8);
        Integer[] expected = {5,7,-6,8};
        DoubleIntIterator iter = new DoubleIntIterator(l);
        assertEquals((Integer)5, iter.next());
        assertEquals((Integer)7, iter.next());
        iter.remove();
        assertEquals((Integer)(-6), iter.next());
        assertEquals((Integer)8, iter.next());
        assertEquals("[5,-6,8]", l.toString());
    }

    @Test
    public void testBackwardsDoubleIntIterator1() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(-6);
        l.add(8);
        Integer[] expected = {8,-6,7,5};
        TestUtilities.check(expected, new BackwardsDoubleIntIterator(l));
    }

    @Test
    public void testBackwardsDoubleIntIterator2() {
        DoubleIntList l = new DoubleIntList();
        l.add(5);
        l.add(7);
        l.add(-6);
        l.add(8);
        Integer[] expected = {5,7,-6,8};
        BackwardsDoubleIntIterator iter = new BackwardsDoubleIntIterator(l);
        assertEquals((Integer)8, iter.next());
        assertEquals((Integer)(-6), iter.next());
        iter.remove();
        assertEquals((Integer)7, iter.next());
        assertEquals((Integer)5, iter.next());
        assertEquals("[5,7,8]", l.toString());
    }
    @Test
    public void testPunctuation1() {
        String s = "!Hell.o,";
        String ans = Book.punctuation(s);
        String expected = "hello";
        assertEquals(expected, ans);
    }
    @Test
    public void testPunctuation2() {
        String s = "\"Hello\'.,";
        String ans = Book.punctuation(s);
        String expected = "hello";
        assertEquals(expected, ans);
    }
    @Test
    public void testWords1() {
        TreeMap<String,Integer> m = Book.words("input");
        TreeMap<String,Integer> expected = new TreeMap<String,Integer>();
        //{a=2, day=2, great=3, is=3, today=3, wonderful=2}
        expected.put("a",2);
        expected.put("day",2);
        expected.put("great",3);
        expected.put("is",3);
        expected.put("today",3);
        expected.put("wonderful",2);
        assertEquals(expected, m);
    }
    @Test
    public void testStatistics1() {
        TreeMap<String, Integer> m = Book.words("input");
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Book.statistics(m);
        System.setOut(originalOut);
        String EOL = System.getProperty("line.separator");
        String expected = "Number of different words in book: 6"+EOL;
        expected = expected+"Total number of in book: 15"+EOL;
        expected = expected+"Most common word in book: great"+EOL;
        expected = expected+"Longest word in book: wonderful"+EOL;
        expected = expected+"Is occurs in book: 3 times"+EOL;

        assertEquals(expected, bos.toString());
    }
}