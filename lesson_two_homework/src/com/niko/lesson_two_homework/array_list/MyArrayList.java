package com.niko.lesson_two_homework.array_list;

import com.niko.lesson_two_homework.MyList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {

    private Object[] arr;
    private int size;

    public MyArrayList(int size) {
        this.arr = new Object[size];
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }
        return (E) this.arr[index];
    }

    @Override
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }
        E currentValue = (E) this.arr[index];
        this.arr[index] = newValue;
        return currentValue;
    }

    @Override
    public void add(E value) {
        this.arr[size++] = value;
    }

    @Override
    public void add(int index, E value) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of the range");
        }

        if (this.arr.length == size) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }

        if (index == size) {
            add(value);
        } else {
            for (int i = size; i > index; i--) {
                this.arr[i] = this.arr[i - 1];
                this.arr[index] = value;
                size++;
            }
        }

    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }

        E elementToBeRemoved = (E) this.arr[index];

        if (index < size - 1) {
            for (int i = index; i < size - 2; i++) {
                this.arr[i] = this.arr[i + 1];
            }
        }
        size--;
        return elementToBeRemoved;
    }

    @Override
    public boolean remove(Object o) {
        E elementToBeRemoved = null;

        if (isEmpty()) {
            return false;
        }

        try {
            elementToBeRemoved = (E) o;
        } catch (ClassCastException e) {
            System.out.println("Incompatible types. Failed to cast.");
            return false;
        }

        int indexOfElementToBeRemoved = -1;

        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(elementToBeRemoved, this.arr[i])) {
                indexOfElementToBeRemoved = i;
                break;
            }
        }

        if (indexOfElementToBeRemoved == -1) {
            return false;
        }

        if (indexOfElementToBeRemoved < size - 1) {
            for (int i = indexOfElementToBeRemoved; i < size - 2; i++) {
                this.arr[i] = this.arr[i + 1];
            }
        }
        size--;

        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

}
