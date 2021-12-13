package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableList linkedList;
    private ImmutableLinkedList linkedList2;

    @Before
    public void setUp(){
        linkedList = new ImmutableLinkedList();
        linkedList2 = new ImmutableLinkedList();
    }

    @Test
    public void testAdd() {
        ImmutableList res = linkedList.add(1);
        Object[] expRes = {1};
        assertArrayEquals(expRes, res.toArray());
    }

    @Test
    public void testTestAdd() {
        ImmutableList res = linkedList.add(0, 1);
        Object[] expRes = {1};
        assertArrayEquals(expRes, res.toArray());

        ImmutableList res2 = res.add(0, 2);
        Object[] expRes2 = {2, 1};
        assertArrayEquals(expRes2, res2.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableList res = linkedList.addAll(new Object[]{1, 2, 3});
        Object[] expRes = {1, 2, 3};
        assertArrayEquals(expRes, res.toArray());
    }

    @Test
    public void testTestAddAll() {
        ImmutableList res = linkedList.addAll(0, new Object[]{1, 2, 3});
        Object[] expRes = {1, 2, 3};
        assertArrayEquals(expRes, res.toArray());

        ImmutableList res2 = res.addAll(0, new Object[]{11, 22});
        Object[] expRes2 = {11, 22, 1, 2, 3};
        assertArrayEquals(expRes2, res2.toArray());
    }

    @Test
    public void testGet() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        Object expRes = 3;
        assertEquals(expRes, list.get(2));
    }

    @Test
    public void testRemove() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        ImmutableList res = list.remove(1);
        Object[] expRes = {1, 3};
        assertArrayEquals(expRes, res.toArray());
    }

    @Test
    public void testSet() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        ImmutableList res = list.set(1, 99);
        Object[] expRes = {1, 99, 3};
        assertArrayEquals(expRes, res.toArray());
    }

    @Test
    public void testIndexOf() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        int res = list.indexOf(3);
        int expRes = 2;
        assertEquals(expRes, res);
    }

    @Test
    public void testIndexOfNoEntry() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        int res = list.indexOf(0);
        int expRes = -1;
        assertEquals(expRes, res);
    }

    @Test
    public void testSize() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        int res = list.size();
        int expRes = 3;
        assertEquals(expRes, res);

        int expRes2 = 0;
        int res2 = linkedList.size();
        assertEquals(expRes2, res2);
    }

    @Test
    public void testClear() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        ImmutableList res = list.clear();
        Object[] expRes = {};
        int expSize = 0;
        int resSize = res.size();

        assertArrayEquals(expRes, res.toArray());
        assertEquals(expSize, resSize);
    }

    @Test
    public void testIsEmpty() {
        boolean expRes = true;
        assertEquals(expRes, linkedList.isEmpty());

        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        boolean expRes2 = false;
        assertEquals(expRes2, list.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableList list = linkedList.addAll(new Object[]{1, 2, 3});
        Object[] expRes = {1, 2, 3};
        assertArrayEquals(expRes, list.toArray());

        Object[] expRes2 = {};
        assertArrayEquals(expRes2, linkedList.toArray());
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList newList = linkedList2.addFirst(1);
        Object[] expRes = {1};
        assertArrayEquals(expRes, newList.toArray());

        ImmutableLinkedList newList2 = newList.addFirst(2);
        Object[] expRes2 = {2, 1};
        assertArrayEquals(expRes2, newList2.toArray());
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList newList = linkedList2.addLast(1);
        Object[] expRes = {1};
        assertArrayEquals(expRes, newList.toArray());

        ImmutableLinkedList newList2 = newList.addLast(2);
        Object[] expRes2 = {1, 2};
        assertArrayEquals(expRes2, newList2.toArray());
    }

    @Test
    public void testGetHead() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3});
        Node res = list.getHead();
        assertEquals(1, res.getValue());

        assertNull(linkedList2.getHead());
    }

    @Test
    public void testGetTail() {
        assertNull(linkedList2.getTail());

        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3});
        Node res = list.getTail();
        assertEquals(3, res.getValue());
    }

    @Test
    public void testGetFirst() {
        assertNull(linkedList2.getFirst());

        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3});
        Object res = list.getFirst();
        assertEquals(1, res);
    }

    @Test
    public void testGetLast() {
        assertNull(linkedList2.getLast());

        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3});
        Object res = list.getLast();
        assertEquals(3, res);
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[]{1, 2, 3});
        ImmutableLinkedList newList2 = newList.removeFirst();
        Object[] expRes = {2, 3};
        assertArrayEquals(expRes, newList2.toArray());
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[]{1, 2, 3});
        ImmutableLinkedList newList2 = newList.removeLast();
        Object[] expRes = {1, 2};
        assertArrayEquals(expRes, newList2.toArray());
    }

    @Test
    public void testTestToString() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[]{1, 2, 3});
        String expRes = "[1, 2, 3]";
        assertEquals(expRes, newList.toString());
    }
}