package com.ATemplatesDataStructures.MapR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No549_TopKFrequentWordsMapReduce {

  abstract class OutputCollector<K, V> {

    public abstract void collect(K key, V value);
    // Adds a key/value pair to the output buffer
  }

  class Document {

    public int id;
    public String content;
  }

  public static class TopKFrequentWords {

    public static class Map {

      public void map(Document value,
          OutputCollector<String, Integer> output) {

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

}
