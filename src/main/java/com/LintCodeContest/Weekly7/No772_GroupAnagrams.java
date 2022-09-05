package com.LintCodeContest.Weekly7;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class No772_GroupAnagrams {
  public static void main(String[] args) {
    No772_GroupAnagrams No772_GroupAnagrams = new No772_GroupAnagrams();
    No772_GroupAnagrams.testNo772_GroupAnagrams();
  }

  private void testNo772_GroupAnagrams() {
    log.info("result [\n" +
            "    [\"ate\", \"eat\",\"tea\"],\n" +
            "    [\"nat\",\"tan\"],\n" +
            "    [\"bat\"]\n" +
            "] v.s. \n" + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

  List<List<String>> groupAnagrams(String[] A) {
    ArrayList<List<String>> answer = new ArrayList<>();
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return answer;
    }
    HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
    for (String string : A) {
      HashMap<Character, Integer> mm = new HashMap<>();
      for (int i = 0; i < string.length(); i++) {
        char key = string.charAt(i);
        if (mm.containsKey(key)) {
          mm.put(key, mm.get(key) + 1);
        } else {
          mm.put(key, 1);
        }
      }
      if (!map.containsKey(mm)) {
        map.put(mm, new LinkedList<>());
      }
      map.get(mm).add(string);
    }

    answer.addAll(map.values());

    // return the final result
    return answer;
  }

}
