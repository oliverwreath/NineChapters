package com.HackerRank.CrackingTheCodingInterviewChallenges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Scanner;

public class HashTableIceCreamParlor {
    private final static Logger logger = LoggerFactory.getLogger(HashTableIceCreamParlor.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }

    /**
     * @param arr
     * @param money
     */
    static void solve(int[] arr, int money) {
        // Complete this function
        if (arr == null || arr.length < 1) {
            System.out.println(-1 + " " + -1);
            return;
        }

        // core logic
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < money) {
                if (hashMap.containsKey(money - arr[i])) {
                    int index = hashMap.get(money - arr[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }

                if (!hashMap.containsKey(arr[i])) {
                    hashMap.put(arr[i], i);
                }
            }
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
