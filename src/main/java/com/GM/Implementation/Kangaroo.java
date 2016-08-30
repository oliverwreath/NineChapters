package com.GM.Implementation;

import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        if (x1 == x2) {
            System.out.println("YES");
        } else {
            if (v1 == v2) {
                System.out.println("NO");
            }
        }

        long c = (x1 - x2) / (v2 - v1);
        long res = (x1 - x2) % (v2 - v1);
        if (c >= 0 && res == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
