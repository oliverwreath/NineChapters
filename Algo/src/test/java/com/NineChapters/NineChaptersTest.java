package com.NineChapters;

import com.NineChapters.TwoPointers.MustHashMap.Lintcode607TwoSumIiiDataStructureDesign;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class NineChaptersTest {

  @Test void testLintcode607TwoSumIiiDataStructureDesign() {
    Lintcode607TwoSumIiiDataStructureDesign lintcode607TwoSumIiiDataStructureDesign = new Lintcode607TwoSumIiiDataStructureDesign();
    Lintcode607TwoSumIiiDataStructureDesign.TwoSum twoSum = lintcode607TwoSumIiiDataStructureDesign.new TwoSum();
    twoSum.add(1);
    twoSum.add(3);
    twoSum.add(5);
    Assertions.assertTrue(twoSum.find(4));
    Assertions.assertFalse(twoSum.find(7));

    twoSum = lintcode607TwoSumIiiDataStructureDesign.new TwoSum();
    twoSum.add(2);
    twoSum.add(3);
    Assertions.assertFalse(twoSum.find(4));
    Assertions.assertTrue(twoSum.find(5));
    Assertions.assertFalse(twoSum.find(6));
    twoSum.add(3);
    Assertions.assertTrue(twoSum.find(6));
  }
}
