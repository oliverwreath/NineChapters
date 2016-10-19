package com.Amazon;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class RectangleArea_223 {
    private final static Logger logger = LoggerFactory.getLogger(RectangleArea_223.class);

    public static void main(String[] arg) {
        new RectangleArea_223().testSearchA2DMatrix_74();
    }

    private void testSearchA2DMatrix_74() {
        int[] a = new int[]{-3, 0, 3, 4, 0, -1, 9, 2};
        logger.info("{} 45 = {}", Arrays.toString(a), computeArea(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]));
        a = new int[]{0, 0, 0, 0, -1, -1, 1, 1};
        logger.info("{} 4 = {}", Arrays.toString(a), computeArea(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]));
        a = new int[]{-2, -2, 2, 2, -2, -2, 2, 2};
        logger.info("{} 16 = {}", Arrays.toString(a), computeArea(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]));
        a = new int[]{-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1};
        logger.info("{} 2 = {}", Arrays.toString(a), computeArea(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]));
        a = new int[]{-2, -2, 2, 2, 1, -3, 3, -1};
        logger.info("{} 19 = {}", Arrays.toString(a), computeArea(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]));
    }

    /**
     * horizontal CG AE
     * vertical DH BF
     *
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // write your code here
        // handle extreme cases
        long area1 = (C - A) * (D - B);
        long area2 = (G - E) * (H - F);
        long overlap = overLapRectangle(A, B, C, D, E, F, G, H);

        return (int) (area1 + area2 - overlap);
    }

    public long overLapRectangle(int A, int B, int C, int D, int E, int F, int G, int H) {
        // write your code here
        // handle extreme cases
        if (G < A || C < E || H < B || D < F) {
            return 0;
        } else {
            return (Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public boolean isLogging = false;

        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }
}
