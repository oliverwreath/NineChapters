package com.AdvancedAlgorithms.数据结构上之并查集与字典树;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectingGraph_589 {

  private int[] father;

  /*
   * @param n: An integer
   */
  public ConnectingGraph_589(int n) {
    // do intialization if necessary
    father = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      father[i] = i;
    }
  }

  /*
   * @param a: An integer
   * @param b: An integer
   * @return: nothing
   */
  public void connect(int a, int b) {

    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) {
      father[rootA] = rootB;
    }
  }

  /*
   * @param a: An integer
   * @param b: An integer
   * @return: A boolean
   */
  public boolean query(int a, int b) {

    return find(a) == find(b);
  }

  private int find(int x) {
    if (father[x] == x) {
      return x;
    } else {
      return father[x] = find(father[x]);
    }
  }
}
