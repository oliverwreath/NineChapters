package com.AJia.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class WordLadder {
    private final static Logger logger = LoggerFactory.getLogger(WordLadder.class);

    public static void main(String[] arg) {
        new WordLadder().testWordLadder();
    }

    private void testWordLadder() {
        String[] elements = new String[]{"hot", "dot", "dog", "lot", "log"};
//        String[] elements = new String[]{"ion", "rev", "che", "ind", "lie", "wis", "oct", "ham", "jag", "ray", "nun", "ref", "wig", "jul", "ken", "mit", "eel", "paw", "per", "ola", "pat", "old", "maj", "ell", "irk", "ivy", "beg", "fan", "rap", "sun", "yak", "sat", "fit", "tom", "fin", "bug", "can", "hes", "col", "pep", "tug", "ump", "arc", "fee", "lee", "ohs", "eli", "nay", "raw", "lot", "mat", "egg", "cat", "pol", "fat", "joe", "pis", "dot", "jaw", "hat", "roe", "ada", "mac"};
        HashSet<String> set = new HashSet<>();
        for (String element : elements) {
            set.add(element);
        }
        logger.info("5 = {}", ladderLength("hit", "cog", set));
//        logger.info("4 = {}", ladderLength("cat", "fin", set));
    }
//    "cat"
//            "fin"
//            ["ion","rev","che","ind","lie","wis","oct","ham","jag","ray","nun","ref","wig","jul","ken","mit","eel","paw","per","ola","pat","old","maj","ell","irk","ivy","beg","fan","rap","sun","yak","sat","fit","tom","fin","bug","can","hes","col","pep","tug","ump","arc","fee","lee","ohs","eli","nay","raw","lot","mat","egg","cat","pol","fat","joe","pis","dot","jaw","hat","roe","ada","mac"]

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // write your code here
        // handle extreme cases
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (wordList == null || wordList.size() == 0) {
            return 1;
        }

        // init
        wordList.add(endWord);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(beginWord);
        queue.add(beginWord);

        // bfs
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String poll = queue.poll();
                LinkedList<String> nextWords = findNextWords(poll, wordList);
                for (String nextWord : nextWords) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    visited.add(nextWord);
                    queue.add(nextWord);
                }
            }
        }
        return 0;
    }

    private String replace(String string, int index, char c) {
        char[] chars = string.toCharArray();
        chars[index] = c;
        return String.valueOf(chars);
    }

    private LinkedList<String> findNextWords(String begin, Set<String> dict) {
        if (begin == null || begin.length() == 0) {
            return new LinkedList<>();
        }
        int n = begin.length();
        LinkedList<String> nextWords = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < n; i++) {
                if (begin.charAt(i) == c) {
                    continue;
                }
                String newWord = replace(begin, i, c);
                if (dict.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
        }
        return nextWords;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
