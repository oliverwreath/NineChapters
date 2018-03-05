package com.ATemplates_DataStructures.MapR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class No503_AnagramMapReduce {
    private final static Logger logger = LoggerFactory.getLogger(No503_AnagramMapReduce.class);

    public static void main(String[] args) {
        No503_AnagramMapReduce No503_AnagramMapReduce = new No503_AnagramMapReduce();
        No503_AnagramMapReduce.testNo503_AnagramMapReduce();
    }

    private void testNo503_AnagramMapReduce() {
//        MyLogger.info("result 2 v.s. " + functionName("12"));
    }

    class OutputCollector<K, V> {
        public void collect(K key, V value);
        // Adds a key/value pair to the output buffer
    }

    public class Anagram {
        public static class Map {
            public void map(String key, String value,
                            OutputCollector<String, String> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, String value);
                String[] words = value.split(" ", -1);
                for (String word : words) {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    output.collect(new String(chars), word);
                }
            }
        }

        public static class Reduce {
            public void reduce(String key, Iterator<String> values,
                               OutputCollector<String, List<String>> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, List<String> value);
                ArrayList<String> list = new ArrayList<>();
                while (values.hasNext()) {
                    list.add(values.next());
                }
                output.collect(key, list);
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
