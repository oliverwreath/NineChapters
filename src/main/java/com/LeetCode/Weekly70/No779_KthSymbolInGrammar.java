package com.LeetCode.Weekly70;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No779_KthSymbolInGrammar {
    private final static Logger logger = LoggerFactory.getLogger(No779_KthSymbolInGrammar.class);

    public static void main(String[] args) {
        testNo779_KthSymbolInGrammar();
    }

    private static void testNo779_KthSymbolInGrammar() {
        No779_KthSymbolInGrammar No779_KthSymbolInGrammar = new No779_KthSymbolInGrammar();
        MyLogger.info("result 0 v.s. " + No779_KthSymbolInGrammar.kthGrammar(1, 1));
        MyLogger.info("result 0 v.s. " + No779_KthSymbolInGrammar.kthGrammar(2, 1));
        MyLogger.info("result 1 v.s. " + No779_KthSymbolInGrammar.kthGrammar(2, 2));
        MyLogger.info("result 1 v.s. " + No779_KthSymbolInGrammar.kthGrammar(4, 5));
        MyLogger.info("result 0 v.s. " + No779_KthSymbolInGrammar.kthGrammar(4, 7));
    }

    boolean[] a = new boolean[]{false, true, true, false};

    public int kthGrammar(int N, int K) {
        // filter abnormal cases
        if (K <= 4) {
            if (a[K - 1]) {
                return 1;
            } else {
                return 0;
            }
        }

        int k = K;
        boolean isReversed = false;
        while (k > 4) {
            if (k % 2 == 1) {
                k += 1;
                isReversed = !isReversed;
                k /= 2;
                isReversed = !isReversed;
            } else {
                k /= 2;
                isReversed = !isReversed;
            }
        }
        if (a[k - 1]) {
            return isReversed ? 0 : 1;
        } else {
            return isReversed ? 1 : 0;
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
