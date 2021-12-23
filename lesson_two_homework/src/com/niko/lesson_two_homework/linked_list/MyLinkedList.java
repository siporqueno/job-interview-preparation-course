package com.niko.lesson_two_homework.linked_list;

import com.niko.lesson_two_homework.MyList;

import java.util.Objects;

public class MyLinkedList<E> implements MyList<E> {

    private Link<E> first;

    private int size;

    public MyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }
        return getLinkByIndex(index).getValue();
    }

    @Override
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }

        Link<E> targetLink = getLinkByIndex(index);
        E currentValueOfTargetLink = targetLink.getValue();
        targetLink.setValue(newValue);

        return currentValueOfTargetLink;
    }

    @Override
    public void add(E value) {
        getLastLink().next = new Link<E>(value);
    }

    @Override
    public void add(int index, E value) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }

        Link<E> previousLink = null;

        if (index == 0) {
            previousLink = this.first;
        } else {
            previousLink = getLinkByIndex(index - 1);
        }

        Link<E> newLink = new Link<E>(value);
        newLink.next = previousLink.next;
        previousLink.next = newLink;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }

        Link<E> previousLink = null;

        if (index == 0) {
            previousLink = this.first;
        } else {
            previousLink = getLinkByIndex(index - 1);
        }

        E valueOfLinkToBeRemoved = previousLink.next.getValue();
        previousLink.next = previousLink.next.next;

        return valueOfLinkToBeRemoved;
    }

    @Override
    public boolean remove(Object o) {
        E valueOfLinkToBeRemoved = null;
        int indexOfLinkToBeRemoved = -1;
        Link<E> currentLink = first;
        Link<E> previousLink = first;

        if (isEmpty()) {
            return false;
        }

        try {
            valueOfLinkToBeRemoved = (E) o;
        } catch (ClassCastException e) {
            System.out.println("Incompatible types. Failed to cast.");
            return false;
        }

        for (int i = 0; i <= this.size - 1; i++) {
            if (Objects.equals(valueOfLinkToBeRemoved, currentLink.getValue())) {
                indexOfLinkToBeRemoved = i;
                break;
            }
            previousLink = currentLink;
            currentLink = currentLink.next;
        }

        if (indexOfLinkToBeRemoved == -1) {
            return false;
        }

        previousLink = currentLink.next;
        size--;

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private Link<E> getLastLink() {
        Link<E> currentLink = first;
        while (currentLink.next != null) {
            currentLink = currentLink.next;
        }
        return currentLink;
    }

    private Link<E> getLinkByIndex(int index) {
        Link<E> currentLink = first;
        for (int i = 0; i < index; i++) {
            currentLink = currentLink.next;
        }
        return currentLink;
    }
}
