package com.hamed;

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
}
