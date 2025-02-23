package com.leetcode.Weekly73;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC791CustomSortString {

  public static void main(String[] args) {
    LC791CustomSortString LC791CustomSortString = new LC791CustomSortString();
    LC791CustomSortString.testNo791_CustomSortString();
  }

  private void testNo791_CustomSortString() {
    log.info("result \"cabd\" v.s. " + customSortString("cab", "abcd"));
//        log.info("result \"cbad\" v.s. " + customSortString("cba", "abcd"));
  }

  String customSortString(String S, String T) {
    // filter abnormal cases
    if (T == null || T.length() == 0) {
      return T;
    }
    if (S == null || S.length() == 0) {
      return T;
    }

    map = new int[27];
    sequence = new int[27];
    for (int i = 0; i < 27; i++) {
      map[i] = -1;
      sequence[i] = -1;
    }
    for (int index = 0; index < S.length(); index++) {
      map[S.charAt(index) - 'a'] = index;
      sequence[index] = S.charAt(index) - 'a';
    }

    count = new int[27];
    for (int i = 0; i < T.length(); i++) {
      count[T.charAt(i) - 'a']++;
    }
//        log.debug("map = " + Arrays.toString(map));
//        log.debug("sequence = " + Arrays.toString(sequence));
//        log.debug("count = " + Arrays.toString(count));
//        log.debug("Sorted T = " + T);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < T.length() && sequence[i] != -1; i++) {
      int index = sequence[i];
      char currentChar = (char) (index + 'a');
//            log.debug("index = " + index + "; currentChar = " + currentChar);
      for (int times = 0; times < count[index]; times++) {
        stringBuilder.append(currentChar);
      }
      count[index] = 0;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        for (int j = 0; j < count[i]; j++) {
          stringBuilder.append((char) (i + 'a'));
        }
      }
    }
//        log.debug("count = " + Arrays.toString(count));

    // return the final result
    return stringBuilder.toString();
  }

  int[] map;
  int[] sequence;
  int[] count;

}
