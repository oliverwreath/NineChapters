package com.lintCode.Advanced.Trie;

/**
 * Created by yanli on 2016-10-15.
 */
public class WordDictionary {
    private Trie trie;

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));  // return false
        System.out.println(wordDictionary.search("bad"));  // return true
        System.out.println(wordDictionary.search(".ad"));  // return true
        System.out.println(wordDictionary.search("b.."));  // return true
        System.out.println(wordDictionary.search("."));  // return false
        System.out.println(wordDictionary.search("a"));  // return false
        System.out.println(wordDictionary.search(""));  // return false
    }

    public WordDictionary() {
        trie = new Trie();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return search(0, word, this.trie.root);
    }

    public boolean search(int index, String word, TrieNode root) {
        // Write your code here
        if (word == null) {
            return true;
        }
        int n = word.length();
        if (n == index) {
            return root.isString;
        }
//        System.out.println("index = " + index + "; word = " + word);
        char currentChar = word.charAt(index);
        if (currentChar != '.') {
            if (root.subtree.containsKey(currentChar)) {
                return search(index + 1, word, root.subtree.get(currentChar));
            }
        } else {
            boolean isFound = false;
            for (TrieNode trieNode : root.subtree.values()) {
                isFound = isFound || search(index + 1, word, trieNode);
                if (isFound) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");