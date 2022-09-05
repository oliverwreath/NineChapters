package com.ATemplatesDataStructures.MapR;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class No503_AnagramMapReduce {
  abstract class OutputCollector<K, V> {
    public abstract void collect(K key, V value);
    // Adds a key/value pair to the output buffer
  }

  public static class Anagram {
    public static class Map {
      public void map(String key, String value,
                      OutputCollector<String, String> output) {
    
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

}
