package com.Tools;

import com.ATemplatesDataStructures.Trie.LintCode442ImplementTrie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class ToolsTest {
  @Test void test_No442ImplementTrie() {
    LintCode442ImplementTrie lintCode442ImplementTrie = new LintCode442ImplementTrie();
    LintCode442ImplementTrie.Trie trie = lintCode442ImplementTrie.new Trie();
    final String linterror = "linterror";
    trie.insert("lintcode");
    Assertions.assertFalse(trie.search("code"));
    Assertions.assertTrue(trie.startsWith("lint"));
    Assertions.assertFalse(trie.startsWith(linterror));
    trie.insert(linterror);
    Assertions.assertTrue(trie.search("lintcode"));
    Assertions.assertTrue(trie.startsWith(linterror));
  }
}
