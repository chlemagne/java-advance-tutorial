package com.cehernani.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
public class CollectionsDemo {

    public static void show1() {
        Collection<String> collection = new ArrayList<>();
        Collection<String> other = new ArrayList<>();

        Collections.addAll(collection, "a", "b", "c");
        other.addAll(collection);

        collection.remove("a");
        int collectionSize = collection.size();
        collection.clear();
        boolean isEmpty = collection.isEmpty();
        boolean containsB = collection.contains("b");
        Object[] objectArray = collection.toArray();
        String[] stringArray = collection.toArray(new String[0]); // common convention to set size to 0
        boolean isCollectionEqualOther = collection.equals(other);

    }
}
