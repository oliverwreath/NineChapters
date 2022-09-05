package com.NineChapters.PermutationOrGraphBasedDFS;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class StringPermutationII_10 {
  public static void main(String[] args) {
    testStringPermutationII_10();
  }

  private static void testStringPermutationII_10() {
    log.info("result [\"abb\", \"bab\", \"bba\"] v.s. {}", stringPermutation2("abb"));
    log.info("result [\"aabb\", \"abab\", \"baba\", \"bbaa\", \"abba\", \"baab\"] v.s. {}", stringPermutation2("aabb"));
  }

  public static List<String> stringPermutation2(String str) {
    // filter abnormal cases
    List<String> result = new LinkedList<>();
    if (str == null || str.length() == 0) {
      result.add("");
      return result;
    }

    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    boolean[] visited = new boolean[chars.length];
    dfs(chars, visited, new LinkedList<Character>(), result);

    // return the final result
    return result;
  }

  private static void dfs(char[] chars, boolean[] visited, List<Character> combination, List<String> result) {
    if (combination.size() == chars.length) {
      result.add(combination.toString().replace(", ", "").replace("[", "").replace("]", ""));
      return;
    }
    for (int i = 0; i < chars.length; i++) {
      if (visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
        continue;
      }
      combination.add(chars[i]);
      visited[i] = true;
      dfs(chars, visited, combination, result);
      combination.remove(combination.size() - 1);
      visited[i] = false;
    }
  }

}
