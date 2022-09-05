package com.lintcode.bigdata;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

/**
 * Author: Oliver
 */
@Slf4j
public class NGram {
  public static class Map {
    public void map(int n, String str,
                    OutputCollector<String, Integer> output) {
  
      // Output the results into output buffer.
      // Ps. output.collect(String key, Integer value);
      int len = str.length();
      for (int i = 0; i < len - 2; i++) {
        output.collect(str.substring(i, i + 3), 1);
      }
    }
  }

  public static class Reduce {
    public void reduce(String key, Iterator<Integer> values,
                       OutputCollector<String, Integer> output) {
  
      // Output the results into output buffer.
      // Ps. output.collect(String key, int value);
      int counter = 0;
      while (values.hasNext()) {
        values.next();
        counter++;
      }
      output.collect(key, counter);
    }
  }
}
