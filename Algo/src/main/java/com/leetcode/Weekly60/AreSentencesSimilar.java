package com.leetcode.Weekly60;

import java.util.HashMap;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AreSentencesSimilar {

  public static void main(String[] args) {
    testAreSentencesSimilar();
  }

  private static void testAreSentencesSimilar() {
    AreSentencesSimilar AreSentencesSimilar = new AreSentencesSimilar();
    log.info("result true v.s. " + AreSentencesSimilar.areSentencesSimilar(new String[]{"great", "acting", "skills"},
        new String[]{"fine", "drama", "talent"},
        new String[][]{{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"}}));
    log.info("result false v.s. " + AreSentencesSimilar.areSentencesSimilar(new String[]{"great"}, new String[]{"fine"},
        new String[][]{}));
    log.info("result true v.s. " + AreSentencesSimilar.areSentencesSimilar(new String[]{"great"}, new String[]{"great"},
        new String[][]{}));
    log.info("result true v.s. " + AreSentencesSimilar.areSentencesSimilar(
        new String[]{"this", "summer", "thomas", "get", "actually", "actually", "rich", "and", "possess", "the",
            "actually", "great", "and", "fine", "vehicle", "every", "morning", "he", "drives", "one", "nice", "car",
            "around", "one", "great", "city", "to", "have", "single", "super", "excellent", "super", "as", "his",
            "brunch", "but", "he", "only", "eat", "single", "few", "fine", "food", "as", "some", "fruits", "he",
            "wants", "to", "eat", "an", "unique", "and", "actually", "healthy", "life"},
        new String[]{"this", "summer", "thomas", "get", "very", "very", "rich", "and", "possess", "the", "very", "fine",
            "and", "well", "car", "every", "morning", "he", "drives", "a", "fine", "car", "around", "unique", "great",
            "city", "to", "take", "any", "really", "wonderful", "fruits", "as", "his", "breakfast", "but", "he", "only",
            "drink", "an", "few", "excellent", "breakfast", "as", "a", "super", "he", "wants", "to", "drink", "the",
            "some", "and", "extremely", "healthy", "life"},
        new String[][]{{"good", "nice"}, {"good", "excellent"}, {"good", "well"}, {"good", "great"}, {"fine", "nice"},
            {"fine", "excellent"}, {"fine", "well"}, {"fine", "great"}, {"wonderful", "nice"},
            {"wonderful", "excellent"}, {"wonderful", "well"}, {"wonderful", "great"}, {"extraordinary", "nice"},
            {"extraordinary", "excellent"}, {"extraordinary", "well"}, {"extraordinary", "great"}, {"one", "a"},
            {"one", "an"}, {"one", "unique"}, {"one", "any"}, {"single", "a"}, {"single", "an"}, {"single", "unique"},
            {"single", "any"}, {"the", "a"}, {"the", "an"}, {"the", "unique"}, {"the", "any"}, {"some", "a"},
            {"some", "an"}, {"some", "unique"}, {"some", "any"}, {"car", "vehicle"}, {"car", "automobile"},
            {"car", "truck"}, {"auto", "vehicle"}, {"auto", "automobile"}, {"auto", "truck"}, {"wagon", "vehicle"},
            {"wagon", "automobile"}, {"wagon", "truck"}, {"have", "take"}, {"have", "drink"}, {"eat", "take"},
            {"eat", "drink"}, {"entertain", "take"}, {"entertain", "drink"}, {"meal", "lunch"}, {"meal", "dinner"},
            {"meal", "breakfast"}, {"meal", "fruits"}, {"super", "lunch"}, {"super", "dinner"}, {"super", "breakfast"},
            {"super", "fruits"}, {"food", "lunch"}, {"food", "dinner"}, {"food", "breakfast"}, {"food", "fruits"},
            {"brunch", "lunch"}, {"brunch", "dinner"}, {"brunch", "breakfast"}, {"brunch", "fruits"}, {"own", "have"},
            {"own", "possess"}, {"keep", "have"}, {"keep", "possess"}, {"very", "super"}, {"very", "actually"},
            {"really", "super"}, {"really", "actually"}, {"extremely", "super"}, {"extremely", "actually"}}));
  }

  /**
   * @param words1
   * @param words2
   * @param pairs
   * @return
   */
  public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    // filter abnormal inputs
    if (words1 == null) {
      return words2 == null;
    } else {
      if (words2 == null) {
        return false;
      } else {
        if (words1.length != words2.length) {
          return false;
        } else if (words1.length < 1) {
          return true;
        }
      }
    }

    // core logic
    HashMap<String, HashSet<String>> hashMap = new HashMap<>();
    for (String[] pair : pairs) {
      if (!hashMap.containsKey(pair[0])) {
        hashMap.put(pair[0], new HashSet<>());
      }
      hashMap.get(pair[0]).add(pair[1]);
    }
    int len = words1.length;
    for (int i = 0; i < len; i++) {
//            log.debug("words1[i] = " + words1[i] + "; words2[i] = " + words2[i]);
      if (!words1[i].equals(words2[i]) && !(hashMap.containsKey(words1[i]) && hashMap.get(words1[i])
          .contains(words2[i])) && !(hashMap.containsKey(words2[i]) && hashMap.get(words2[i]).contains(words1[i]))) {
        return false;
      }
    }

    return true;
  }
}
