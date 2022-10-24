package com.leetcode.Weekly68;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC767ReorganizeString {

  public String reorganizeString(String s) {
    // filter abnormal cases
    if (s == null || s.length() < 2)
      return s;

//        count letter appearance and store in hash[i]
    int[] hash = new int[26];
    char[] chars = s.toCharArray();
    for (char ch : chars) {
      hash[ch - 'a']++;
    }

//        find the letter with the largest occurrence.
    char maxOccurChar = 'a';
    int maxOccurIdx = 0;
    int max = 0;
    for (int i = 0; i < hash.length; i++) {
      if (hash[i] > max) {
        max = hash[i];
        maxOccurChar = (char) (i + 'a');
        maxOccurIdx = i;
      }
    }
    if (max > (s.length() + 1) / 2) {
      return "";
    }

//        put the letter into even index number (0, 2, 4 ...) char array
    char[] res = new char[s.length()];
    int i = 0;
    for (; i < s.length() && hash[maxOccurIdx] > 0; i += 2) {
      res[i] = maxOccurChar;
      hash[maxOccurIdx]--;
    }

//        put the rest into the array
    for (int i1 = 0; i1 < hash.length; i1++) {
      while (hash[i1] > 0) {
        char curChar = (char) (i1 + 'a');
        if (i > s.length() - 1)
          i = 1;
        res[i] = curChar;
        i += 2;
        hash[i1]--;
      }
    }
    return String.valueOf(res);
  }
}
