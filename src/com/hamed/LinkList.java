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

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            last = getPrevious(last);
            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node node) {
        var previous = first;
        while (previous != null) {
            if (previous.next == node)
                return previous;
            previous = previous.next;
        }
        return null;
    }

    public T[] toArray() {
        var array = (T[]) new Object[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void revers() {
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;

        first = previous;
    }

    public T findKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        if (k <= 0 || k > size)
            throw new IllegalArgumentException();

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++)
            b = b.next;

        while (b != last) {
            b = b.next;
            a = a.next;
        }

        return a.value;
    }
}
