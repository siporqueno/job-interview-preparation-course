package com.niko.lesson_one_homework.task_three;

public abstract class Shape {

    protected final int SIZE;

    protected String name;

    public Shape(int size) {
        this.SIZE = size;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

}
