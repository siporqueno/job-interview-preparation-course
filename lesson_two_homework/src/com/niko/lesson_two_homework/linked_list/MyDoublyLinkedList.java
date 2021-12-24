package com.niko.lesson_two_homework.linked_list;

import com.niko.lesson_two_homework.MyList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyDoublyLinkedList<E> implements MyList<E>, MyDeque<E> {

    private Link<E> first;
    private Link<E> last;

    private int size;

    public MyDoublyLinkedList() {
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
        Link<E> newLink = new Link<E>(value);
        if (!isEmpty()) {
            this.last.next = newLink;
            newLink.prev = this.last;
        } else {
            this.first = newLink;
        }
        this.last = newLink;
        size++;
    }

    @Override
    public void add(int index, E value) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }

        Link<E> currentLink = getLinkByIndex(index);
        Link<E> newLink = new Link<>(value);

        if (currentLink.prev != null) {
            newLink.prev = currentLink.prev;
            newLink.prev.next = newLink;
        } else {
            this.first = newLink;
        }

        newLink.next = currentLink;
        currentLink.prev = newLink;

        this.size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No element with such index");
        }

        Link<E> currentLink = getLinkByIndex(index);
        E valueOfLinkToBeRemoved = currentLink.getValue();

        removeLink(currentLink);

        return valueOfLinkToBeRemoved;
    }

    @Override
    public boolean remove(Object o) {
        E valueOfLinkToBeRemoved = null;
        int indexOfLinkToBeRemoved = -1;
        Link<E> currentLink = first;

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
            currentLink = currentLink.next;
        }

        if (indexOfLinkToBeRemoved == -1) {
            return false;
        }

        removeLink(currentLink);

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

    private Link<E> getLinkByIndex(int index) {
        int middleOfList = this.size / 2 + this.size % 2 - 1;
        Link<E> currentLink = first;

        if (index <= middleOfList) {
            for (int i = 0; i < index; i++) {
                currentLink = currentLink.next;
            }
        } else {
            currentLink = last;
            for (int i = size - 1; i > index; i--) {
                currentLink = currentLink.prev;
            }
        }
        return currentLink;
    }

    private void removeLink(Link<E> currentLink) {
        if (currentLink.prev != null && currentLink.next != null) {
            currentLink.prev.next = currentLink.next;
            currentLink.next.prev = currentLink.prev;
        }

        if (currentLink.prev != null && currentLink.next == null) {
            currentLink.prev.next = null;
            this.last = currentLink.prev;
        }

        if (currentLink.prev == null && currentLink.next != null) {
            this.first = currentLink.next;
            currentLink.next.prev = null;
        }

        this.size--;
    }

    @Override
    public void addFirst(E value) {
        Link<E> newLink = new Link<>(value);

        if (!isEmpty()) {
            newLink.next = this.first;
        } else {
            this.last = newLink;
        }
        this.first = newLink;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Link<E> currentFirstLink = this.first;
        this.first = this.first.next;
        this.first.prev = null;

        return currentFirstLink.getValue();
    }

    @Override
    public E getFirst() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.first.getValue();
    }

    @Override
    public void addLast(E value) {
        Link<E> newLink = new Link<>(value);

        if (!isEmpty()) {
            this.last.next = newLink;
        } else {
            this.first = newLink;
        }
        this.last = newLink;
    }

    @Override
    public E removeLast() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Link<E> currentLastLink = this.last;
        this.last = this.last.prev;
        this.last.next = null;

        return currentLastLink.getValue();
    }

    @Override
    public E getLast() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.last.getValue();
    }
}
