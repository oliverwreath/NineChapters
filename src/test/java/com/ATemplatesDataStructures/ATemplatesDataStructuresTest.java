package com.ATemplatesDataStructures;

import com.ATemplatesDataStructures.DFS_LeetCode.Graph_DFS.LC207CourseSchedule;
import com.ATemplatesDataStructures.Stack.Lintcode423ValidParentheses;
import com.ATemplatesDataStructures.Trie.LintCode442ImplementTrie;
import com.ATemplatesDataStructures.Trie.Lintcode473AddAndSearchWord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author: Oliver
 */
@Slf4j
class ATemplatesDataStructuresTest {
  @Test void test_No442ImplementTrie() {
    LintCode442ImplementTrie lintCode442ImplementTrie = new LintCode442ImplementTrie();
    LintCode442ImplementTrie.Trie trie = lintCode442ImplementTrie.new Trie();
    final String linterror = "linterror";
    trie.insert("lintcode");
    assertFalse(trie.search("code"));
    assertTrue(trie.startsWith("lint"));
    assertFalse(trie.startsWith(linterror));
    trie.insert(linterror);
    assertTrue(trie.search("lintcode"));
    assertTrue(trie.startsWith(linterror));
  }

  @Test void test_Lintcode473AddAndSearchWord() {
    Lintcode473AddAndSearchWord lintcode473AddAndSearchWord = new Lintcode473AddAndSearchWord();
    Lintcode473AddAndSearchWord.WordDictionary wordDictionary = lintcode473AddAndSearchWord.new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
    assertTrue(wordDictionary.search(".ad"));
    assertTrue(wordDictionary.search("b.."));
  }

  @Test void test_Lintcode423ValidParentheses() {
    Lintcode423ValidParentheses lintcode423ValidParentheses = new Lintcode423ValidParentheses();
    assertFalse(lintcode423ValidParentheses.isValidParentheses("["));
    assertTrue(lintcode423ValidParentheses.isValidParentheses("()"));
    assertTrue(lintcode423ValidParentheses.isValidParentheses("()[]{}"));
    assertFalse(lintcode423ValidParentheses.isValidParentheses("(]"));
    assertFalse(lintcode423ValidParentheses.isValidParentheses("([)]"));
  }

  @Test void testLC207CourseSchedule() {
    LC207CourseSchedule LC207CourseSchedule = new LC207CourseSchedule();
    assertTrue(LC207CourseSchedule.canFinish(2, new int[][]{
            {1, 0}
    }));
    assertFalse(LC207CourseSchedule.canFinish(2, new int[][]{
            {1, 0},
            {0, 1}
    }));
  }
}
