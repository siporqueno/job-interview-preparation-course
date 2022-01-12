package com.niko.lesson_three_homework.thread_safe_counter;

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        for (int i = 0; i < 500; i++) {
            new Thread(increaseCountByThousand(counter)).start();
        }

        Thread.sleep(1000);

        System.out.println("Count: " + counter.getCount());
    }

    static Runnable increaseCountByThousand(Counter counter) {
        return () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increaseCount();
            }
        };
    }
}
