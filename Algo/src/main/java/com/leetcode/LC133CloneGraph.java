package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC133CloneGraph {

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;

    return dfs(node, new HashMap<>());
  }

  private Node dfs(Node node, Map<Integer, Node> map) {
    if (map.containsKey(node.val))
      return map.get(node.val);

    Node copy = new Node(node.val);
    map.put(node.val, copy);
    for (Node next : node.neighbors) {
      copy.neighbors.add(dfs(next, map));
    }
    return copy;
  }

  public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }

    @Override public String toString() {
      return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
          .add("val=" + val)
          .add("neighbors=" + neighbors)
          .toString();
    }

    @Override public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Node node = (Node) o;
      return val == node.val && Objects.equals(neighbors, node.neighbors);
    }

    @Override public int hashCode() {
      return Objects.hash(val, neighbors);
    }
  }
}
