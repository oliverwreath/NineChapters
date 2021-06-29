package com.ATemplates_DataStructures.MapR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class No499_WordCountMapReduce {
    private final static Logger logger = LoggerFactory.getLogger(No499_WordCountMapReduce.class);

    public static void main(String[] args) {
        No499_WordCountMapReduce No499_WordCountMapReduce = new No499_WordCountMapReduce();
        No499_WordCountMapReduce.testNo499_WordCountMapReduce();
    }

    private void testNo499_WordCountMapReduce() {
//        MyLogger.info("result 2 v.s. " + functionName("12"));
    }

    abstract class OutputCollector<K, V> {
        public abstract void collect(K key, V value);
        // Adds a key/value pair to the output buffer
    }

    public static class WordCount {
        public static class Map {
            public void map(String key, String value, OutputCollector<String, Integer> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
                String[] words = value.split(" ", -1);
                for (String word : words) {
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
                    count += values.next();
                }
                output.collect(key, count);
            }
        }
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
