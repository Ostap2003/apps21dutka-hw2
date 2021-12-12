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
//        this.lastElem = lastNode;
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
        // todo test method
        Node nodeToCopy = firstElem;
        // Object[] copiedElems = new Object[elNum + c.length];

        Object[] arrRepr = toArray();
        Object[] modifiedArr = new Object[elNum + c.length];

        for (int i = 0; i < elNum + c.length; i++) {
            if (i == index) {
                for (int j = 0; j < c.length; j++) {
                    modifiedArr[j + i] = c[j];
                }
                i += c.length - 1;
            } else {
                modifiedArr[i] = arrRepr[i];
            }
        }

//        int currId = 0;
//        while (nodeToCopy != null) {
//            if (currId == index) {
//                for (int i = 0; i < c.length; i++) {
//                    copiedElems[currId + i] = c[i];
//                    currId++;
//                }
//            } else {
//                copiedElems[currId] = nodeToCopy.getValue();
//                nodeToCopy = nodeToCopy.getNext();
//                currId++;
//            }
//        }
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
        }
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndex(index);

        Object[] arrRepresentation = toArray();
        ImmutableLinkedList newList = new ImmutableLinkedList(arrRepresentation);
        int currId = 0;
        Node currNode = newList.firstElem;

        while (true) {
            if (currId == index) {
                Node prevOfCurrNode = currNode.getPrevious();
                Node nextOfCurrNode = currNode.getNext();
                prevOfCurrNode.setNext(nextOfCurrNode);
                break;
            } else {
                currNode = currNode.getNext();
                currId++;
            }
        }
        return newList;
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
        if (firstElem != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] elems = new Object[elNum];
        Node currNode = firstElem;
        int currId = 0;
        while (currNode != null) {
            elems[currId] = currNode.getValue();
            currNode = currNode.getNext();
            currId++;
        }
        return elems;
    }

    public ImmutableLinkedList addFirst(Object e) {
//        Object[] arrCopy = toArray();
//        Object[] modifiedArr = new Object[arrCopy.length + 1];
//        modifiedArr[0] = e;
//
//        // todo: check if can be changed to a suggestion
//        // maybe we can use this.add here
//
//        for (int i = 1; i <= elNum; i++) {
//            modifiedArr[i] = arrCopy[i - 1];
//        }
//        return new ImmutableLinkedList(modifiedArr);

        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(elNum, e);
    }

    public Node getHead() {
        return firstElem;
    }

    public Node getTail() {
        return lastElem;
    }

    public Object getFirst() {
        return firstElem.getValue();
    }

    public Object getLast() {
        return lastElem.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(elNum - 1);
    }

    private void checkIndex(int passedId) {
        if (passedId >= elNum) {
            throw new IllegalArgumentException("Index: " + passedId + " is unreachable");
        }
    }
}
