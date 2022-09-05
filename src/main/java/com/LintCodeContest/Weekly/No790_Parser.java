package com.LintCodeContest.Weekly;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class No790_Parser {
  public static void main(String[] args) {
    testNo790_Parser();
  }

  private static void testNo790_Parser() {
    No790_Parser No790_Parser = new No790_Parser();
    log.info("result True v.s. " + No790_Parser.canBeGenerated(new String[]{"S -> abc", "S -> aA", "A -> b", "A -> c"}, 'S', "ac"));
    log.info("result False v.s. " + No790_Parser.canBeGenerated(new String[]{"S -> abc", "S -> aA", "A -> b", "A -> c"}, 'S', "a"));
  }

  /**
   * @param generator
   * @param startSymbol
   * @param target
   * @return
   */
  public boolean canBeGenerated(String[] generator, char startSymbol, String target) {
    if (generator == null || generator.length == 0) {
      return false;
    }

    HashMap<Character, List<String>> map = new HashMap<>();
    for (String s : generator) {
      int i = s.indexOf("->");
//            log.debug(s.charAt(i));
//            log.debug(s.substring(i + 3, s.length()));
      if (!map.containsKey(s.charAt(0))) {
        map.put(s.charAt(0), new LinkedList<>());
      }
      map.get(s.charAt(0)).add(s.substring(i + 3, s.length()));
//            log.debug("map = " + map);
    }

    boolean hasMore = true;
//        List<Object> answers = new LinkedList<>();
    HashSet<Object> answers = new HashSet<>();
    answers.add(startSymbol);
    HashSet<Object> visited = new HashSet<>();
    while (hasMore) {
      hasMore = false;

      HashSet<Object> tmp = new HashSet<>();
      for (Object answer : answers) {
        if (answer instanceof Character) {
          if (!visited.contains(answer)) {
            if (map.containsKey(answer)) {
              for (String s : map.get(answer)) {
                if (!answers.contains(s)) {
                  if (s.equals(target)) {
                    return true;
                  }
                  tmp.add(s);
                  hasMore = true;
                }
              }
            }
          }
        } else if (answer instanceof String) {
          if (!visited.contains(answer)) {
            for (int i = 0; i < ((String) answer).length(); i++) {
              if (Character.isUpperCase(((String) answer).charAt(i)) && map.containsKey(((String) answer).charAt(i))) {
                for (String ss : map.get(((String) answer).charAt(i))) {
                  StringBuilder stringBuilder = new StringBuilder();
                  if (i > 0) {
                    stringBuilder.append(((String) answer).substring(0, i));
                  }
                  stringBuilder.append(ss);
                  if (i < ((String) answer).length() - 1) {
                    stringBuilder.append(((String) answer).substring(i + 1));
                  }
                  String s = stringBuilder.toString();
                  if (!answers.contains(s)) {
                    if (s.equals(target)) {
                      return true;
                    }
                    tmp.add(s);
                    hasMore = true;
                  }
                }
              }
            }
          }
        }
      }
      answers.addAll(tmp);
    }
//        log.debug("map = " + map);
//        log.debug("answers = " + answers);

    // return the final result
    return false;
  }

}
