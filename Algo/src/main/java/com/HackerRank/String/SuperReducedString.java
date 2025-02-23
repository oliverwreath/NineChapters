package com.HackerRank.String;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SuperReducedString {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    String string = in.next();
    char[] chars = string.toCharArray();
    List<Character> list = new LinkedList<>();
    for (char aChar : chars) {
      list.add(aChar);
    }
    boolean isReduced = true;
    while (isReduced) {
      isReduced = false;
      int len = list.size();
      for (int i = 0; i < len - 1; i++) {
        if (Objects.equals(list.get(i), list.get(i + 1))) {
          list.remove(i + 1);
          list.remove(i);
          isReduced = true;
          break;
        }
      }
    }

    if (list.isEmpty()) {
      log.info("Empty String");
    } else {
      log.info(getStringFromList(list));
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
