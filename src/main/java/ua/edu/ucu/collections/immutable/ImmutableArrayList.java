package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] arrList;
    private int elNum;

    public ImmutableArrayList(Object[] elements) {
        arrList = elements;
        elNum = elements.length;
    }

    public ImmutableArrayList() {
        arrList = new Object[0];
        elNum = 0;
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

        Object[] modifiedArr = new Object[elNum + c.length];
        int arrListId = 0;
        for (int i = 0; i < modifiedArr.length; i++) {
            if (i == index) {
                System.arraycopy(c, 0, modifiedArr, i, c.length);
                i += c.length - 1;
            } else {
                modifiedArr[i] = arrList[arrListId];
                arrListId++;
            }
        }
        return new ImmutableArrayList(modifiedArr);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return arrList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndex(index);
        Object[] modifiedArr = new Object[elNum - 1];
        int modifiedArrId = 0;
        for (int i = 0; i < elNum; i++) {
            if (i != index) {
                modifiedArr[modifiedArrId] = arrList[i];
                modifiedArrId++;
            }
        }
        return new ImmutableArrayList(modifiedArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        Object[] modifiedArr = arrList;
        modifiedArr[index] = e;
        return new ImmutableArrayList(modifiedArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elNum; i++) {
            if (get(i) == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elNum;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return elNum == 0;
    }

    @Override
    public Object[] toArray() {
        return arrList;
    }

    private void checkIndex(int passedId) {
        if (passedId > elNum || passedId < 0) {
            throw new IllegalArgumentException("index: " + passedId + " is unreachable");
        }
    }
}
