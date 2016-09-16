package com.HackerRank;

/**
 * Created by yanli on 8/27/2016.
 */
public class StairCase {
    public static void main(String[] args) {
        testStairCase(-1);
        testStairCase(0);
        testStairCase(1);
        testStairCase(3);
        testStairCase(6);
    }

    static void testStairCase(int n) {
        StairCase(n);
    }

    static void StairCase(int n) {
        if (n < 1) {
            return;
        }

        final String symbol = "#";

        for (int i = 1; i <= n; i++) {
            String spaceString = "";
            String symbolString = "";
            for (int j = 0; j < n - i; j++) {
                spaceString += " ";
            }
            for (int j = 0; j < i; j++) {
                symbolString += symbol;
            }
            System.out.println(spaceString + symbolString);
        }
    }
}
