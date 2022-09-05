package com.lintcode.Advanced.UnionFind;

import java.util.ArrayList;

/**
 * Author: Oliver
 */
public class DirectedGraphNode {
  int label;
  ArrayList<DirectedGraphNode> neighbors;

  DirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<>();
  }
}
