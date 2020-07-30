package com.hamed;

import java.util.NoSuchElementException;

public class LinkList<T> {
    private class Node {
        T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(T value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(T value) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value.equals(value))
                return index;

            index++;
            current = current.next;
        }

        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }
}
