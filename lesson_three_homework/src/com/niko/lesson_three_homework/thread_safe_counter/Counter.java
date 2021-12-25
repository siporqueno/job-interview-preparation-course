package com.niko.lesson_three_homework.thread_safe_counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count;
    private Lock lock = new ReentrantLock();

    public void increaseCount(){
        lock.lock();
        count++;
        lock.unlock();
    }

    public int getCount() {
        return count;
    }
}
