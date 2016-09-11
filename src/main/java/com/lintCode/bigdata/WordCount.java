package com.lintCode.bigdata;

/**
 * Created by yanli on 9/10/2016.
 */

import java.util.Iterator;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 * public void collect(K key, V value);
 * // Adds a key/value pair to the output buffer
 * }
 */
public class WordCount {
    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] split = value.trim().split(" ");
            for (String word : split) {
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int count = 0;
            while (values.hasNext()) {
                values.next();
                count++;
            }
            output.collect(key.trim(), count);
        }
    }
}
