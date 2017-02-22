package mccann.kevin.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MyArrayListTest {
    MyArrayList<Object> testList;
    Object o, k;

    @Before
    public void setUp() {
        testList = new MyArrayList<>();
         o = new Object();
         k = new Object();
    }

    @Test
    public void addTest() throws Exception {
        testList.add(o);
        assertEquals(1, testList.size());
    }

    @Test
    public void addIndexTest() throws Exception {
        testList.add(o);
        testList.add(k, 0);
        assertEquals(k, testList.get(0));
    }

    @Test
    public void clearTest() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.clear();
        assertEquals(0, testList.size());
    }

    @Test
    public void containsTest() throws Exception {
        testList.add(o);
        assertTrue(testList.contains(o));
    }

    @Test
    public void getTest() throws Exception {
        testList.add(o);
        testList.add(k);
        assertEquals(o,testList.get(0));
    }

    @Test
    public void indexOfTest() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.add(o);
        assertEquals(0, testList.indexOf(o));
    }

    @Test
    public void isEmptyTest() throws Exception {
        assertTrue(testList.isEmpty());
    }

    @Test
    public void lastIndexOfTest() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.add(o);
        assertEquals(2, testList.lastIndexOf(o));
    }

    @Test
    public void removeTest() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.add(o);
        testList.remove(1);
        assertFalse(testList.contains(k));
        assertEquals(-1, testList.indexOf(k));
    }

    @Test
    public void remove1Test() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.add(o);
        testList.remove(o);
        assertEquals(1, testList.indexOf(o));
    }

    @Test
    public void removeRangeTest() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.add(o);
        testList.removeRange(0,2);
        assertFalse(testList.contains(k));
        assertEquals(1, testList.size());
        assertEquals(0, testList.indexOf(o));
    }

    @Test
    public void setTest() throws Exception {
        Object c = new Object();
        testList.add(o);
        testList.add(k);
        testList.add(o);
        testList.set(1,c);
        assertEquals(c, testList.get(1));
    }

    @Test
    public void sizeTest() throws Exception {
        testList.add(o);
        testList.add(k);
        assertEquals(2,testList.size());
    }

    @Test
    public void subListTest() throws Exception {
        testList.add(o);
        testList.add(o);
        testList.add(k);
        testList.add(o);
        MyArrayList<Object> testListTwo = testList.subList(1,3);
        assertEquals(2, testListTwo.size());
        assertEquals(o,testListTwo.get(0));
        assertEquals(k,testListTwo.get(1));
    }

    @Test
    public void toArrayTest() throws Exception {
        testList.add(o);
        testList.add(k);
        Object[] expected = {o,k};
        Object[] actual = testList.toArray();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void trimToSizeTest() throws Exception {
        testList.add(o);
        testList.add(k);
        testList.remove(1);
        testList.trimToSize();
        assertEquals("size of 1", 1, testList.size());
    }

}