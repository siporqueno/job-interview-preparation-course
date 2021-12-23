package com.niko.lesson_two_homework;

public interface MyList<E> {

    E get(int index);

    E set(int index, E newValue);

    void add(E value);

    void add(int index, E value);

    E remove(int index);

    boolean remove(Object o);

    int size();

    boolean isEmpty();

    }
