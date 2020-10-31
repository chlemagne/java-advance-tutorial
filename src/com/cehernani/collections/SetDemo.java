package com.cehernani.collections;

import java.util.*;

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
public class SetDemo {

    public static void show1() {

        Set<String> set = new HashSet<>();
        // NOTE: Set interface is UNORDERED; it only guarantees uniqueness of the collection
        set.add("a"); // [a]
        set.add("b"); // [b, a]
        set.add("c"); // [a, c, b]
        set.add("c"); // [b, a, c]

        Collection<String> colors = new ArrayList<>();
        Collections.addAll(
                colors, "red", "green", "blue", "blue");    // [red, green, blue, blue]
        Set<String> uniqueColors = new HashSet<>(colors);           // [green, blue, red]

        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c")); // [a, b, c]
        Set<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d")); // [b, c, d]

        set1.addAll(set2);      // [a, b, c, d]     union
        set1.retainAll(set2);   // [b, c]           intersection
        set1.removeAll(set2);   // [a]              difference
    }
}
