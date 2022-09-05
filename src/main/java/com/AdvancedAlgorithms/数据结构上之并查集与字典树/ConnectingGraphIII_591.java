package com.AdvancedAlgorithms.数据结构上之并查集与字典树;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectingGraphIII_591 {
  private int[] father;
  private int count;

  /**
   * @param n
   */
  public ConnectingGraphIII_591(int n) {
    // do intialization if necessary
    father = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      father[i] = i;
    }
    count = n;
  }

  /**
   * @param a
   * @param b
   */
  public void connect(int a, int b) {

    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) {
      father[rootA] = rootB;
      count--;
    }
  }

  /**
   * @return: An integer
   */
  public int query() {

    return count;
  }

  private int find(int x) {
    if (father[x] == x) {
      return x;
    } else {
      return father[x] = find(father[x]);
    }
  }
}
