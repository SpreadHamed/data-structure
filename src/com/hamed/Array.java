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
}
