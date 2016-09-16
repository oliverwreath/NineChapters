package com.HackerRank.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class DivisiblePairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        List<Integer> list = getListFromArray(a);
//        Collections.sort(list);
        int resultCounter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmpSum = a[i] + a[j];
                if (tmpSum % k == 0) {
                    resultCounter++;
                }
            }
        }

        System.out.println(resultCounter);
    }

    static List<Integer> getListFromArray(int[] a) {
        int len = a.length;
        ArrayList<Integer> list = new ArrayList<Integer>(len);
        for (int i = 0; i < len; i++) {
            list.add(i, a[i]);
        }

        return list;
    }
}
