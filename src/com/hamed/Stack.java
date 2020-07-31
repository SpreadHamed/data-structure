package com.hamed;

public class Stack<T> {
    private T[] items;
    private int count;


    public Stack() {
        items = initialItems(10);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(T value) {
        if (isFull())
            growth();
        items[count++] = value;
    }

    public T pop() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public T peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[count - 1];
    }

    private void growth() {
        var newItems = initialItems(count * 2);
        for (int i = 0; i < count; i++)
            newItems[i] = items[i];
        items = newItems;
    }

    private boolean isFull() {
        return count == items.length;
    }

    private T[] initialItems(int length) {
        return (T[]) new Object[length];
    }

}
