package com.niko.lesson_one_homework.task_three;

import java.util.List;

public class DynamicPolymorphismDemo {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(1),
                new Square(1),
                new Triangle(1)
        );

        shapes.forEach(shape -> {
            System.out.printf("The %s of size %d has perimeter of %.2f and area of %.2f\n",
                    shape.name, shape.SIZE, shape.calculatePerimeter(), shape.calculateArea());
        });
    }
}
