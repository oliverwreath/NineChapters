package com.leetcode.gg;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: Oliver
 */
@Slf4j
public class LC388LongestAbsoluteFilePath {
  public static void main(String[] arg) {
    new LC388LongestAbsoluteFilePath().testLongestAbsoluteFilePath_388();
  }

  private void testLongestAbsoluteFilePath_388() {
    log.info("{}", lengthLongestPath(""));
    log.info("{}", lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    log.debug("");
    log.info("{}", lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
  }

  public int lengthLongestPath(String input) {
    // handle extreme inputs
    if (input == null || input.length() == 0) {
      return 0;
    }

    // split, then get result in one pass
    int n = input.length();
    String[] strings = input.split("\\n");

    // print to check before committing
    int i = 0;
    Deque<Entry> stack = new ArrayDeque<Entry>();
    int answer = 0;
    for (String string : strings) {
      Entry currentEntry = getLevel(string);
      while (!stack.isEmpty() && stack.peek().level >= currentEntry.level) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        currentEntry.length += stack.peek().length + 1;
      }
      if (currentEntry.isFile) {
        answer = Math.max(answer, currentEntry.length);
      }
      stack.add(currentEntry);
//            log.debug(i++ + "; currentEntry = " + currentEntry + ": " + string);
    }

    return answer;
  }

  private class Entry {
    int level;
    int length;
    boolean isFile;

    public Entry() {
    }

    public Entry(int level, int length, boolean isFile) {
      this.level = level;
      this.length = length;
      this.isFile = isFile;
    }

    @Override
    public String toString() {
      return "ResultEntry{" +
              "level=" + level +
              ", length=" + length +
              ", isFile=" + isFile +
              '}';
    }
  }

  private Entry getLevel(String string) {
    int n = string.length();
    int level = 0;
    int length = 0;
    boolean isFile = false;
    int i = 0;
    for (; i < n; i++) {
      if (string.charAt(i) == '\t') {
        level++;
      } else {
        length = n - i;
        break;
      }
    }
    for (; i < n; i++) {
      if (string.charAt(i) == '.') {
        isFile = true;
        break;
      }
    }

    return new Entry(level, length, isFile);
  }
}
