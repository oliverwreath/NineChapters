package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author: Oliver
 */
@Slf4j
public class LRUCache {
  private static List<Integer> list;
  private static Map<Integer, Integer> map;
  private static int capacity;

  // @param capacity, an integer
  public LRUCache(int capacity) {

    LRUCache.capacity = capacity;
    list = new LinkedList<Integer>();
    map = new HashMap<Integer, Integer>();
  }

  // @return an integer
  static int get(int key) {

    if (!map.containsKey(key)) {
      return -1;
    }

    moveToTail(list, key);
    return map.get(key);
  }

  // @param key, an integer
  // @param value, an integer
  // @return nothing
  static void set(int key, int value) {

    if (map.containsKey(key)) {
      moveToTail(list, key);
    } else {
      if (list.size() >= capacity) {
//                log.debug("remove = " + list.get(0));
        map.remove(list.get(0));
        list.remove(0);
      }
      list.add(key);
    }
    map.put(key, value);
  }

  static void moveToTail(List<Integer> list, Integer key) {
    if (list == null || list.size() == 0) {
      return;
    }

    list.remove(key);
    list.add(key);
    return;
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.set(2, 1);
    lruCache.set(1, 1);
    log.debug("{}", lruCache.get(2));
    lruCache.set(4, 1);
    log.debug("{}", lruCache.get(1));
    log.debug("{}", lruCache.get(2));
  }
}
