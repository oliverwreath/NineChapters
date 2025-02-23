package com.lintcode.BFS;

import com.lintcode.Advanced.UnionFind.DirectedGraphNode;
import com.lintcode.BinarySearch1.No437_Copy_Books;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class No127_Topological_Sorting {

  public static void main(String[] arg) {
    test();
  }

  private static void test() {
    No437_Copy_Books no437_Copy_Books = new No437_Copy_Books();
    log.info("5 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 2));
    log.info("4 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 3));
  }

  /**
   * @param graph: A list of Directed graph node
   * @return: Any topological order for the given graph.
   */
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

    return new ArrayList<>();
  }
}
