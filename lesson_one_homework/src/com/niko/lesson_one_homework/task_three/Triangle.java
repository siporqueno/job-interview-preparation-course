package com.niko.lesson_one_homework.task_three;

public class Triangle extends Shape {

    public Triangle(int size) {
        super(size);
        this.name = "triangle";
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
