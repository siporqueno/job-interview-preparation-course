package com.niko.lesson_one_homework.task_three;

public class Circle extends Shape {

    public Circle(int size) {
        super(size);
        this.name = "circle";
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
