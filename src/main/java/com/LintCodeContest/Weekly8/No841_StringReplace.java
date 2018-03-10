package com.LintCodeContest.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No841_StringReplace {
    private final static Logger logger = LoggerFactory.getLogger(No841_StringReplace.class);

    public static void main(String[] args) {
        No841_StringReplace No841_StringReplace = new No841_StringReplace();
        No841_StringReplace.testNo841_StringReplace();
    }

    private void testNo841_StringReplace() {
        MyLogger.info("result \"cccba\" v.s. " + stringReplace(new String[]{"ab", "aba"}, new String[]{"cc", "ccc"}, "ababa"));
        MyLogger.info("result \"aaaaa\" v.s. " + stringReplace(new String[]{"ab", "aba"}, new String[]{"cc", "ccc"}, "aaaaa"));
        MyLogger.info("result \"cccccccccccc\" v.s. " + stringReplace(new String[]{"ab", "aba"}, new String[]{"cc", "ccc"}, "cccccccccccc"));
        MyLogger.info("result \"cccbacccba\" v.s. " + stringReplace(new String[]{"ab", "aba"}, new String[]{"cc", "ccc"}, "ababaababa"));
    }

    class TrieNode {
        TrieNode[] next;
        boolean isWord;
        String s;
        int index;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.isWord = false;
            this.s = "";
            this.index = -1;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "isWord=" + isWord +
                    ", s='" + s + '\'' +
                    '}';
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word, int index) {
            if (word == null || word.length() == 0) {
                return;
            }

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (node.next[pos] == null) {
                    node.next[pos] = new TrieNode();
                }
                node = node.next[pos];
            }
            node.isWord = true;
            node.s = word;
            node.index = index;
        }

        public TrieNode find(String word) {
            if (word == null || word.length() == 0) {
                return root;
            }

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (node.next[pos] == null) {
                    return null;
                } else {
                    node = node.next[pos];
                }
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = find(prefix);
            return node != null;
        }

        public boolean startsWith(char ch) {
            return startsWith(String.valueOf(ch));
        }

//        public boolean search(String word) {
//            TrieNode node = find(word);
//            return node != null && node.isWord;
//        }

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }
    }

    String stringReplace(String[] A, String[] B, String S) {
        // filter abnormal cases
        if (S == null || S.length() == 0) {
            return S;
        }
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return S;
        }

        int maxPossibleLength = Integer.MIN_VALUE;
        for (String aa : A) {
            maxPossibleLength = Math.max(maxPossibleLength, aa.length());
        }
        Trie trie = new Trie();
        for (int index = 0; index < A.length; index++) {
            String aa = A[index];
            trie.insert(aa, index);
        }
        TrieNode node = trie.root;
        int beginIndex = 0;
        boolean isMatch = false;
        int longestMatchIndex = -1;
        StringBuilder answer = new StringBuilder();
        int answerIndex = 0;
        int currentLength = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int pos = c - 'a';
            if (node.next[pos] != null) {
                node = node.next[pos];
                currentLength++;
                if (node.isWord) {
                    isMatch = true;
                    longestMatchIndex = node.index;
                }
            } else {
//                System.out.println(i + " " + currentLength + " " + maxPossibleLength + " " + isMatch + " " + S + " " + S.charAt(i));

                if (trie.root.next[pos] == null) {
                    currentLength = 0;
                    if (isMatch) {
                        if (answerIndex < beginIndex) {
                            answer.append(S.substring(answerIndex, beginIndex));
                        }
                        answer.append(B[longestMatchIndex]);
                        answer.append(S.charAt(i));
                        isMatch = false;
                        longestMatchIndex = -1;
                    } else {
                        answer.append(S.substring(answerIndex, i + 1));
                    }
                    answerIndex = i + 1;
                    node = trie.root;
                    beginIndex = i + 1;
                    continue;
                } else {
                    currentLength = 1;
                    if (isMatch) {
                        if (answerIndex < beginIndex) {
                            answer.append(S.substring(answerIndex, beginIndex));
                        }
                        answer.append(B[longestMatchIndex]);
                        isMatch = false;
                        longestMatchIndex = -1;
                    } else {
                        answer.append(S.substring(answerIndex, i));
                    }
                    answerIndex = i;
                    node = trie.root.next[pos];
                    beginIndex = i;
                    continue;
                }
            }
        }

        if (isMatch) {
            if (answerIndex < beginIndex) {
                answer.append(S.substring(answerIndex, beginIndex));
            }
            answer.append(B[longestMatchIndex]);
            answer.append(S.charAt(S.length() - 1));
            isMatch = false;
            longestMatchIndex = -1;
        } else {
            answer.append(S.substring(answerIndex, S.length()));
        }

        // return the final result
        return answer.toString();
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
