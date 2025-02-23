package com.lintcode.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class No974_01_Matrix {

  public static void main(String[] arg) {
    No974_01_Matrix tester = new No974_01_Matrix();
    tester.test();
  }

  private void test() {
    int[][] ints1 = updateMatrix(new int[][]{
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    });
    for (int[] anInt : ints1) {
      log.info("{}", anInt);
    }
    log.info("");
    int[][] ints = updateMatrix(new int[][]{
        {0, 1, 0, 1, 1},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {1, 0, 0, 0, 1}
    });
    for (int[] anInt : ints) {
      log.info("{}", anInt);
    }
  }

  /**
   * @param matrix: a 0-1 matrix
   * @return: return a matrix
   */
  public int[][] updateMatrix(int[][] matrix) {

    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return new int[0][0];
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int[][] bfs = new int[m][n];
    for (int[] bf : bfs) {
      Arrays.fill(bf, -1);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          bfs[i][j] = 0;
        } else {
          bfs[i][j] = bfs(bfs, matrix, i, j);
        }
      }
    }

    return bfs;
  }

  private int bfs(int[][] bfs, int[][] matrix, int i, int j) {
    Queue<Node> queue = new ArrayDeque<>();
    Map<Node, Integer> distance = new HashMap<>();
    Node startNode = new Node(i, j);
    queue.offer(startNode);
    distance.put(startNode, 0);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (matrix[node.x][node.y] == 0) {
        return distance.get(node);
      }
      for (Node neighbour : node.getNeighbours(matrix)) {
        if (distance.containsKey(neighbour)) {
          continue;
        }
        queue.offer(neighbour);
        distance.put(neighbour, distance.get(node) + 1);
      }
    }

    return -1;
  }

  private class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public List<Node> getNeighbours(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;

      List<Node> list = new LinkedList<>();
      int[][] diff = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      for (int[] ints : diff) {
        int i = x + ints[0], j = y + ints[1];
        if (i >= 0 && i < m && j >= 0 && j < n) {
          list.add(new Node(i, j));
        }
      }
      return list;
    }
  }
}
