package com.HackerRank.WeekOfCode24;

import java.util.HashMap;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class HappyLadybugs {
    private static final Logger logger = LoggerFactory.getLogger(HappyLadybugs.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            String b = in.next();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            boolean isAlreadyHappy = true;
            Character lastChar = b.charAt(0);
            int sameCounter = 1;
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    if (lastChar == '_') {
                        sameCounter = 1;
                        lastChar = b.charAt(i);
                    } else {
                        if (lastChar == b.charAt(i)) {
                            sameCounter++;
                        } else {
                            if (sameCounter == 1) {
                                isAlreadyHappy = false;
                            }
                            sameCounter = 1;
                            lastChar = b.charAt(i);
                        }
                    }
                }

                if (map.containsKey(b.charAt(i))) {
                    map.put(b.charAt(i), map.get(b.charAt(i)) + 1);
                } else {
                    map.put(b.charAt(i), 1);
                }
            }
            {
                if (lastChar != '_') {
                    // last is a ladyBug
                    if (sameCounter == 1) {
                        isAlreadyHappy = false;
                    }
                }
            }
//            System.out.println(map);
            if (isAlreadyHappy) {
                System.out.println("YES");
            } else if (!map.containsKey('_')) {
                System.out.println("NO");
            } else {
                boolean isPrinted = false;
                for (Character character : map.keySet()) {
                    if (character != '_' && map.get(character) == 1) {
                        System.out.println("NO");
                        isPrinted = true;
                        break;
                    }
                }

                if (!isPrinted) {
                    System.out.println("YES");
                }
            }
        }
    }
}
