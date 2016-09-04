package com.oliver.BinarySearch1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/3/2016.
 */
public class WoodCut {
    private final static Logger logger = LoggerFactory.getLogger(WoodCut.class);

    public static void main(String[] arg) {
        testWoodCut();
    }

    private static void testWoodCut() {
        logger.info("{}", woodCut(new int[]{232, 124, 456}, 7));
    }

    static int woodCut(int[] L, int k) {
        //corner cases filter
        if (L == null || L.length < 1) {
            return 0;
        }

        //get the longest length
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }

        //binary search the solution space
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (cut(L, mid) < k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        //return the result
        if (cut(L, end) >= k) {
            return end;
        } else if (cut(L, start) >= k) {
            return start;
        } else {
            return 0;
        }
    }

    static int cut(int[] L, int pieceLength) {
        int numOfPieces = 0;
        for (int i = 0; i < L.length; i++) {
            numOfPieces += L[i] / pieceLength;
        }

        return numOfPieces;
    }
}
