package com.lintCode.Advanced.SweepLine;

/**
 * Created by yanli on 2016-10-15.
 */
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