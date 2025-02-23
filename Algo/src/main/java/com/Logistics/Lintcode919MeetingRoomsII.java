package com.Logistics;

import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. TIME: O(?) SPACE: O(?)
 */
@Slf4j
public class Lintcode919MeetingRoomsII {

  public static void main(String[] args) {
    Lintcode919MeetingRoomsII thisClass = new Lintcode919MeetingRoomsII();
    thisClass.testNeedNumberOfTrucks();
  }

  private void testNeedNumberOfTrucks() {
//        log.info("result {} v.s. {}", "0", minMeetingRooms(Collections.EMPTY_LIST));
//        List<Interval> list = new LinkedList<>();
//        list.add(new Interval(0, 30));
//        list.add(new Interval(5, 10));
//        list.add(new Interval(15, 20));
//        log.info("result {} v.s. {}", "2", minMeetingRooms(list));
//        list.add(new Interval(8, 12));
//        log.info("result {} v.s. {}", "3", minMeetingRooms(list));
  }

  /**
   * Oliver solution: 1. Break it down into starting and ending points. 2. Just sweep, sweep, sweep. 3. for O(1) lookup
   * - Optionally caching the results into a 5 min- interval array of boolean(table taken) OR int(num of tables taken).
   *
   * @param intervals
   * @return
   */
  public int minTablesRequired(List<Interval> intervals) {
    // filter abnormal cases
    if (intervals == null || intervals.isEmpty()) {
      return 0;
    }

    // Oliver main logic: 1. break intervals down into points. 2. O(n) sweeping from left to right
    List<Point> list = new LinkedList<>();
    for (Interval interval : intervals) {
      list.add(new Point(interval.start, (short) 1));
      list.add(new Point(interval.end, (short) -1));
    }
    list.sort((o1, o2) -> (o1.time == o2.time) ? o1.flag - o2.flag : o1.time - o2.time);

    int max = 0;
    int current = 0;
    for (Point point : list) {
      current += point.flag;
      max = Math.max(max, current);
    }

    // return the max number of taken tables.
    return max;
  }

  private class Point {

    int time;
    short flag;

    public Point(int time, short flag) {
      this.time = time;
      this.flag = flag;
    }

    @Override
    public String toString() {
      return "Point{" +
          "time=" + time +
          ", flag=" + flag +
          '}';
    }
  }

  private class Interval {

    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}
