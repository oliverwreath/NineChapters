package com.lintCode.bigdata;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 * public void collect(K key, V value);
 * // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 * public int id;
 * public String content;
 * }
 */
public class TopKFrequentWords {
    private final static Logger logger = LoggerFactory.getLogger(TopKFrequentWords.class);

    public static void main(String[] args) {
//        int k = 2;
//        Document[] docs = new Document[]{
//                new Document(1, "lintcode is the best online judge I love lintcode"),
//                new Document(2, "lintcode is an online judge for coding interview you can test your code online at lintcode")
//        };
        int k = 3;
        Document[] docs = new Document[]{
                new Document(1, "This is  the content of document1"),
                new Document(2, "This is the       content of document3")
        };

        Map map = new Map();
        OutputCollector<String, Integer> output = new OutputCollector<String, Integer>();
        for (Document doc : docs) {
            map.map("", doc, output);
        }
        java.util.Map<String, List<Integer>> outputBuffer = output.getOutputBuffer();
        Set<String> keys = outputBuffer.keySet();

        Reduce reduce = new Reduce();
        reduce.setup(k);
        for (String key : keys) {
            reduce.reduce(key, outputBuffer.get(key).iterator());
        }
        OutputCollector<String, Integer> reduceOutput = new OutputCollector<String, Integer>();
        reduce.cleanup(reduceOutput);
        LinkedHashMap<String, List<Integer>> reduceOutputBuffer = reduceOutput.getOutputBuffer();
        System.out.println(reduceOutputBuffer);
//        2
//                [{"id":1,"content":"lintcode is the best online judge I love lintcode"}, {"id":2,"content":"lintcode is an online judge for coding interview you can test your code online at lintcode"}]
    }

    public static class Map {
        public void map(String _, Document value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] strings = value.content.split(" ");
            for (String string : strings) {
                if (string != null && !string.isEmpty() && !string.equals(" ")) {
                    output.collect(string, 1);
                }
            }
        }
    }

    private static Comparator<Pair> comparator = new Comparator<Pair>() {
        public int compare(Pair o1, Pair o2) {
            return o2.value - o1.value;
        }
    };

    public static class Reduce {
        PriorityQueue<Pair> queue;
        private static int k;

        public void setup(int k) {
            // initialize your data structure here
            queue = new PriorityQueue<Pair>(k, comparator);
            this.k = k;
        }

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            long times = 0;
            while (values.hasNext()) {
                times += values.next();
            }
            queue.add(new Pair(key, (int) times));
//            while (queue.size() > k) {
//                queue.poll();
//            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            int counter = 0;
            while (counter < k && queue.size() > 0) {
                Pair pair = queue.poll();
                output.collect(pair.key, pair.value);
                counter++;
            }
        }
    }

    public static class Pair {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
