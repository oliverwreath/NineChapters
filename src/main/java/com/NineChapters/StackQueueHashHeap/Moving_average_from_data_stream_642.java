package com.NineChapters.StackQueueHashHeap;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class Moving_average_from_data_stream_642 {
  public static void main(String[] args) {
    testMoving_average_from_data_stream_642();
  }

  private static void testMoving_average_from_data_stream_642() {
    MovingAverage m = new MovingAverage(3);
    log.info("result 1 v.s. {}", m.next(1));
    log.info("result 5.5 v.s. {}", m.next(10));
    log.info("result 4.66667 v.s. {}", m.next(3));
    log.info("result 6 v.s. {}", m.next(5));
  }

  public static class MovingAverage {
    private static Queue<Integer> queue;
    private int targetSize;
    private long sum;

    /*
     * @param size: An integer
     */
    public MovingAverage(int size) {
      // do intialization if necessary
      queue = new LinkedList<Integer>();
      this.targetSize = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
  
      if (queue.size() >= targetSize) {
        sum -= queue.poll();
      }
      queue.offer(val);
      sum += val;
      return sum / (double) queue.size();
    }
  }

}
