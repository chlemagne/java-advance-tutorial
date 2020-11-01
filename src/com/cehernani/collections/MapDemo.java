package com.cehernani.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * NOTE: Java Maps is not a part of the Collections Framework Hierarchy.
 *
 * -----------------------
 * Language   | Implementation
 * ===========+===========
 * Java       | Maps
 * C#         | Dictionary
 * Python     | Dictionary
 * Javascript | Objects
 * -----------------------
 */
public class MapDemo {

    public static void show1() {

        Customer c1 = new Customer("a", "e1");
        Customer c2 = new Customer("b", "e2");
        Customer unk = new Customer("Unknown", "");
        Map<String, Customer> map = new HashMap<>();

        map.put(c1.getEmail(), c1);          // e1
        map.put(c2.getEmail(), c2);          // e2

        Customer customer = map.get("e1");   // c1
        Customer unknown = map.get("e3");    // null
        Customer default_ = map.getOrDefault(
                "e3", unk);              // unk
        boolean customerExists =
                map.containsKey("e3");       // false
        map.replace("e1", new Customer("a++", "e1"));

        System.out.println("Loop 1:");
        // e1
        // e2
        for (String key : map.keySet())
            System.out.println(key);

        System.out.println("Loop 2:");
        // e1=a++
        // e2=b
        for (Map.Entry<String, Customer> set : map.entrySet())
            System.out.println(set);

        System.out.println("Loop 3:");
        // a++
        // b
        for (Customer customer_ : map.values())
            // NOTE: order not guaranteed
            System.out.println(customer_);
    }
}
