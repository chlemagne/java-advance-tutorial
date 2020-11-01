package com.cehernani.lambdas;

import java.util.function.Function;

/**
 * Demonstration.
 *
 * Input string:            ``key:value``
 * First transformation:    ``key=value``
 * Second transformation:   ``{key=value}``
 */
public class DemoComposingFunctions {

    public static void show1() {

        String inputString = "key:value";
        Function<String, String> replaceColon = string -> string.replace(":", "=");
        Function<String, String> addBraces = string -> "{" + string + "}";

        // Implementation #1
        String result1 = replaceColon.andThen(addBraces).apply(inputString);

        // Implementation #2
        String result2 = addBraces.compose(replaceColon).apply(inputString);
    }
}
