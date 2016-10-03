package com.lintCode.Advanced.Heap.HashHeap;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-02.
 */
public class BuildingOutline {
    private final static Logger logger = LoggerFactory.getLogger(BuildingOutline.class);

    public static void main(String[] arg) {
        testBuildingOutline();
    }

    private static void testBuildingOutline() {
        logger.info("{}", buildingOutline(new int[][]{{1, 3, 3},
                {2, 4, 4},
                {5, 6, 1}}));
        logger.info("{}", buildingOutline(new int[][]{{1, 3, 3},
                {2, 3, 5},
                {2, 4, 4},
                {5, 6, 1}}));
        logger.info("{}", buildingOutline(new int[][]{{1, 3, 3},
                {2, 4, 4},
                {2, 4, 5},
                {2, 4, 6},
                {2, 4, 7},
                {5, 6, 1}}));
    }

    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        // handle extreme inputs
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) {
            return answer;
        }

        // sweep line + max Heap for height + answer.add whenever the height changes(except when height = 0).
        int n = buildings.length;
        LinkedList<Point> list = new LinkedList<Point>();
        for (int i = 0; i < n; i++) {
            list.add(new Point(buildings[i][0], true, buildings[i][2]));
            list.add(new Point(buildings[i][1], false, buildings[i][2]));
        }
        Collections.sort(list, listComparator);
        HashHeap maxHashHeap = new HashHeap("max");
        int currentHeight = 0;
        int lastStart = 0;
        for (Point point : list) {
            if (point.isStart) {
                maxHashHeap.add(point.height);
                int tobeCurrentHeight = maxHashHeap.peek();
                if (currentHeight != tobeCurrentHeight) {
                    if (lastStart != point.x && currentHeight != 0) {
                        ArrayList<Integer> tmpArray = new ArrayList<Integer>(Arrays.asList(lastStart, point.x, currentHeight));
                        answer.add(tmpArray);
                    }
                    lastStart = point.x;
                    currentHeight = tobeCurrentHeight;
                }
            } else {
                maxHashHeap.delete(point.height);
                int tobeCurrentHeight;
                if (maxHashHeap.isEmpty()) {
                    tobeCurrentHeight = 0;
                } else {
                    tobeCurrentHeight = maxHashHeap.peek();
                }
                if (currentHeight != tobeCurrentHeight) {
                    if (lastStart != point.x) {
                        ArrayList<Integer> tmpArray = new ArrayList<Integer>(Arrays.asList(lastStart, point.x, currentHeight));
                        answer.add(tmpArray);
                    }
                    lastStart = point.x;
                    currentHeight = tobeCurrentHeight;
                }
            }
        }

        // return answer
        return answer;
    }

    static Comparator<Point> listComparator = new Comparator<Point>() {
        public int compare(Point o1, Point o2) {
//            return o1.x - o2.x;
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            if (o1.isStart && o2.isStart) {
                return o2.height - o1.height;
            }
            if (!o1.isStart && !o2.isStart) {
                return o1.height - o2.height;
            }
            return o1.isStart ? -1 : 1;
        }
    };

    static class Point {
        int x;
        boolean isStart;
        int height;

        public Point() {
        }

        public Point(int x, boolean isStart, int height) {
            this.x = x;
            this.isStart = isStart;
            this.height = height;
        }
    }
}
