package com.lintCode.BFS;

import com.lintCode.BinarySearch1.No437_Copy_Books;
import com.lintCode.BinarySearch1.No460_KClosestNumbers;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class No127_Topological_Sorting {
  private static final Logger logger = LoggerFactory.getLogger(No127_Topological_Sorting.class);

  public static void main(String[] arg) {
    test();
  }

  private static void test() {
    No437_Copy_Books no437_Copy_Books = new No437_Copy_Books();
    logger.info("5 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 2));
    logger.info("4 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 3));
  }

  /**
   * @param graph: A list of Directed graph node
   * @return: Any topological order for the given graph.
   */
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    // write your code here
    return new ArrayList<>();
  }

  class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<DirectedGraphNode>();
    }
  }
}
