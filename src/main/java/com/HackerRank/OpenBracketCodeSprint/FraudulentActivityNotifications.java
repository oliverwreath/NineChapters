package com.HackerRank.OpenBracketCodeSprint;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

import com.lintCode.Advanced.Heap.HashHeap.HashHeap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-15.
 */
public class FraudulentActivityNotifications {
    private final static Logger logger = LoggerFactory.getLogger(FraudulentActivityNotifications.class);

    private static HashHeap maxHeap;
    private static HashHeap minHeap;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        // d
        // minHeap, maxHeap
        maxHeap = new HashHeap("max");
        minHeap = new HashHeap("min");
        int lastMedX2 = 0;
        int warningCount = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            int current = scan.nextInt();
            deque.addLast(current);
            minHeap.add(current);
            maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
//            System.out.println((i + 1) + " day; current = " + current + "\nmaxHeap = " + maxHeap + "\nminHeap = " + minHeap + "\ngetMedX2(maxHeap, minHeap) = " + getMedX2(maxHeap, minHeap));

//            System.out.println("flag2");
            if (i >= d) {
                Integer poll = deque.pollFirst();
//                System.out.println(deque + "; poll = " + poll);
//                assert deque.size() == d;
                if (maxHeap.size() == minHeap.size()) {
//                    minHeap.poll();
                    if (!minHeap.delete(poll)) {
                        maxHeap.delete(poll);
                        maxHeap.add(minHeap.poll());
                    }
                } else {
//                    maxHeap.poll();
                    if (!maxHeap.delete(poll)) {
                        minHeap.delete(poll);
                        minHeap.add(maxHeap.poll());
                    }
                }
                if (current >= lastMedX2) {
                    warningCount++;
//                    System.out.println((i + 1) + " day; Warn current = " + current + "; lastMedX2 = " + lastMedX2);
                }
//                else {
//                    System.out.println((i + 1) + " day; NO warn current = " + current + "; lastMedX2 = " + lastMedX2);
//                }
            }
            if (i >= d - 1) {
//                System.out.println("d = " + d + "; i = " + i);
//                System.out.println((i + 1) + " day; current = " + current + "\nmaxHeap = " + maxHeap + "\nminHeap = " + minHeap);
                lastMedX2 = getMedX2(maxHeap, minHeap);
            }
        }

        System.out.println(warningCount);
    }

    private static int getMedX2(HashHeap maxHeap, HashHeap minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() + minHeap.peek();
        } else {
            return 2 * maxHeap.peek();
        }
    }

    private static Comparator<Integer> maxComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
}
