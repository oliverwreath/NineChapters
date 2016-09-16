package com.HackerRank.String;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class SuperReducedString {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String string = in.next();
        char[] chars = string.toCharArray();
        List<Character> list = new LinkedList<Character>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        boolean isReduced = true;
        while (isReduced) {
            isReduced = false;
            int len = list.size();
            for (int i = 0; i < len - 1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    list.remove(i + 1);
                    list.remove(i);
                    isReduced = true;
                    break;
                }
            }
        }

        if (list.size() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(getStringFromList(list));
        }
    }

    static String getStringFromList(List<Character> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
