package com.LintCodeContest.Weekly9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No897_IslandCity {

  public static void main(String[] args) {
    No897_IslandCity No897_IslandCity = new No897_IslandCity();
    No897_IslandCity.testNo897_IslandCity();
  }

  private void testNo897_IslandCity() {
    log.info("result 0 v.s. " + numIslandCities(new int[][]{
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1}
    }));
    log.info("result 2 v.s. " + numIslandCities(new int[][]{
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 0, 2, 1, 2},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2}
    }));
  }

  int numIslandCities(int[][] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    this.m = A.length;
    this.n = A[0].length;
    this.A = A;
    this.visited = new boolean[m][n];
    int counter = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 2 && !visited[i][j]) {
          dfs(i, j);
          counter++;
        }
      }
    }

    // return the final result
    return counter;
  }

  int[][] A;
  boolean[][] visited;
  int m;
  int n;

  private void dfs(int i, int j) {
    if (i < 0 || j < 0 || i >= m || j >= n) {
      return;
    }
    if (A[i][j] == 0) {
      return;
    }
    if (visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    A[i][j] = 2;
    dfs(i - 1, j);
    dfs(i + 1, j);
    dfs(i, j - 1);
    dfs(i, j + 1);
  }

}
