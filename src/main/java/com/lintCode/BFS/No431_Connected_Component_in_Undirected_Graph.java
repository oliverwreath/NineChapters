package com.lintCode.BFS;

import com.lintCode.BinarySearch1.No437_Copy_Books;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class No431_Connected_Component_in_Undirected_Graph {
  private static final Logger logger = LoggerFactory.getLogger(No431_Connected_Component_in_Undirected_Graph.class);

  public static void main(String[] arg) {
    test();
  }

  private static void test() {
    No437_Copy_Books no437_Copy_Books = new No437_Copy_Books();
    logger.info("5 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 2));
    logger.info("4 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 3));
  }

  /**
   * @param nodes: a array of Undirected graph node
   * @return: a connected set of a Undirected graph
   */
  public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
    // write your code here
    return new LinkedList<>();
  }

  class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  }
}
