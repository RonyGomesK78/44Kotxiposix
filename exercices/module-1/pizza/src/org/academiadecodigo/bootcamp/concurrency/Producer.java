package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int pizzasToMake;

    /**
     * @param queue the blocking queue to add elements to
     * @param pizzasToMake the number of elements to produce
     */
    public Producer(BQueue queue, int pizzasToMake) {
        this.queue = queue;
        this.pizzasToMake = pizzasToMake;
    }

    @Override
    public void run() {

    }

}
