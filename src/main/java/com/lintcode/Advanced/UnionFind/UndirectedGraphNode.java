package com.lintcode.Advanced.UnionFind;

import java.util.ArrayList;

/**
 * Author: Oliver
 */
public class UndirectedGraphNode {

  int label;
  ArrayList<UndirectedGraphNode> neighbors;

  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<>();
  }
}
