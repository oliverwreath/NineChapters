package com.ATemplatesDataStructures.MapR;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class No504_InvertedIndexMapReduce {
  abstract class OutputCollector<K, V> {
    public abstract void collect(K key, V value);
    // Adds a key/value pair to the output buffer
  }

  class Document {
    public int id;
    public String content;
  }

  public static class InvertedIndex {
    public static class Map {
      public void map(Document value,
                      OutputCollector<String, Integer> output) {
    
        // Output the results into output buffer.
        // Ps. output.collect(String key, int value);
        String[] words = value.content.split(" ", -1);
        for (String word : words) {
          if (word != null && !word.isEmpty()) {
            output.collect(word, value.id);
          }
        }
      }
    }

    public static class Reduce {
      public void reduce(String key, Iterator<Integer> values,
                         OutputCollector<String, List<Integer>> output) {
    
        // Output the results into output buffer.
        // Ps. output.collect(String key, List<Integer> value);
        HashSet<Integer> ids = new HashSet<>();
        while (values.hasNext()) {
          ids.add(values.next());
        }
        output.collect(key, new ArrayList<>(ids));
      }
    }
  }

}
