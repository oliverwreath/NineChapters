package com.lintcode.Advanced.SweepLine;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Interval {
  int start, end;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Interval{" +
            "start=" + start +
            ", end=" + end +
            '}';
  }
}
