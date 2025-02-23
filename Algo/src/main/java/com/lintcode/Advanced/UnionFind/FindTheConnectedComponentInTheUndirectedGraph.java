package com.lintcode.Advanced.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class FindTheConnectedComponentInTheUndirectedGraph {

  public static void main(String[] arg) {
    new FindTheConnectedComponentInTheUndirectedGraph().testNumberOfIslands();
  }

  private void testNumberOfIslands() {
//        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
//        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
//        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
//        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
//        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
//        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
//        UndirectedGraphNode node6 = new UndirectedGraphNode(6);
//        node1.neighbors.add(node2);
//        node1.neighbors.add(node3);
//        node2.neighbors.add(node3);
//        node4.neighbors.add(node6);
//        node5.neighbors.add(node6);
//        nodes.add(node1);
//        nodes.add(node2);
//        nodes.add(node3);
//        nodes.add(node4);
//        nodes.add(node5);
//        nodes.add(node6);
//        log.info("{}", connectedSet2(nodes));

//        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
//        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
//        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
//        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
//        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
//        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
//        UndirectedGraphNode node6 = new UndirectedGraphNode(6);
//        node4.neighbors.add(node2);
//        node4.neighbors.add(node3);
//        node4.neighbors.add(node5);
//        node5.neighbors.add(node4);
//        node5.neighbors.add(node6);
//        nodes.add(node1);
//        nodes.add(node2);
//        nodes.add(node3);
//        nodes.add(node4);
//        nodes.add(node5);
//        nodes.add(node6);
//        log.info("{}", connectedSet2(nodes));

    ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
    UndirectedGraphNode node1 = new UndirectedGraphNode(-3);
    UndirectedGraphNode node2 = new UndirectedGraphNode(-1);
    UndirectedGraphNode node3 = new UndirectedGraphNode(2);
    UndirectedGraphNode node4 = new UndirectedGraphNode(3);
    UndirectedGraphNode node5 = new UndirectedGraphNode(5);
    node3.neighbors.add(node4);
    node3.neighbors.add(node5);
    node4.neighbors.add(node2);
    nodes.add(node1);
    nodes.add(node2);
    nodes.add(node3);
    nodes.add(node4);
    nodes.add(node5);
    log.info("{}", connectedSet(nodes));
  }

  /**
   * @param nodes a array of Undirected graph node
   * @return a connected set of a Undirected graph
   */
  public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {

    if (nodes == null || nodes.size() == 0) {
      return new ArrayList<List<Integer>>();
    }

    // init UnionFindQuiz
    HashSet<Integer> set = new HashSet<Integer>();
    for (UndirectedGraphNode node : nodes) {
      set.add(node.label);
      for (UndirectedGraphNode neighbor : node.neighbors) {
        set.add(neighbor.label);
      }
    }
    UnionFind unionFind = new UnionFind(set);
//        log.debug(unionFind);

    // main
    for (UndirectedGraphNode node : nodes) {
      for (UndirectedGraphNode neighbor : node.neighbors) {
//                log.debug("node.label = " + node.label + "; neighbor.label = " + neighbor.label);
        unionFind.union(node.label, neighbor.label);
//                log.debug(unionFind);
      }
    }

    // get answer
    Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    for (Integer label : set) {
      int bigBrother = unionFind.compressed_find(label);
//            log.debug("bigBrother = " + bigBrother);
      if (!map.containsKey(bigBrother)) {
        map.put(bigBrother, new ArrayList<Integer>());
      }
      map.get(bigBrother).add(label);
    }

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        log.debug("map.keySet() = " + map.keySet());
    for (ArrayList<Integer> currentList : map.values()) {
      Collections.sort(currentList);
      ans.add(currentList);
    }
    return ans;
  }
}
