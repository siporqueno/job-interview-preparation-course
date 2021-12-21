package com.niko.lesson_one_homework.task_three;

public class Square implements Shape {

    private final int SIZE;

    private final String NAME;

    public Square(int size, String name) {
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
        return 4 * SIZE;
    }

    @Override
    public double calculateArea() {
        return Math.pow(SIZE, 2);
    }
}
