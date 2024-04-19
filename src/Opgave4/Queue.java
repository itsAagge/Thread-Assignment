package Opgave4;

import java.util.NoSuchElementException;

public class Queue<E> {
    private E[] elements;
    private int size = 0;
    private int front = 0;
    private int back = 0;

    public Queue(int size) {
        elements = (E[])new Object[size];
    }

    public void add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        size++;
        elements[back] = element;
        back = (back + 1) % elements.length;
    }

    public E remove() {
        throwIfEmpty();
        E removed = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return removed;
    }

    public E element() {
        throwIfEmpty();
        return elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        front = 0;
        back = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    private void throwIfEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private void increaseCapacity() {
        E[] newElementsArray = (E[])new Object[elements.length * 2];
        for (int index = 0; index < elements.length; index++) {
            newElementsArray[index] = elements[(front + index) % elements.length];
        }
        elements = newElementsArray;
        front = 0;
        back = size;
    }

}
