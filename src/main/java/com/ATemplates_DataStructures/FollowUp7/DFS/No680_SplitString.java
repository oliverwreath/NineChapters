package com.ATemplates_DataStructures.FollowUp7.DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class No680_SplitString {
    private final static Logger logger = LoggerFactory.getLogger(No680_SplitString.class);

    public static void main(String[] args) {
        No680_SplitString No680_SplitString = new No680_SplitString();
        No680_SplitString.testNo680_SplitString();
    }

    private void testNo680_SplitString() {
        MyLogger.info("result [[\"1\",\"2\",\"3\"],[\"12\",\"3\"],[\"1\",\"23\"]] v.s. " + splitString("123"));
    }

    public List<List<String>> splitString(String s) {
        // filter abnormal cases
        answer = new ArrayList<>();
        if (s == null || s.length() == 0) {
            answer.add(new ArrayList<>());
            return answer;
        }

        this.s = s;
        this.combinations = new ArrayList<>();
        dfs(0);

        // return the final result
        return answer;
    }

    String s;
    List<List<String>> answer;
    List<String> combinations;

    void dfs(int i) {
        if (i == s.length()) {
            answer.add(new ArrayList<>(combinations));
            return;
        }

        combinations.add(s.substring(i, i + 1));
        dfs(i + 1);
        combinations.remove(combinations.size() - 1);
        if (i + 1 <= s.length() - 1) {
            combinations.add(s.substring(i, i + 2));
            dfs(i + 2);
            combinations.remove(combinations.size() - 1);
        }
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
