package com.ATemplatesDataStructures.FollowUp7.DFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No808_MovieNetwork {

  public static void main(String[] args) {
    No808_MovieNetwork No808_MovieNetwork = new No808_MovieNetwork();
    No808_MovieNetwork.testNo808_MovieNetwork();
  }

  private void testNo808_MovieNetwork() {
    log.info("result 2 v.s. " + Arrays.toString(topKMovie(
        new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90},
        new int[][]{
            {1, 4, 5},
            {0, 2, 3},
            {1, 7},
            {1, 6, 7},
            {0},
            {0},
            {3},
            {2, 3},
            {}
        }, 5, 3)));
  }

  int[] topKMovie(int[] rating, int[][] G, int S, int K) {
    // filter abnormal cases
    this.G = G;
    this.rating = rating;
    this.visited = new HashSet<>();
    dfs(S);
    visited.remove(S);
    log.debug("visited = " + visited);
    // return the final result
    return topK(K);
  }

  int[][] G;
  int[] rating;
  HashSet<Integer> visited;

  void bfs(int S) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(S);
    while (!queue.isEmpty()) {
      int id = queue.poll();
      if (!visited.contains(id)) {
        visited.add(id);
        for (int next : G[id]) {
          queue.add(next);
        }
      }
    }
  }

  void dfs(int S) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.add(S);
    while (!stack.isEmpty()) {
      int id = stack.pop();
      if (!visited.contains(id)) {
        visited.add(id);
        for (int next : G[id]) {
          stack.add(next);
        }
      }
    }
  }

  class Movie {

    int id;
    int rating;

    public Movie(int id, int rating) {
      this.id = id;
      this.rating = rating;
    }

    @Override
    public String toString() {
      return "Movie{" +
          "id=" + id +
          ", rating=" + rating +
          '}';
    }
  }

  int[] topK(int K) {
    int[] answer = new int[K];
    PriorityQueue<Movie> pq = new PriorityQueue<>(K, ((o1, o2) -> o1.rating - o2.rating));
    int count = 0;
    for (Integer id : visited) {
      if (count < K) {
        pq.add(new Movie(id, rating[id]));
        count++;
      } else {
        if (rating[id] > pq.peek().rating) {
          pq.poll();
          pq.add(new Movie(id, rating[id]));
        }
      }
    }
    for (int i = 0; i < K; i++) {
      answer[i] = pq.poll().id;
    }

    return answer;
//        int[] answer = new int[K];
//        PriorityQueue<Movie> pq = new PriorityQueue<>(K, ((o1, o2) -> o2.rating - o1.rating));
//        for (Integer id : visited) {
//            pq.add(new Movie(id, rating[id]));
//        }
//        for (int i = 0; i < K; i++) {
//            answer[i] = pq.poll().id;
//        }
//        return answer;
  }

}
