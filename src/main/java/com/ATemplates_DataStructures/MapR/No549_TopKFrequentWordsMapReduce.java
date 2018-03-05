package com.ATemplates_DataStructures.MapR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class No549_TopKFrequentWordsMapReduce {
    private final static Logger logger = LoggerFactory.getLogger(No549_TopKFrequentWordsMapReduce.class);

    public static void main(String[] args) {
        No549_TopKFrequentWordsMapReduce No549_TopKFrequentWordsMapReduce = new No549_TopKFrequentWordsMapReduce();
        No549_TopKFrequentWordsMapReduce.testNo549_TopKFrequentWordsMapReduce();
    }

    private void testNo549_TopKFrequentWordsMapReduce() {
//        MyLogger.info("result 2 v.s. " + functionName("12"));
    }

    class OutputCollector<K, V> {
        public void collect(K key, V value);
        // Adds a key/value pair to the output buffer
    }

    class Document {
        public int id;
        public String content;
    }

    public class TopKFrequentWords {
        public static class Map {
            public void map(String _, Document value,
                            OutputCollector<String, Integer> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
                String[] words = value.content.split(" ", -1);
                for (String word : words) {
                    if (word != null && !word.isEmpty()) {
                        output.collect(word, 1);
                    }
                }
            }
        }

        public static class Reduce {
            class Pair implements Comparable {
                public String key;
                public int value;

                public Pair(String key, int value) {
                    this.key = key;
                    this.value = value;
                }

                @Override
                public int compareTo(Object o) {
                    if (o == null || !(o instanceof Pair)) {
                        return 1;
                    }
                    Pair right = (Pair) o;
                    if (this.value != right.value) {
                        return this.value - right.value;
                    } else {
                        return right.key.compareTo(this.key);
                    }
                }
            }

            int k;
            PriorityQueue<Pair> pr = new PriorityQueue<>();

            public void setup(int k) {
                // initialize your data structure here
                this.k = k;
            }

            public void reduce(String key, Iterator<Integer> values) {
                // Write your code here
                int sum = 0;
                while (values.hasNext()) {
                    sum += values.next();
                }

                Pair pair = new Pair(key, sum);
                if (pr.size() == this.k) {
                    if (pair.compareTo(pr.peek()) > 0) {
                        pr.poll();
                        pr.add(pair);
                    }
                } else {
                    pr.add(pair);
                }
            }

            public void cleanup(OutputCollector<String, Integer> output) {
                // Output the top k pairs <word, times> into output buffer.
                // Ps. output.collect(String key, Integer value);
                ArrayList<Pair> pairs = new ArrayList<>(pr.size());
                while (!pr.isEmpty()) {
                    pairs.add(pr.poll());
                }
                for (int i = pairs.size() - 1; i >= 0; i--) {
                    output.collect(pairs.get(i).key, pairs.get(i).value);
                }
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
