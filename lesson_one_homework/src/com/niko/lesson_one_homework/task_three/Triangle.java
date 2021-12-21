package com.niko.lesson_one_homework.task_three;

public class Triangle implements Shape {

    private final int SIZE;

    private final String NAME;

    public Triangle(int size, String name) {
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
        return 3 * SIZE;
    }

    @Override
    public double calculateArea() {
        return Math.pow(3, 0.5) * Math.pow(SIZE, 2) / 4;
    }
}
