package com.oliver.test;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/5/23.
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ArrayList<String> strings = fizzBuzz(15);
        System.out.println(strings);
    }

    public static ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> ret = new ArrayList<String>();

        if (n < 1) {
            return ret;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 != 0) {
                    ret.add("fizz");
                } else {
                    ret.add("fizz buzz");
                }
            } else if (i % 5 == 0) {
                ret.add("buzz");
            } else {
                ret.add(Integer.toString(i));
            }
        }

        return ret;
    }
}
