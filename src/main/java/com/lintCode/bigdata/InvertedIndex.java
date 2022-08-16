package com.lintCode.bigdata;

import java.util.*;

/**
 * Created by yanli on 9/10/2016.
 */
public class InvertedIndex {
    public static class Map {
        public void map(Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.trim().split(" ");
            HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(words));
            for (String uniqueWord : uniqueWords) {
                if (!uniqueWord.equals("")) {
                    output.collect(uniqueWord, value.id);
                }
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            LinkedList<Integer> idList = new LinkedList<Integer>();
            while (values.hasNext()) {
                idList.add(values.next());
            }
            output.collect(key, idList);
        }
    }
}
