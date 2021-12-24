package com.niko.lesson_two_homework.linked_list;

public class Link<E> {
    private E value;

    Link<E> prev;
    Link<E> next;

    public Link(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
