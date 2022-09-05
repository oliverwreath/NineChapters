package com.lintcode.Advanced.UnionFind;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Author: Oliver
 */
@Slf4j
public class FindTheWeakConnectedComponentInTheDirectedGraph {
  public static void main(String[] arg) {
    new FindTheWeakConnectedComponentInTheDirectedGraph().testNumberOfIslands();
  }

  private void testNumberOfIslands() {
//        ArrayList<DirectedGraphNode> nodes = new ArrayList<DirectedGraphNode>();
//        DirectedGraphNode node1 = new DirectedGraphNode(1);
//        DirectedGraphNode node2 = new DirectedGraphNode(2);
//        DirectedGraphNode node3 = new DirectedGraphNode(3);
//        DirectedGraphNode node4 = new DirectedGraphNode(4);
//        DirectedGraphNode node5 = new DirectedGraphNode(5);
//        DirectedGraphNode node6 = new DirectedGraphNode(6);
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

//        ArrayList<DirectedGraphNode> nodes = new ArrayList<DirectedGraphNode>();
//        DirectedGraphNode node1 = new DirectedGraphNode(1);
//        DirectedGraphNode node2 = new DirectedGraphNode(2);
//        DirectedGraphNode node3 = new DirectedGraphNode(3);
//        DirectedGraphNode node4 = new DirectedGraphNode(4);
//        DirectedGraphNode node5 = new DirectedGraphNode(5);
//        DirectedGraphNode node6 = new DirectedGraphNode(6);
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

    ArrayList<DirectedGraphNode> nodes = new ArrayList<DirectedGraphNode>();
    DirectedGraphNode node1 = new DirectedGraphNode(-3);
    DirectedGraphNode node2 = new DirectedGraphNode(-1);
    DirectedGraphNode node3 = new DirectedGraphNode(2);
    DirectedGraphNode node4 = new DirectedGraphNode(3);
    DirectedGraphNode node5 = new DirectedGraphNode(5);
    node3.neighbors.add(node4);
    node3.neighbors.add(node5);
    node4.neighbors.add(node2);
    nodes.add(node1);
    nodes.add(node2);
    nodes.add(node3);
    nodes.add(node4);
    nodes.add(node5);
    log.info("{}", connectedSet2(nodes));
  }

  /**
   * @param nodes a array of Directed graph node
   * @return a connected set of a directed graph
   */
  public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {

    if (nodes == null || nodes.size() == 0) {
      return new ArrayList<List<Integer>>();
    }

    // init UnionFindQuiz
    HashSet<Integer> set = new HashSet<Integer>();
    for (DirectedGraphNode node : nodes) {
      set.add(node.label);
      for (DirectedGraphNode neighbor : node.neighbors) {
        set.add(neighbor.label);
      }
    }
    UnionFind unionFind = new UnionFind(set);
//        log.debug(unionFind);

    // main
    for (DirectedGraphNode node : nodes) {
      for (DirectedGraphNode neighbor : node.neighbors) {
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
