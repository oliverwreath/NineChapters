package com.lintcode.bigdata;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 */
class OutputCollector<K, V> {

  private LinkedHashMap<K, List<V>> outputBuffer = new LinkedHashMap<K, List<V>>();

  // Adds a key/value pair to the output buffer
  public void collect(K key, V value) {
    if (outputBuffer.containsKey(key)) {
      outputBuffer.get(key).add(value);
    } else {
      LinkedList<V> list = new LinkedList<V>();
      list.add(value);
      outputBuffer.put(key, list);
    }
  }

  public LinkedHashMap<K, List<V>> getOutputBuffer() {
    return outputBuffer;
  }
}

