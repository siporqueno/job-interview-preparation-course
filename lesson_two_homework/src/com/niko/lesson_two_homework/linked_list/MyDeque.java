package com.niko.lesson_two_homework.linked_list;

import java.util.NoSuchElementException;

public interface MyDeque<E> {

    void addFirst(E value);

    E removeFirst() throws NoSuchElementException;

    E getFirst() throws NoSuchElementException;

    void addLast(E value);

    E removeLast() throws NoSuchElementException;

    E getLast() throws NoSuchElementException;
}
