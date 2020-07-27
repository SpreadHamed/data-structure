package com.hamed;

public class Array<T> {
    private T[] items;
    private int count;

    public Array(int length) {
        this.items = initialItems(length);
    }

    private T[] initialItems(int length) {
        return (T[]) new Object[length];
    }

    public void insert(T item) {
        if (isFull())
            resize();

        items[count++] = item;
    }

    private void resize() {
        var newItems = initialItems(count * 2);
        for (int i = 0; i < count; i++)
            newItems[i] = items[i];
        items = newItems;
    }

    private boolean isFull() {
        return count == items.length;
    }

}
