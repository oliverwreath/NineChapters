package com.leetcode.Weekly_123;

import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. TIME: O(?) SPACE: O(?)
 */
@Slf4j
public class LC990SatisfiabilityOfEqualityEquations {

  public boolean equationsPossible(String[] equations) {
    if (equations == null || equations.length == 0) {
      return true;
    }

    // dp logic
    LinkedList<Integer> listOfNotEquals = new LinkedList<>();
    UnionFind unionFind = new UnionFind();
    for (int i = 0; i < equations.length; i++) {
      String equation = equations[i];
      if (equation.charAt(0) == equation.charAt(3)) {
        if (equation.charAt(1) == '!') {
          return false;
        }
      } else {
        if (equation.charAt(1) == '!') {
          listOfNotEquals.add(i);
        } else {
          unionFind.union(equation.charAt(0), equation.charAt(3));
        }
      }
    }

    for (Integer i : listOfNotEquals) {
      String equation = equations[i];
      if (unionFind.hasSameAncestor(equation.charAt(0), equation.charAt(3))) {
        return false;
      }
    }

    return true;
  }

  private class UnionFind {

    int[] parent;

    public UnionFind() {
      this.parent = new int[27];
      for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
      }
    }

    public void union(char a, char b) {
      int kid1 = a - 'a';
      int kid2 = b - 'a';
      int rootA = find(kid1);
      int rootB = find(kid2);
      if (rootA != rootB) {
        parent[rootA] = rootB;
      }
    }

    public int find(int originalKid) {
      int ancestor = originalKid;
      while (parent[ancestor] != ancestor) {
        ancestor = parent[ancestor];
      }
      parent[originalKid] = ancestor;
      return ancestor;
    }

    public char find(char c) {
      int originalKid = c - 'a';
      int current = originalKid;
      while (parent[current] != current) {
        current = parent[current];
      }
      parent[originalKid] = current;
      return (char) (current + 'a');
    }

    public boolean hasSameAncestor(char a, char b) {
      int kid1 = a - 'a';
      int kid2 = b - 'a';
      return find(kid1) == find(kid2);
    }
  }
}
