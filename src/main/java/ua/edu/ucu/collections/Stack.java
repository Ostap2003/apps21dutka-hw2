package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    public void push(Object e) {
        stack = stack.addLast(e);
    }

    public Object pop() {
        Object last = stack.getLast();
        stack = stack.removeLast();
        return last;
    }

    public Object peek() {
        return stack.getLast();
    }
}
