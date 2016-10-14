package com.lintCode.Advanced.Trie;

import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-13.
 */
public class WordSearchII {
    private final static Logger logger = LoggerFactory.getLogger(WordSearchII.class);

    public static void main(String[] arg) {
        new WordSearchII().testWordSearchII();
    }

    private void testWordSearchII() {
        ArrayList<String> dict = new ArrayList<String>();
        dict.add("dog");
        dict.add("dad");
        dict.add("dgdg");
        dict.add("can");
        dict.add("again");
        logger.info("{}", wordSearchII(new char[][]{
                        {'d', 'o', 'a', 'f'},
                        {'a', 'g', 'a', 'i'},
                        {'d', 'c', 'a', 'n'}}
                , dict));

        dict.clear();
        dict.add("see");
        dict.add("se");
        logger.info("{}", wordSearchII(new char[][]{
                        {'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}}
                , dict));

        dict.clear();
        dict.add("abcb");
        dict.add("ninechapter");
        dict.add("lintcode");
        logger.info("{}", wordSearchII(new char[][]{
                        {'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}}
                , dict));
    }

    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        // handle extreme inputs
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new ArrayList<String>();
        }

        // build trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
//        System.out.println(trie);

        // DFS
        int n = board.length;
        int m = board[0].length;
//        System.out.println("n = " + n + "; m = " + m);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
        HashSet<String> ans = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, n, m, trie.root, board, ans);
            }
        }

        // return the answer
        return new ArrayList<String>(ans);
    }

    private void dfs(int i, int j, int n, int m, TrieNode root, char[][] board, HashSet<String> ans) {
        if (root.isString) {
//            System.out.println("i = " + i + "; j = " + j + "; n = " + n + "; m = " + m);
            ans.add(root.s);
        }
        if (root != null && root.subtree.containsKey(board[i][j])) {
            for (int t = 0; t < 4; t++) {
                int X = i + dx[t];
                int Y = j + dy[t];
                if (valid(X, Y, n, m)) {
                    char now = board[i][j];
                    board[i][j] = 0;
                    dfs(X, Y, n, m, root.subtree.get(now), board, ans);
                    board[i][j] = now;
                }
            }
        }
    }

    private boolean valid(int X, int Y, int n, int m) {
        return X >= 0 && X < n && Y >= 0 && Y < m;
    }

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
}
