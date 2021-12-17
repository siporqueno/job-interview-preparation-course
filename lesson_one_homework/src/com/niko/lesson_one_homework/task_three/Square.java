package com.niko.lesson_one_homework.task_three;

public class Square extends Shape {


    public Square(int size) {
        super(size);
        this.name = "square";
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
