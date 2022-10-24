package com.ATemplatesDataStructures.tmp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class TmpTest {

  @Test void test_no154RegularExpressionMatching() {
    No154RegularExpressionMatching no154RegularExpressionMatching = new No154RegularExpressionMatching();
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("aa", ".*"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("ab", ".*"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("aab", "c*a*b"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("aasdfasdfasdfasdfs", "aasdf.*asdf.*asdf.*asdf.*s"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("aasdf", "aasdf.*"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("", ".*"));
    Assertions.assertTrue(no154RegularExpressionMatching.isMatch("aaa", "a*a"));
  }
}
