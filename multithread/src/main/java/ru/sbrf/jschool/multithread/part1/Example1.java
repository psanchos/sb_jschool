package ru.sbrf.jschool.multithread.part1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=0;i<100000;i++) {
//            Thread t = new Thread(new SomeTask1());
//            t.start();
            executor.execute(new SomeTask1());
        }
        Thread.currentThread().join();
        System.out.println("wait");
//        Thread t2 = new Thread(()-> System.out.println("hello"));
        new SomeTask1().run();
    }

}

class SomeTask1 implements Runnable {

    @Override
    public void run() {
        ArrayList list=new ArrayList();
        for(int i=0;i<1000000;i++){
            list.add(System.currentTimeMillis());
        }
        System.out.println("ok");

    }
}