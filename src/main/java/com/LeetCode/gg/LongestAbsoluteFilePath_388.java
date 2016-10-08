package com.LeetCode.gg;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class LongestAbsoluteFilePath_388 {
    private final static Logger logger = LoggerFactory.getLogger(LongestAbsoluteFilePath_388.class);

    public static void main(String[] arg) {
        new LongestAbsoluteFilePath_388().testLongestAbsoluteFilePath_388();
    }

    private void testLongestAbsoluteFilePath_388() {
        logger.info("{}", lengthLongestPath(""));
        logger.info("{}", lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println();
        logger.info("{}", lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
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
        Stack<Entry> stack = new Stack<Entry>();
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
//            System.out.println(i++ + "; currentEntry = " + currentEntry + ": " + string);
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
            return "Entry{" +
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
