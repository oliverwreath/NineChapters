package com.ATemplatesDataStructures.tmp;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class No784_LetterCasePermutation {
  public static void main(String[] args) {
    No784_LetterCasePermutation No784_LetterCasePermutation = new No784_LetterCasePermutation();
    No784_LetterCasePermutation.testNo784_LetterCasePermutation();
  }

  private void testNo784_LetterCasePermutation() {
    log.info("result [\"a1b2\", \"a1B2\", \"A1b2\", \"A1B2\"] v.s. " + letterCasePermutation("a1b2"));
    log.info("result [\"3z4\", \"3Z4\"] v.s. " + letterCasePermutation("3z4"));
  }

  public List<String> letterCasePermutation(String A) {
    // filter abnormal cases
    List<String> answer = new ArrayList<>();
    if (A == null || A.length() == 0) {
      answer.add("");
      return answer;
    }

    int len = A.length();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      if (Character.isAlphabetic(A.charAt(i))) {
        list.add(i);
      }
    }
    if (list.size() == 0) {
      answer.add(A);
    } else {
      StringBuilder current = new StringBuilder();
      current.append(A.toLowerCase());
      answer.add(current.toString());
      int n = list.size();
      int[] bits = new int[n];
      while (bits[n - 1] != 1 || !isAllOne(bits)) {
        // add one with carry
        int carry = 1;
        int i = 0;// i = 0 -> n - 1
        while (carry == 1) {
          if (i < n) {
            Integer index = list.get(i);
            char c = current.charAt(index);
            if (bits[i] == 0) {
              current.setCharAt(index, Character.toUpperCase(c));
            } else {
              current.setCharAt(index, Character.toLowerCase(c));
            }
            carry = bits[i];
            bits[i] = 1 - bits[i];
            i++;
          } else {
            break;
          }
        }
        // change current
        answer.add(current.toString());

      }
    }

    // return the final result
    return answer;
  }

  boolean isAllOne(int[] bits) {
    for (int bit : bits) {
      if (bit != 1) {
        return false;
      }
    }
    return true;
  }

}
