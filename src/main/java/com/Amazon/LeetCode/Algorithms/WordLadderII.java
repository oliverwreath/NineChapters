package com.Amazon.LeetCode.Algorithms;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class WordLadderII {
    private static final Logger logger = LoggerFactory.getLogger(WordLadderII.class);

    public static void main(String[] arg) {
        new WordLadderII().testWordLadder();
    }

    private void testWordLadder() {
        String[] elements = new String[]{"hot", "dot", "dog", "lot", "log"};
//        String[] elements = new String[]{"ion", "rev", "che", "ind", "lie", "wis", "oct", "ham", "jag", "ray", "nun", "ref", "wig", "jul", "ken", "mit", "eel", "paw", "per", "ola", "pat", "old", "maj", "ell", "irk", "ivy", "beg", "fan", "rap", "sun", "yak", "sat", "fit", "tom", "fin", "bug", "can", "hes", "col", "pep", "tug", "ump", "arc", "fee", "lee", "ohs", "eli", "nay", "raw", "lot", "mat", "egg", "cat", "pol", "fat", "joe", "pis", "dot", "jaw", "hat", "roe", "ada", "mac"};
        HashSet<String> set = new HashSet<>();
        for (String element : elements) {
            set.add(element);
        }
        logger.info("5 = {}", findLadders("hit", "cog", set));
//        logger.info("4 = {}", findLadders("cat", "fin", set));
    }
//    "cat"
//            "fin"
//            ["ion","rev","che","ind","lie","wis","oct","ham","jag","ray","nun","ref","wig","jul","ken","mit","eel","paw","per","ola","pat","old","maj","ell","irk","ivy","beg","fan","rap","sun","yak","sat","fit","tom","fin","bug","can","hes","col","pep","tug","ump","arc","fee","lee","ohs","eli","nay","raw","lot","mat","egg","cat","pol","fat","joe","pis","dot","jaw","hat","roe","ada","mac"]

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> dict) {
        // write your code here
        // handle extreme cases
        if (beginWord.equals(endWord)) {
            List<String> path = new LinkedList<>();
            path.add(beginWord);
            List<List<String>> ladder = new LinkedList<>();
            ladder.add(path);
            return ladder;
        }
        if (dict == null || dict.size() == 0) {
            return new LinkedList<>();
        }

        // init
        dict.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        // bfs
        bfs(map, distance, beginWord, dict);
        myLogger.info("map = " + map);
        myLogger.info("distance = " + distance);

        // dfs
        List<List<String>> ladder = new LinkedList<>();
        List<String> path = new LinkedList<>();
        dfs(ladder, path, map, distance, beginWord, endWord);
        return ladder;
    }

    private void dfs(List<List<String>> ladder, List<String> path, Map<String, List<String>> map, Map<String, Integer> distance, String target, String currentNode) {
        path.add(currentNode);
        if (currentNode.equals(target)) {
            Collections.reverse(path);
            ladder.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            if (map.containsKey(currentNode)) {
                for (String upperWord : map.get(currentNode)) {
                    if (distance.containsKey(upperWord) && (distance.get(upperWord) + 1) == distance.get(currentNode)) {
                        myLogger.info("currentNode-> upperWord = " + currentNode + "->" + upperWord + "; path = " + path);
                        dfs(ladder, path, map, distance, target, upperWord);
                    }
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 1);
        for (String s : dict) {
            map.put(s, new LinkedList<String>());
        }

        // bfs
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String currentNode = queue.poll();
                LinkedList<String> nextWords = findNextWords(currentNode, dict);
                for (String nextWord : nextWords) {
                    map.get(nextWord).add(currentNode);
                    if (!distance.containsKey(nextWord)) {
                        queue.add(nextWord);
                        distance.put(nextWord, distance.get(currentNode) + 1);
                    }
                }
            }
        }
        return;
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
