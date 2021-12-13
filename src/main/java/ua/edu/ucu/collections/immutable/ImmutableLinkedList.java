package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node firstElem;
    private Node lastElem;
    private int elNum;

    public ImmutableLinkedList(Object[] elements) {
        lastElem = null;
        elNum = 0;

        for (Object el : elements) {
            Node currNode = new Node();
            currNode.setValue(el);
            elNum++;

            if (lastElem == null) {
                firstElem = currNode;
                lastElem = currNode;
            } else {
                lastElem.setNext(currNode);
                currNode.setPrevious(lastElem);
                lastElem = currNode;
            }
        }
    }

    public ImmutableLinkedList() {
        this.firstElem = new Node();
        this.lastElem = this.firstElem;
        this.elNum = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] singleObjArr = {e};
        return addAll(elNum, singleObjArr);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] singleObjArr = {e};
        return addAll(index, singleObjArr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(elNum, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        checkIndex(index);

        Object[] arrRepr = toArray();
        Object[] modifiedArr = new Object[elNum + c.length];

        int idInArrRep = 0;
        for (int i = 0; i < modifiedArr.length; i++) {
            if (i == index) {
                System.arraycopy(c, 0, modifiedArr, index, c.length);
                i += c.length - 1;
            } else {
                modifiedArr[i] = arrRepr[idInArrRep];
                idInArrRep++;
            }
        }
        return new ImmutableLinkedList(modifiedArr);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);

        int currId = 0;
        Node currNode = firstElem;
        while (true) {
            if (currId == index) {
                return currNode.getValue();
            }
            currNode = currNode.getNext();
            currId++;
        }
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndex(index);

        Object[] arrRepresentation = toArray();
        Object[] modifiedArr = new Object[elNum - 1];

        int modifiedArrId = 0;
        for (int i = 0; i < elNum; i++) {
            if (i != index) {
                modifiedArr[modifiedArrId] = arrRepresentation[i];
                modifiedArrId++;
            }
        }
        return new ImmutableLinkedList(modifiedArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndex(index);

        Object[] arrRepresentation = toArray();
        arrRepresentation[index] = e;
        return new ImmutableLinkedList(arrRepresentation);
    }

    @Override
    public int indexOf(Object e) {
        Node currNode = firstElem;
        int currId = 0;
        while (currNode != null) {
            if (currNode.getValue() == e) {
                return currId;
            }
            currNode = currNode.getNext();
            currId++;
        }
        return -1;
    }

    @Override
    public int size() {
        return elNum;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return elNum == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] elems = new Object[elNum];
        Node currNode = firstElem;
        for (int i = 0; i < elNum; i++) {
            elems[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return elems;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(elNum, e);
    }

    public Node getHead() {
        if (isEmpty()) {
            return null;
        }
        return firstElem;
    }

    public Node getTail() {
        if (isEmpty()) {
            return null;
        }
        return lastElem;
    }

    public Object getFirst() {
        if (isEmpty()) {
            return null;
        }
        return firstElem.getValue();
    }

    public Object getLast() {
        if (isEmpty()) {
            return null;
        }
        return lastElem.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(elNum - 1);
    }

    private void checkIndex(int passedId) {
        if (passedId > elNum || passedId < 0) {
            throw new IllegalArgumentException("Index: " + passedId + " is unreachable");
        }
    }

    public String toString() {
        return Arrays.toString(toArray());
    }
}
