package com.lintcode.Advanced.UnionFind;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: Oliver
 */
@Slf4j
public class UnionFind {
  HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

  public UnionFind() {
  }

  public UnionFind(HashSet<Integer> set) {
    for (Integer current : set) {
      father.put(current, current);
    }
  }

  public UnionFind(int n) {
    for (int i = 1; i <= n; i++) {
      father.put(i, i);
    }
  }

  public UnionFind(int n, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int id = convert2Id(i, j, m);
        father.put(id, id);
      }
    }
  }

  public int compressed_find(int key) {
    // find
    int parent = father.get(key);
    while (parent != father.get(parent)) {
      parent = father.get(parent);
    }

    // compress
    int fa = key;
    while (fa != father.get(fa)) {
      int temp = father.get(fa);
      father.put(fa, parent);
      fa = temp;
    }
    return parent;
  }

  public boolean union(int key, int keyBigger) {
    int boss = compressed_find(key);
    int bossBigger = compressed_find(keyBigger);
    if (boss != bossBigger) {
      father.put(boss, bossBigger);
      return true;
    }

    return false;
  }

  private int convert2Id(int x, int y, int m) {
    return x * m + y;
  }

  @Override
  public String toString() {
    return "UnionFindQuiz{" +
            "father=" + father +
            '}';
  }
}
