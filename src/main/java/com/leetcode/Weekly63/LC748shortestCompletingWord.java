package com.leetcode.Weekly63;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

@Slf4j
public class LC748shortestCompletingWord {
  public static void main(String[] args) {
    testNo748_shortestCompletingWord();
  }

  private static void testNo748_shortestCompletingWord() {
    LC748shortestCompletingWord LC748shortestCompletingWord = new LC748shortestCompletingWord();
    log.info("result steps v.s. " + LC748shortestCompletingWord.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    log.info("result pest v.s. " + LC748shortestCompletingWord.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
  }

  /**
   * @param licensePlate
   * @param words
   * @return
   */
  public String shortestCompletingWord(String licensePlate, String[] words) {
    // filter abnormal inputs
    if (words == null || words.length < 1) {
      return "";
    }
    if (licensePlate == null || licensePlate.length() < 1) {
      Arrays.sort(words);
      return words[0];
    }

    // core logic
    int len = licensePlate.length();
    HashMap<Character, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < len; i++) {
      char currentChar = Character.toLowerCase(licensePlate.charAt(i));
      if (Character.isAlphabetic(currentChar)) {
        if (!hashMap.containsKey(currentChar)) {
          hashMap.put(currentChar, 1);
        } else {
          hashMap.put(currentChar, hashMap.get(currentChar) + 1);
        }
      }
    }

    Arrays.sort(words, Comparator.comparingInt(String::length));
    if (hashMap.keySet().isEmpty()) {
      return words[0];
    }
    for (String currentWord : words) {
      int wordLength = currentWord.length();
      log.debug("currentWord = " + currentWord);
      HashMap<Character, Integer> tmpHashMap = new HashMap<>(hashMap);
      log.debug("tmpHashMap = " + tmpHashMap);
      for (int i1 = 0; i1 < wordLength; i1++) {
        if (Character.isAlphabetic(currentWord.charAt(i1))) {
          if (tmpHashMap.containsKey(currentWord.charAt(i1))) {
            if (tmpHashMap.get(currentWord.charAt(i1)) < 2) {
              tmpHashMap.remove(currentWord.charAt(i1));
              if (tmpHashMap.keySet().isEmpty()) {
                return currentWord;
              }
            } else {
              tmpHashMap.put(currentWord.charAt(i1), tmpHashMap.get(currentWord.charAt(i1)) - 1);
            }
          }
        }
        if (tmpHashMap.keySet().isEmpty()) {
          return currentWord;
        }
      }
    }

    return "";
  }

}
