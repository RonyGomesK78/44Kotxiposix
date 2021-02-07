package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

public class Main {

    public static void main(String[] args) {

        BQueue<Pizza> queue= new BQueue<>(10);

        Producer producer1 = new Producer(queue,10);
        Thread thread1 = new Thread(producer1);
        thread1.setName("Producer 1");

        Producer producer2 = new Producer(queue,10);
        Thread thread2 = new Thread(producer2);
        thread2.setName("Producer 2");

        Consumer consumer1 = new Consumer(queue, 10);
        Thread thread3 = new Thread(consumer1);
        thread3.setName("Consumer 1");

        Consumer consumer2 = new Consumer(queue, 10);
        Thread thread4 = new Thread(consumer2);
        thread4.setName("Consumer 2");

        thread3.start();
        thread4.start();

        thread1.start();
        thread2.start();

    }

}

