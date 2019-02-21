package com.LeetCode.Weekly67;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No763_PartitionLabels {
    private static final Logger logger = LoggerFactory.getLogger(No763_PartitionLabels.class);

    public static void main(String[] args) {
        testNo763_PartitionLabels();
    }

    private static void testNo763_PartitionLabels() {
        No763_PartitionLabels No763_PartitionLabels = new No763_PartitionLabels();
        MyLogger.info("result [9,7,8] v.s. " + No763_PartitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
//        MyLogger.info("result 1 v.s. " + No763_PartitionLabels.partitionLabels("10"));
    }

    /**
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        // core logic
        HashMap<Character, Pair> lookup = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (lookup.containsKey(S.charAt(i))) {
                lookup.get(S.charAt(i)).end = i;
            } else {
                lookup.put(S.charAt(i), new Pair(i, i));
            }
        }

        LinkedList<Integer> ends = new LinkedList<>();
        for (int i = 0; i < S.length(); ) {
            int end = Math.max(i, lookup.get(S.charAt(i)).end);
            while (i < end) {
                i++;
                end = Math.max(end, lookup.get(S.charAt(i)).end);
            }
            ends.add(end + 1);
            i++;
        }
        LinkedList<Integer> results = new LinkedList<>();
        results.add(ends.get(0));
        for (int i = 1; i < ends.size(); i++) {
            results.add(ends.get(i) - ends.get(i - 1));
        }
        return results;
    }

    private class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
