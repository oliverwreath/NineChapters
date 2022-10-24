package com.ATemplatesDataStructures.tmp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No821_TimeIntersection {

  public static void main(String[] args) {
    No821_TimeIntersection No821_TimeIntersection = new No821_TimeIntersection();
    No821_TimeIntersection.testNo821_TimeIntersection();
  }

  private void testNo821_TimeIntersection() {
    Point[] A = new Point[2];
    A[0] = new Point(1, 2);
    A[1] = new Point(5, 100);
    Point[] B = new Point[2];
    B[0] = new Point(1, 6);
    B[1] = new Point(80, 120);
    log.info("result 2 v.s. " + Arrays.toString(timeIntersection(A, B)));
  }

  public class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "{" +
          "" + x +
          ", " + y +
          '}';
    }
  }

  public Point[] timeIntersection(Point[] A, Point[] B) {

    if (A == null || A.length == 0) {
      return new Point[0];
    }

    List<Point> answer = new LinkedList<>();
    int i = 0;
    for (Point a : A) {
      if (i > B.length - 1) {
        break;
      }

      if (B[i].y < a.x) {
        while (i <= B.length - 1 && B[i].y < a.x) {
          i++;
        }
      }

      while (i <= B.length - 1 && B[i].x <= a.y) {
        answer.add(new Point(Math.max(a.x, B[i].x), Math.min(a.y, B[i].y)));
        if (B[i].y <= a.y) {
          i++;
        } else {
          break;
        }
      }
    }

    // return the final result
    return answer.toArray(new Point[answer.size()]);
  }

}
