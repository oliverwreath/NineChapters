package com.NineChapters.StackQueueHashHeap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class Moving_average_from_data_stream_642 {
    private final static Logger logger = LoggerFactory.getLogger(Moving_average_from_data_stream_642.class);

    public static void main(String[] args) {
        testMoving_average_from_data_stream_642();
    }

    private static void testMoving_average_from_data_stream_642() {
        MovingAverage m = new MovingAverage(3);
        logger.info("result 1 v.s. {}", m.next(1));
        logger.info("result 5.5 v.s. {}", m.next(10));
        logger.info("result 4.66667 v.s. {}", m.next(3));
        logger.info("result 6 v.s. {}", m.next(5));
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
            // write your code here
            if (queue.size() >= targetSize) {
                sum -= queue.poll();
            }
            queue.offer(val);
            sum += val;
            return sum / (double) queue.size();
        }
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }
    }
}
