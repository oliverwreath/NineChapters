package com.LeetCode.Weekly69;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class minmaxGasDist {
    private final static Logger logger = LoggerFactory.getLogger(minmaxGasDist.class);

    public static void main(String[] arg) {
        testTrappingRainWaterII();
    }

    private static void testTrappingRainWaterII() {
        minmaxGasDist minmaxGasDist = new minmaxGasDist();
        logger.info("0.500000 = {}", minmaxGasDist.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
    }

    public double minmaxGasDist(int[] stations, int K) {
        int len = stations.length;
        PriorityQueue<Cell> heap = new PriorityQueue<>(len + 1, (o1, o2) -> o2.val.compareTo(o1.val));
        for (int i = 0; i < len - 1; i++) {
            heap.add(new Cell(Math.abs(stations[i] - stations[i + 1])));
        }
        for (int i = 0; i < K; ) {
            Cell cell = heap.poll();
            double factor = cell.val / heap.peek().val;
            System.out.println("factor = " + factor);
            if (factor < 1) {
                cell.addCount();
                i++;
            } else {
                if (factor <= K - 1 - i) {
                    cell.addCount((int) factor);
                    i += (int) factor;
                } else {
                    cell.addCount(K - 1 - i);
                    i += K - 1 - i;
                }
            }

            heap.add(cell);
        }
//        return heap.peek().val;

        double sum = 0;
        for (Cell cell : heap) {
            sum += cell.val;
        }
        System.out.println("sum = " + sum);
        System.out.println("heap.size() = " + heap.size());
        System.out.println("heap = " + heap);

        return sum;
    }

    static class Cell {
        int distance;
        int count;
        Double val;

        public Cell() {
        }

        public Cell(int x) {
            this.distance = x;
            this.count = 1;
            this.val = this.distance * 1.0 / this.count;
        }

        public void addCount() {
            this.count++;
            this.val = this.distance * 1.0 / this.count;
        }

        public void addCount(int x) {
            this.count += x;
            this.val = this.distance * 1.0 / this.count;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "distance=" + distance +
                    ", count=" + count +
                    ", val=" + val +
                    '}';
        }
    }

//    public double minmaxGasDist(int[] stations, int K) {
//        int len = stations.length;
//        PriorityQueue<Cell> heap = new PriorityQueue<>(len + 1, (o1, o2) -> o2.val.compareTo(o1.val));
//        for (int i = 0; i < len - 1; i++) {
//            heap.add(new Cell(Math.abs(stations[i] - stations[i + 1])));
//        }
//        for (int i = 0; i < K; i++) {
//            Cell cell = heap.poll();
//            cell.addCount();
//            heap.add(cell);
//        }
//        return Double.valueOf(heap.peek().val.toString());
//
////        BigDecimal sum = BigDecimal.ZERO;
////        for (Cell cell : heap) {
////            sum = sum.add(cell.val);
////        }
////        System.out.println("sum = " + sum);
////        System.out.println("heap.size() = " + heap.size());
////        System.out.println("heap = " + heap);
////
////        return Double.valueOf(sum.toString());
//    }
//
//    static class Cell {
//        BigDecimal distance;
//        int count;
//        BigDecimal val;
//
//        public Cell() {
//        }
//
//        public Cell(int x) {
//            this.distance = new BigDecimal(x);
//            this.count = 1;
//            this.val = this.distance.divide(BigDecimal.valueOf(this.count), 7, BigDecimal.ROUND_HALF_UP);
//        }
//
//        public void addCount() {
//            this.count++;
//            this.val = this.distance.divide(BigDecimal.valueOf(this.count), 7, BigDecimal.ROUND_HALF_UP);
//        }
//
//        @Override
//        public String toString() {
//            return "Cell{" +
//                    "distance=" + distance +
//                    ", count=" + count +
//                    ", val=" + val +
//                    '}';
//        }
//    }
}