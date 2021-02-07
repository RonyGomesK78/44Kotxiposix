package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int pizzasToConsume;

    /**
     * @param queue the blocking queue to consume elements from
     * @param pizzasToConsume the number of elements to consume
     */
    public Consumer(BQueue queue, int pizzasToConsume) {
        this.queue = queue;
        this.pizzasToConsume = pizzasToConsume;
    }

    @Override
    public void run() {

    }

}
