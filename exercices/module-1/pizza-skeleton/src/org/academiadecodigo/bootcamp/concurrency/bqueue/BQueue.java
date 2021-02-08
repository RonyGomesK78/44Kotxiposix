package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private LinkedList<T> tray;
    private final int limit;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {

        this.tray = new LinkedList<>();
        this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while (tray.size() == limit) {

            try {

                System.out.println("waiting consume...");
                wait();
                //Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        tray.offer(data);

        if (tray.size() == 1) notifyAll();

    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        T data;

        while (tray.isEmpty()){

            try {

                System.out.println("waiting pizza...");
                wait();
              //  Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        data = tray.poll();

        if (tray.size() + 1 == limit) notifyAll();

        return data;
    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {

        return this.tray.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;
    }

}
