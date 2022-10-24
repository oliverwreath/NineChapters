package com.lintcode.test;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/5/23.
 */
@Slf4j
public class Test {

  public static void main(String[] args) {
    ArrayList<String> strings = fizzBuzz(15);
    log.debug("{}", strings);
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
