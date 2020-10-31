package com.cehernani.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
 *             +Set
 *                 -HashSet
 */
public class ListDemo {

    public static void show1() {
        List<String> list = new ArrayList<>(); // []

        Collections.addAll(
                list, "a", "b", "c");    // [a, b, c]
        list.add(0, "!");            // [!, a, b, c]
        list.get(1);                             // a
        list.set(1, "a+");                       // [!, a+, b, c]
        list.remove(0);                     // [a+, b, c]
        int indexOfA = list.indexOf("c");        // 3
        int indexOfUnk = list.indexOf("unk");    // -1
        List<String> subList = list.subList(
                0, 1);                           // [a, b]
    }
}
