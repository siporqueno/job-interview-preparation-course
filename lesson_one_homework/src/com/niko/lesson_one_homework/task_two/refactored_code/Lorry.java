package com.niko.lesson_one_homework.task_two.refactored_code;

class Lorry extends Car implements Loadable {

    @Override
    public void load() {
        System.out.println("Lorry is loaded.");
    }

    @Override
    public void unload() {
        System.out.println("Lorry is unloaded.");
    }
}

