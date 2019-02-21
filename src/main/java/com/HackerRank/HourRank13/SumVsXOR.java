package com.HackerRank.HourRank13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-04.
 */
public class SumVsXOR {
    private static final Logger logger = LoggerFactory.getLogger(SumVsXOR.class);

    public static void main(String[] arg) {
        new SumVsXOR().testSumVsXOR();
    }

    private void testSumVsXOR() {
        SumVsXOR(5);
        SumVsXOR(10);
        SumVsXOR(101);
//        SumVsXOR(10100);
//        SumVsXOR(10100000);
    }

    // 5 2, 10 4
    void SumVsXOR(long n) {
        // write your code here
        // handle extreme cases
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();

        // approach 1 hashMap
//        HashMap<Long, Long> map = new HashMap<Long, Long>();
//        for (long x = 0; x <= n; x++) {
//            map.put(n + x, x);
//        }
//        long answer = 0;
//        for (long x = 0; x <= n; x++) {
//            long right = n ^ x;
//            if (map.containsKey(right) && map.get(right) == x) {
//                answer++;
//                System.out.println("x = " + x);
//            }
//        }

        // approach 2 math
        long answer = 1;
        while (n > 0) {
            if ((n & 1L) == 0) {
                answer *= 2;
            }
            n = n >> 1;
        }

        System.out.println(answer);
    }
}
