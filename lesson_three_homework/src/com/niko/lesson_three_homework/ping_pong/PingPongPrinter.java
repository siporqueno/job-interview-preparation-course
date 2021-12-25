package com.niko.lesson_three_homework.ping_pong;

public class PingPongPrinter {

    private String currentToPrint = "ping";

    public static void main(String[] args) {
        PingPongPrinter printer = new PingPongPrinter();
        new Thread(() -> printer.printString("ping", "pong", 5)).start();
        new Thread(() -> printer.printString("pong", "ping", 5)).start();
    }

    synchronized void printString(String toPrint, String nextToPrint, int times) {
        for (int i = 0; i < times; i++) {
            while (!toPrint.equals(currentToPrint)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(toPrint + " ");
            currentToPrint = nextToPrint;
            notify();
        }
    }
}
