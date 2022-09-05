package com.lintcode.Advanced.SweepLine;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class NumberOfAirplanesInTheSky {
  public static void main(String[] arg) {
    new NumberOfAirplanesInTheSky().testNumberOfAirplanesInTheSky();
  }

  private void testNumberOfAirplanesInTheSky() {
    ArrayList<Interval> intervals = new ArrayList<Interval>();
    intervals.add(new Interval(1, 10));
    intervals.add(new Interval(2, 3));
    intervals.add(new Interval(5, 8));
    intervals.add(new Interval(4, 7));
    log.info("{}", countOfAirplanes(intervals));
    intervals.clear();
    intervals.add(new Interval(1, 10));
    intervals.add(new Interval(10, 20));
    intervals.add(new Interval(20, 30));
    intervals.add(new Interval(30, 40));
    log.info("{}", countOfAirplanes(intervals));
  }

  /**
   * @param intervals: An interval array
   * @return: Count of airplanes are in the sky.
   */
  public int countOfAirplanes(List<Interval> intervals) {

    if (intervals == null || intervals.size() == 0) {
      return 0;
    }

    ArrayList<Point> list = new ArrayList<Point>();
    for (Interval interval : intervals) {
      list.add(new Point(interval.start, true));
      list.add(new Point(interval.end, false));
    }

//        log.debug(list);
    Collections.sort(list, comparator);
//        log.debug(list);
    int counter = 0;
    int max = Integer.MIN_VALUE;
    for (Point point : list) {
      if (point.isStart) {
        counter++;
      } else {
        counter--;
      }
      max = Math.max(max, counter);
    }

    return max;
  }

  private Comparator<Point> comparator = new Comparator<Point>() {
    public int compare(Point o1, Point o2) {
      if (o1.x != o2.x) {
        return o1.x - o2.x;
      }
      if (!o1.isStart) {
        return -1;
      }
      if (!o2.isStart) {
        return 1;
      }
      return -1;
    }
  };

  private class Point {
    int x;
    boolean isStart;

    public Point() {
    }

    public Point(int x, boolean isStart) {
      this.x = x;
      this.isStart = isStart;
    }

    @Override
    public String toString() {
      return "Point{" +
              "x=" + x +
              ", isStart=" + isStart +
              '}';
    }
  }
}
