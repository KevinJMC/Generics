package mccann.kevin.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MyMapTest {

    MyMap<Object, Object> testMap;
    Object i, t, e, m;

    @Before
    public void setUp() {
        testMap = new MyMap<>();
        i = new Object();
        t = new Object();
        e = new Object();
        m = new Object();
    }

    @Test
    public void clearTest() throws Exception {
        testMap.put(i, t);
        testMap.clear();
        assertEquals(0,testMap.size());
    }

    @Test
    public void containsKeyTest() throws Exception {
        testMap.put(i, t);
        assertTrue(testMap.containsKey(i));
    }

    @Test
    public void containsValueTest() throws Exception {
        testMap.put(i, t);
        assertTrue(testMap.containsValue(t));
    }

//    @Test
//    public void entrySetTest() throws Exception {
//
//    }

    @Test
    public void equalsTest() throws Exception {
        testMap.put(i, t);
        testMap.put(e, m);
        MyMap<Object, Object> equalMap = new MyMap<>();
        equalMap.put(i, t);
        equalMap.put(e, m);
        assertTrue(testMap.equals(equalMap));
    }

    @Test
    public void getTest() throws Exception {
        testMap.put(i, t);
        testMap.put(e, m);
        assertEquals(t,testMap.get(i));
    }

//    @Test
//    public void hashCodeTest() throws Exception {
//
//    }

    @Test
    public void isEmptyTest() throws Exception {
        assertTrue(testMap.isEmpty());
    }

    @Test
    public void keySetTest() throws Exception {
        MySet<Object> keySet = new MySet<>();
        keySet.add(i);
        keySet.add(e);
        testMap.put(i, t);
        testMap.put(e, m);
        assertEquals(keySet,testMap.keySet());
    }

    @Test
    public void putTest() throws Exception {
        testMap.put(i, t);
        assertEquals(1,testMap.size());
    }

    @Test
    public void removeTest() throws Exception {
        testMap.put(i, t);
        testMap.put(e, m);
        testMap.remove(i);
        assertFalse(testMap.containsKey(i));
        assertFalse(testMap.containsValue(t));
    }

    @Test
    public void sizeTest() throws Exception {
        testMap.put(i, t);
        assertEquals(1,testMap.size());
    }

    @Test
    public void valuesTest() throws Exception {
        MyArrayList<Object> valueList = new MyArrayList<>();
        valueList.add(t);
        valueList.add(m);
        testMap.put(i, t);
        testMap.put(e, m);
        assertEquals(valueList,testMap.values());
    }

}