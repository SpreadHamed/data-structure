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

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(T item) {
        if (isFull())
            resize();

        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (var i = index; i < count - 1; i++)
            items[i] = items[i + 1];

        count--;
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
