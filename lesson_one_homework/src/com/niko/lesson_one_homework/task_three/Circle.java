package com.niko.lesson_one_homework.task_three;

public class Circle implements Shape {

    private final int SIZE;

    private final String NAME;

    public Circle(int size, String name) {
        this.SIZE = size;
        this.NAME = name;
    }

    @Override
    public int getSIZE() {
        return SIZE;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * SIZE;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(SIZE, 2);
    }
}
