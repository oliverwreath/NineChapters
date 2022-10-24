package com.lintcode.BFS;

import com.lintcode.Advanced.UnionFind.UndirectedGraphNode;
import com.lintcode.BinarySearch1.No437_Copy_Books;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class No431_Connected_Component_in_Undirected_Graph {

  public static void main(String[] arg) {
    test();
  }

  private static void test() {
    No437_Copy_Books no437_Copy_Books = new No437_Copy_Books();
    log.info("5 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 2));
    log.info("4 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 3));
  }

  /**
   * @param nodes: a array of Undirected graph node
   * @return: a connected set of a Undirected graph
   */
  public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {

    return new LinkedList<>();
  }
}
