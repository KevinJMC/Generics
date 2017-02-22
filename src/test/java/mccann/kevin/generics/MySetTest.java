package mccann.kevin.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MySetTest {
    MySet<Object> testSet;
    Object c, j;

    @Before
    public void setUp() {
        testSet = new MySet<>();
        c = new Object();
        j = new Object();
    }

    @Test
    public void addTest() throws Exception {
        testSet.add(c);
        assertEquals(1,testSet.size());
    }

    @Test
    public void addIfAlreadyContainsTest() throws Exception {
        testSet.add(c);
        testSet.add(c);
        assertEquals(1, testSet.size());
    }

    @Test
    public void clearTest() throws Exception {
        testSet.add(c);
        testSet.clear();
        assertEquals(0,testSet.size());
    }

    @Test
    public void doesContainTest() throws Exception {
        testSet.add(c);
        assertTrue(testSet.contains(c));
    }

    @Test
    public void doesntContainTest() throws Exception {
        testSet.add(c);
        assertFalse(testSet.contains(j));
    }

//    @Test
//    public void equalsTest() throws Exception {
//        testSet.add(c);
//        testSet.add(j);
//        MySet<Object> equalSet = new MySet<>();
//        equalSet.add(c);
//        equalSet.add(j);
//        assertTrue(testSet.equals(equalSet));
//    }

//    @Test
//    public void hashCodeTest() throws Exception {
//
//    }

    @Test
    public void isEmptyTest() throws Exception {
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void isNotEmptyTest() throws Exception {
        testSet.add(c);
        assertFalse(testSet.isEmpty());
    }

    @Test
    public void removeTest() throws Exception {
        testSet.add(c);
        testSet.remove(c);
        assertFalse(testSet.contains(c));
    }

    @Test
    public void sizeTest() throws Exception {
        testSet.add(c);
        testSet.add(j);
        assertEquals(2, testSet.size());
    }

    @Test
    public void toArrayTest() throws Exception {
        testSet.add(c);
        testSet.add(j);
        Object[] expected = {c,j};
        Object[] actual = testSet.toArray();
        assertArrayEquals(expected,actual);
    }

}