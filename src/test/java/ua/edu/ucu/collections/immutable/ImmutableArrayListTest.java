package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableList arrLst;

    @Before
    public void setUp() {
        arrLst = new ImmutableArrayList();
    }

    @Test
    public void testAdd() {
        ImmutableList newArr = arrLst.add(1);
        Object[] expRes = {1};
        assertArrayEquals(expRes, newArr.toArray());
    }

    @Test
    public void testTestAdd() {
        ImmutableList newArr = new ImmutableArrayList(new Object[]{1, 2, 3});
        ImmutableList modArr = newArr.add(0, 11);
        Object[] expRes = {11, 1, 2, 3};
        assertArrayEquals(expRes, modArr.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        Object[] expRes = {1, 2, 3};
        assertArrayEquals(expRes, newArr.toArray());
    }

    @Test
    public void testTestAddAll() {
        ImmutableList newArr = arrLst.addAll(0, new Object[]{1, 2, 3});
        Object[] expRes = {1, 2, 3};
        assertArrayEquals(expRes, newArr.toArray());

        ImmutableList newArr2 = newArr.addAll(0, new Object[]{22, 11});
        Object[] expRes2 = {22, 11, 1, 2, 3};
        assertArrayEquals(expRes2, newArr2.toArray());
    }

    @Test
    public void testGet() {
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        Object res = 2;
        assertEquals(res, newArr.get(1));
    }

    @Test
    public void testRemove() {
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        ImmutableList resArr = newArr.remove(0);
        Object[] expRes = {2, 3};
        assertArrayEquals(expRes, resArr.toArray());
    }

    @Test
    public void testSet() {
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        ImmutableList resArr = newArr.set(1, 100);
        Object[] expRes = {1, 100, 3};
        assertArrayEquals(expRes, resArr.toArray());
    }

    @Test
    public void testIndexOf() {
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        assertEquals(1, newArr.indexOf(2));
        assertEquals(-1, newArr.indexOf(11));
    }

    @Test
    public void testSize() {
        assertEquals(0, arrLst.size());
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        assertEquals(3, newArr.size());

    }

    @Test
    public void testClear() {
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        ImmutableList res = newArr.clear();
        Object[] expRes = {};
        assertArrayEquals(expRes, res.toArray());

    }

    @Test
    public void testIsEmpty() {
        assertTrue(arrLst.isEmpty());
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        assertFalse(newArr.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] expRes = {};
        assertArrayEquals(expRes, arrLst.toArray());

        Object[] expRes2 = {1, 2, 3};
        ImmutableList newArr = arrLst.addAll(new Object[]{1, 2, 3});
        assertArrayEquals(expRes2, newArr.toArray());
    }
}