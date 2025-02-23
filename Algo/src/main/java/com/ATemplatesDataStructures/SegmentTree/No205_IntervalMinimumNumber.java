package com.ATemplatesDataStructures.SegmentTree;

import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No205_IntervalMinimumNumber {

  public static void main(String[] args) {
    testNo205_IntervalMinimumNumber();
  }

  private static void testNo205_IntervalMinimumNumber() {
    No205_IntervalMinimumNumber No205_IntervalMinimumNumber = new No205_IntervalMinimumNumber();
//        log.info("result 2 v.s. " + No205_IntervalMinimumNumber.longestIncreasingContinuousSubsequence("12"));
//        log.info("result 1 v.s. " + No205_IntervalMinimumNumber.longestIncreasingContinuousSubsequence("10"));
  }

  public class Interval {

    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {

    root = build(0, A.length - 1, A);
    LinkedList<Integer> answer = new LinkedList<>();
    for (Interval interval : queries) {
      answer.add((int) query(root, interval.start, interval.end));
    }
    return answer;
  }

  SegmentTreeNode root;

  class SegmentTreeNode {

    int start, end;
    long min;
    SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end, int min) {
      this.start = start;
      this.end = end;
      this.min = min;
      this.left = this.right = null;
    }
  }

  public SegmentTreeNode build(int start, int end, int[] A) {
    if (start > end) {
      return null;
    }
    SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
    if (start == end) {
      return root;
    }
    int mid = (root.start + root.end) / 2;
    root.left = build(start, mid, A);
    root.right = build(mid + 1, end, A);
    root.min = Math.min(root.left.min, root.right.min);
    return root;
  }

  public long query(SegmentTreeNode root, int start, int end) {
    if (start <= root.start && root.end <= end) {
      return root.min;
    }
    int mid = (root.start + root.end) / 2;
    long answer = Integer.MAX_VALUE;
    if (start <= mid) {
      answer = Math.min(answer, query(root.left, start, end));
    }
    if (mid + 1 <= end) {
      answer = Math.min(answer, query(root.right, start, end));
    }
    return answer;
  }

  public void modify(SegmentTreeNode root, int index, int value) {
    if (root.start == root.end && root.start == index) {
      root.min = value;
      return;
    }
    int mid = (root.start + root.end) / 2;
    if (index <= mid) {
      modify(root.left, index, value);
    } else {
      modify(root.right, index, value);
    }
    root.min = Math.min(root.left.min, root.right.min);
  }

}
