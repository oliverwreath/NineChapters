package com.ATemplatesDataStructures.FollowUp7.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No90_kSumII {

  public static void main(String[] args) {
    No90_kSumII No90_kSumII = new No90_kSumII();
    No90_kSumII.testNo90_kSumII();
  }

  private void testNo90_kSumII() {
    log.info("result [[1,4],[2,3]] v.s. " + kSumII(new int[]{1, 2, 3, 4}, 2, 5));
    log.info("result [[4]] v.s. " + kSumII(new int[]{1, 2, 3, 4}, 1, 4));
  }

  public List<List<Integer>> kSumII(int[] A, int K, int target) {
    // filter abnormal cases
    answer = new ArrayList<>();
    if (A == null || A.length == 0) {
      return answer;
    }

    Arrays.sort(A);
    this.combinations = new ArrayList<>();
    this.A = A;
    dfs(K, target, 0);

    // return the final result
    return answer;
  }

  List<List<Integer>> answer;
  List<Integer> combinations;
  int A[];

  public void dfs(int K, int target, int start) {
    if (K == 0 && target == 0) {
      answer.add(new ArrayList<>(combinations));
      return;
    }
    if (K < 0 || target < 0 || start > A.length - 1) {
      return;
    }

    for (int i = start; i < A.length && target >= A[i]; i++) {
      combinations.add(A[i]);
      dfs(K - 1, target - A[i], i + 1);
      combinations.remove(combinations.size() - 1);
    }
//        dfs(K, target, start - 1);
//        combinations.add(A[start]);
//        dfs(K - 1, target - A[start], start - 1);
//        combinations.remove(combinations.size() - 1);

//        if (K == 0 && target == 0) {
//            answer.add(new ArrayList<>(combinations));
//            return;
//        }
//        if (K < 0 || target < 0 || index < 0) {
//            return;
//        }
//
//        dfs(K, target, index - 1);
//        combinations.add(A[index]);
//        dfs(K - 1, target - A[index], index - 1);
//        combinations.remove(combinations.size() - 1);
  }

//    public void dfs(int A[], int K, int target, int index, List<Integer> tans) {
//        if (K == 0 && target == 0) {
//            answer.add(new ArrayList<>(tans));
//            return;
//        }
//        if (K < 0 || target < 0 || index < 0)
//            return;
//        dfs(A, K, target, index - 1, tans);
//        tans.add(A[index]);
//        dfs(A, K - 1, target - A[index], index - 1, tans);
//        tans.remove(tans.size() - 1);
//    }

}
