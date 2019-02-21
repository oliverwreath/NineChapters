package com.HackerRank.OpenBracketCodeSprint;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-15.
 */
public class ViralAdvertising {
    private static final Logger logger = LoggerFactory.getLogger(ViralAdvertising.class);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int current = 2;
        long sum = current;
        for (int i = n; i > 1; i--) {
            current = current * 3 / 2;
            sum += current;
        }
        System.out.println(sum);
    }
}
