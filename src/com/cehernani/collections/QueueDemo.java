package com.cehernani.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {

    /**
     * Collections Demo Class.
     *
     * Java Collection Framework Hierarchy
     *
     *     +Iterable
     *         +Collection
     *             +List
     *                 -ArrayList
     *                 -LinkedList
     *             +Queue
     *                 -PriorityQueue
     *                 -ArrayDeque
     *             +Set
     *                 -HashSet
     */
    public static void show1() {

        Queue<String> queue = new ArrayDeque<>();

        queue.add("c"); // c
        queue.add("a"); // a -> c
        queue.add("b"); // b -> a -> c
        queue.offer(
                "d"); // d -> b -> a -> c
        /*
            NOTE: add() VS. offer()

            The difference depends on the implementation of interface Queue. In ArrayDeque there is no difference.
            In other implementations the size may be limited, and when full the method add() will throw an exception
            whereas method offer() will return false. Therefore, method offer() is less aggressive than method add().
         */

        String front = queue.peek();    // c; method peek is similar to method element(). Similar difference above.
        queue.remove();                 // d -> b -> a; method remove() is similar to method poll().  Similar difference above.
    }
}
