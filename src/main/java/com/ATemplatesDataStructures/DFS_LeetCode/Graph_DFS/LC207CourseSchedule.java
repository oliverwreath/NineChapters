package com.ATemplatesDataStructures.DFS_LeetCode.Graph_DFS;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Approach 2: Postorder DFS (Depth-First Search)
 */
@Slf4j
public class LC207CourseSchedule {
  public boolean canFinish(int numCourses, int[][] pre) {
    if (pre == null || pre.length == 0)
      return true;

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] pair : pre) {
      map.computeIfAbsent(pair[0], v -> new ArrayList<>());
      map.get(pair[0]).add(pair[1]);
    }

    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, map, visited))
        return false;
    }
    return true;
  }

  private boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visited) {
    if (!map.containsKey(course) || map.get(course).isEmpty())
      return true;
    if (visited.contains(course))
      return false;

    visited.add(course);
    for (int pre : map.get(course)) {
      if (!dfs(pre, map, visited))
        return false;
    }
    map.remove(course);

    return true;
  }
}
