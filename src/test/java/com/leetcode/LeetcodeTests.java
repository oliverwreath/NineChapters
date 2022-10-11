package com.leetcode;

import com.AmazonSession.leetcode.algorithms.LC199BinaryTreeRightSideView;
import com.AmazonSession.leetcode.algorithms.LC89GrayCode;
import com.leetcode.BinarySearch.LC153FindMinimumInRotatedSortedArrayBS;
import com.leetcode.BinarySearch.LC154FindMinimumInRotatedSortedArrayII;
import com.leetcode.LC133CloneGraph.Node;
import com.leetcode.Weekly124.LC993CousinsInBinaryTree;
import com.leetcode.Weekly124.LC994RottingOranges;
import com.leetcode.Weekly124.LC995MinimumNumberOfKConsecutiveBitFlips;
import com.leetcode.Weekly124.LC996NumberOfSquarefulArrays;
import com.leetcode.Weekly38.LC628MaximumProductOfThreeNumbers;
import com.leetcode.Weekly8.LC417PacificAtlanticWaterFlow;
import com.leetcode.Weekly_123.LC989ArrayForm;
import com.leetcode.Weekly_123.LC990SatisfiabilityOfEqualityEquations;
import com.leetcode.Weekly_123.LC991BrokenCalculator;
import com.leetcode.gg.LC146LRUCache;
import com.util.ListNode;
import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Oliver
 */
@Slf4j
class LeetcodeTests {
  @Test void testLC20ValidParentheses() {
    LC20ValidParentheses lc20ValidParentheses = new LC20ValidParentheses();
    assertTrue(lc20ValidParentheses.isValid(""));
    assertFalse(lc20ValidParentheses.isValid("("));
    assertFalse(lc20ValidParentheses.isValid("(}"));
    assertFalse(lc20ValidParentheses.isValid("{()[}"));
    assertTrue(lc20ValidParentheses.isValid("{()[()]}"));
  }

  @Test void testLC121MaxProfit() {
    LC121BestTimeToBuyAndSellStock lc121BestTimeToBuyAndSellStock = new LC121BestTimeToBuyAndSellStock();
    assertEquals(0, lc121BestTimeToBuyAndSellStock.maxProfit(new int[]{}));
    assertEquals(5, lc121BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(0, lc121BestTimeToBuyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
  }

  @Test void testLC128LongestConsecutiveSequence() {
    LC128LongestConsecutiveSequence lc128LongestConsecutiveSequence = new LC128LongestConsecutiveSequence();
    assertEquals(4, lc128LongestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    assertEquals(9, lc128LongestConsecutiveSequence.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
  }

  @Test void testLC33SearchInRotatedSortedArray() {
    LC33SearchInRotatedSortedArray lc33SearchInRotatedSortedArray = new LC33SearchInRotatedSortedArray();
    assertEquals(4, lc33SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    assertEquals(-1, lc33SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    assertEquals(-1, lc33SearchInRotatedSortedArray.search(new int[]{1}, 0));
  }

  @Test void test_LC153FindMinimumInRotatedSortedArray() {
    LC153FindMinimumInRotatedSortedArray lc153FindMinimumInRotatedSortedArray = new LC153FindMinimumInRotatedSortedArray();
    assertEquals(1, lc153FindMinimumInRotatedSortedArray.findMin(new int[]{3, 4, 5, 1, 2}));
    assertEquals(0, lc153FindMinimumInRotatedSortedArray.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    assertEquals(11, lc153FindMinimumInRotatedSortedArray.findMin(new int[]{11, 13, 15, 17}));
  }

  @Test void testLc125ValidPalindrome() {
    LC125ValidPalindrome lc125ValidPalindrome = new LC125ValidPalindrome();
    assertTrue(lc125ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(lc125ValidPalindrome.isPalindrome("race a car"));
    assertTrue(lc125ValidPalindrome.isPalindrome(" "));
    assertFalse(lc125ValidPalindrome.isPalindrome("0p"));
  }

  @Test void testLC153Sum() {
    LC15n3Sum lc15n3Sum = new LC15n3Sum();
    assertEquals(List.of(List.of(0, 0, 0)), lc15n3Sum.threeSum(new int[]{0, 0, 0}));
    assertEquals(Collections.emptyList(), lc15n3Sum.threeSum(new int[]{0, 1, 1}));
    assertEquals(List.of(List.of(-2, 0, 2)), lc15n3Sum.threeSum(new int[]{-2, 0, 0, 2, 2}));
    assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), lc15n3Sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }

  @Test void test_LC11ContainerWithMostWater() {
    LC11ContainerWithMostWater lc11ContainerWithMostWater = new LC11ContainerWithMostWater();
    assertEquals(49, lc11ContainerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, lc11ContainerWithMostWater.maxArea(new int[]{1, 1}));
    assertEquals(17, lc11ContainerWithMostWater.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
  }

  @Test void test_LC200NumberOfIslands() {
    LC200NumberOfIslands lc200NumberOfIslands = new LC200NumberOfIslands();

    assertEquals(1, lc200NumberOfIslands.numIslands(new char[][]{
            {'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}
    }));
    assertEquals(3, lc200NumberOfIslands.numIslands(new char[][]{
            {'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}
    }));
  }

  @Test void test_LC46Permutations() {
    LC46Permutations lc46Permutations = new LC46Permutations();
    assertEquals(List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)), lc46Permutations.permute(new int[]{1, 2, 3}));
  }

  @Test void test_LC996NumberOfSquarefulArrays() {
    LC996NumberOfSquarefulArrays lc996NumberOfSquarefulArrays = new LC996NumberOfSquarefulArrays();
    assertEquals(2, lc996NumberOfSquarefulArrays.numSquarefulPerms(new int[]{1, 17, 8}));
    assertEquals(1, lc996NumberOfSquarefulArrays.numSquarefulPerms(new int[]{2, 2, 2}));
  }

  @Test void testLC153FindMinimumInRotatedSortedArrayBS() {
    LC153FindMinimumInRotatedSortedArrayBS lc153FindMinimumInRotatedSortedArrayBS = new LC153FindMinimumInRotatedSortedArrayBS();
    assertEquals(0, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
    assertEquals(1, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 1));
    assertEquals(2, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 2));
    assertEquals(3, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 4));
    assertEquals(4, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 5));
    assertEquals(5, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 6));
    assertEquals(6, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 7));
    assertEquals(-1, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, -1));
    assertEquals(-1, lc153FindMinimumInRotatedSortedArrayBS.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 9));

    assertEquals(0, lc153FindMinimumInRotatedSortedArrayBS.findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
    assertEquals(0, lc153FindMinimumInRotatedSortedArrayBS.findMin(new int[]{7, 0, 1, 2, 4, 5, 6,}));
    assertEquals(0, lc153FindMinimumInRotatedSortedArrayBS.findMin(new int[]{6, 7, 0, 1, 2, 4, 5}));
  }

  @Test void testLC154FindMinimumInRotatedSortedArrayII() {
    LC154FindMinimumInRotatedSortedArrayII lc154FindMinimumInRotatedSortedArrayII = new LC154FindMinimumInRotatedSortedArrayII();
    assertEquals(0, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
    assertEquals(1, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 1));
    assertEquals(2, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 2));
    assertEquals(3, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 4));
    assertEquals(4, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 5));
    assertEquals(5, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 6));
    assertEquals(6, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 7));
    assertEquals(-1, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, -1));
    assertEquals(-1, lc154FindMinimumInRotatedSortedArrayII.binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 9));

    assertEquals(0, lc154FindMinimumInRotatedSortedArrayII.findMin(new int[]{0, 0, 2, 2, 5, 6, 6}));
    assertEquals(0, lc154FindMinimumInRotatedSortedArrayII.findMin(new int[]{6, 0, 0, 2, 2, 5, 6}));
    assertEquals(0, lc154FindMinimumInRotatedSortedArrayII.findMin(new int[]{6, 6, 0, 0, 2, 2, 5}));
  }

  @Test void testMedianFinder() {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    assertEquals(1, medianFinder.findMedian());
    medianFinder.addNum(5);
    assertEquals(3D, medianFinder.findMedian());
    medianFinder.addNum(9);
    assertEquals(5D, medianFinder.findMedian());

    medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    assertEquals(1.5D, medianFinder.findMedian());
    medianFinder.addNum(3);
    assertEquals(2D, medianFinder.findMedian());
  }

  @Test void testLC146LRUCache() {
    LC146LRUCache lc146LRUCache = new LC146LRUCache();
    LC146LRUCache.LRUCache cache = lc146LRUCache.new LRUCache(2 /* capacity */);
    cache.put(1, 1);
    cache.put(2, 2);
    Assertions.assertEquals(1, cache.get(1));
    cache.put(3, 3);
    Assertions.assertEquals(-1, cache.get(2));
    cache.put(4, 4);
    Assertions.assertEquals(-1, cache.get(1));
    Assertions.assertEquals(3, cache.get(3));
    Assertions.assertEquals(4, cache.get(4));
  }

  @Test void testLC133CloneGraph() {
    LC133CloneGraph lc133CloneGraph = new LC133CloneGraph();
    for (int i = 0; i < 10; i++) {
      assertEquals(lc133CloneGraph.new Node(i), lc133CloneGraph.cloneGraph(lc133CloneGraph.new Node(i)));
    }
    Node root = lc133CloneGraph.new Node();
    assertEquals(lc133CloneGraph.new Node(), lc133CloneGraph.cloneGraph(root));
    root.neighbors.add(lc133CloneGraph.new Node(3));
    assertEquals(root, lc133CloneGraph.cloneGraph(root));
  }

  @Test void testLC993CousinsInBinaryTree() {
    LC993CousinsInBinaryTree lc125ValidPalindrome = new LC993CousinsInBinaryTree();
    TreeNode root = new TreeNode(1);
    root.addLeft(2).addLeft(4);
    root.addRight(3);
    assertFalse(lc125ValidPalindrome.isCousins(root, 4, 3));
    root.left.left = null;
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(5);
    assertTrue(lc125ValidPalindrome.isCousins(root, 5, 4));
    root.right.right = null;
    assertFalse(lc125ValidPalindrome.isCousins(root, 2, 3));
  }

  @Test void testLC994RottingOranges() {
    LC994RottingOranges lc994RottingOranges = new LC994RottingOranges();
    assertEquals(4, lc994RottingOranges.orangesRotting(new int[][]{
            {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
    }));
    assertEquals(-1, lc994RottingOranges.orangesRotting(new int[][]{
            {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
    }));
    assertEquals(0, lc994RottingOranges.orangesRotting(new int[][]{
            {0, 2}
    }));
  }

  @Test void test_LC995MinimumNumberOfKConsecutiveBitFlips() {
    LC995MinimumNumberOfKConsecutiveBitFlips lc995MinimumNumberOfKConsecutiveBitFlips = new LC995MinimumNumberOfKConsecutiveBitFlips();
    assertEquals(2, lc995MinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{0, 1, 0}, 1));
    assertEquals(-1, lc995MinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{1, 1, 0}, 2));
    assertEquals(3, lc995MinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    assertEquals(-1, lc995MinimumNumberOfKConsecutiveBitFlips.minKBitFlips(new int[]{1, 0, 1}, 3));
  }

  @Test void test_LC989ArrayForm() {
    LC989ArrayForm lc989ArrayForm = new LC989ArrayForm();
    assertEquals(List.of(1, 2, 3, 4), lc989ArrayForm.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    assertEquals(List.of(4, 5, 5), lc989ArrayForm.addToArrayForm(new int[]{2, 7, 4}, 181));
    assertEquals(List.of(1, 0, 2, 1), lc989ArrayForm.addToArrayForm(new int[]{2, 1, 5}, 806));
    assertEquals(List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), lc989ArrayForm.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
  }

  @Test void test_LC990SatisfiabilityOfEqualityEquations() {
    LC990SatisfiabilityOfEqualityEquations lc990SatisfiabilityOfEqualityEquations = new LC990SatisfiabilityOfEqualityEquations();
    assertFalse(lc990SatisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b", "b!=a"}));
    assertTrue(lc990SatisfiabilityOfEqualityEquations.equationsPossible(new String[]{"b==a", "a==b"}));
    assertTrue(lc990SatisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
    assertFalse(lc990SatisfiabilityOfEqualityEquations.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
    assertTrue(lc990SatisfiabilityOfEqualityEquations.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
  }

  @Test void test_LC991BrokenCalculator() {
    LC991BrokenCalculator lc991BrokenCalculator = new LC991BrokenCalculator();
    assertEquals(2, lc991BrokenCalculator.brokenCalc(2, 3));
    assertEquals(2, lc991BrokenCalculator.brokenCalc(5, 8));
    assertEquals(3, lc991BrokenCalculator.brokenCalc(3, 10));
    assertEquals(1023, lc991BrokenCalculator.brokenCalc(1024, 1));
    assertEquals(39, lc991BrokenCalculator.brokenCalc(1, 1000000000));
  }

  @Test void test_LC628MaximumProductOfThreeNumbers() {
    LC628MaximumProductOfThreeNumbers lc628MaximumProductOfThreeNumbers = new LC628MaximumProductOfThreeNumbers();
    assertEquals(-6, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1, -2, -3, -4}));
    assertEquals(6, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{-1, 2, -3}));
    assertEquals(6, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{1, 2, 3}));
    assertEquals(24, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{1, 2, 3, 4}));
    assertEquals(6, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{1, 2, 3, -4}));
    assertEquals(8, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{1, 2, -3, 4}));
    assertEquals(12, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{1, -2, 3, 4}));
    assertEquals(24, lc628MaximumProductOfThreeNumbers.maximumProduct(new int[]{1, -2, 3, -4}));
  }

  @Test void testLC199BinaryTreeRightSideView() {
    LC199BinaryTreeRightSideView lc199BinaryTreeRightSideView = new LC199BinaryTreeRightSideView();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    assertEquals(List.of(1, 2), lc199BinaryTreeRightSideView.rightSideView(root));
  }

  @Test void testLC89GrayCode() {
    LC89GrayCode lc89GrayCode = new LC89GrayCode();
    assertEquals(0, lc89GrayCode.binaryString2Int("00"));
    assertEquals(1, lc89GrayCode.binaryString2Int("01"));
    assertEquals(3, lc89GrayCode.binaryString2Int("11"));
    assertEquals(2, lc89GrayCode.binaryString2Int("10"));

    assertEquals(0, lc89GrayCode.binaryString2Int("000"));
    assertEquals(1, lc89GrayCode.binaryString2Int("001"));
    assertEquals(3, lc89GrayCode.binaryString2Int("011"));
    assertEquals(2, lc89GrayCode.binaryString2Int("010"));

    assertEquals(6, lc89GrayCode.binaryString2Int("110"));
    assertEquals(7, lc89GrayCode.binaryString2Int("111"));
    assertEquals(5, lc89GrayCode.binaryString2Int("101"));
    assertEquals(4, lc89GrayCode.binaryString2Int("100"));

    assertEquals(List.of(0), lc89GrayCode.grayCode(-1));
    assertEquals(List.of(0), lc89GrayCode.grayCode(0));
    assertEquals(List.of(0, 1), lc89GrayCode.grayCode(1));
    assertEquals(List.of(0, 1, 3, 2), lc89GrayCode.grayCode(2));
    assertEquals(List.of(0, 1, 3, 2, 6, 7, 5, 4), lc89GrayCode.grayCode(3));
    assertEquals(List.of(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8), lc89GrayCode.grayCode(4));
    assertEquals(List.of(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16), lc89GrayCode.grayCode(5));
//    for (int i = -1; i < 6; i++) {
//      log.info("grayCode({}) = {}", i, lc89GrayCode.grayCode(i));
//    }
  }

  @Test void testLC1329SortTheMatrixDiagonally() {
    LC1329SortTheMatrixDiagonally lc1329SortTheMatrixDiagonally = new LC1329SortTheMatrixDiagonally();
    assertArrayEquals(new int[][]{{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}}, lc1329SortTheMatrixDiagonally.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}}));
    assertArrayEquals(new int[][]{{5, 17, 4, 1, 52, 7}, {11, 11, 25, 45, 8, 69}, {14, 23, 25, 44, 58, 15}, {22, 27, 31, 36, 50, 66}, {84, 28, 75, 33, 55, 68}}, lc1329SortTheMatrixDiagonally.diagonalSort(new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}}));
  }

  @Test void testLC417PacificAtlanticWaterFlow() {
    LC417PacificAtlanticWaterFlow lc417PacificAtlanticWaterFlow = new LC417PacificAtlanticWaterFlow();
    assertEquals(List.of(List.of(0,0),List.of(0,1),List.of(1,0),List.of(1,1)), lc417PacificAtlanticWaterFlow.pacificAtlantic(new int[][]{
            {2, 1},
            {1, 2}
    }));
    assertEquals(List.of(List.of(0,4),List.of(1,3),List.of(1,4),List.of(2,2),List.of(3,0),List.of(3,1),List.of(4,0)), lc417PacificAtlanticWaterFlow.pacificAtlantic(new int[][]{
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
    }));
    assertEquals(List.of(List.of(0, 1), List.of(1, 0), List.of(1, 1)), lc417PacificAtlanticWaterFlow.pacificAtlantic(new int[][]{
            {1, 2},
            {4, 3}
    }));
  }

  @Test void testLC48RotateImage() {
    testLC48RotateImage(LC48RotateImage::rotate);
    testLC48RotateImage(LC48RotateImage::rotate2);
  }

  private static void testLC48RotateImage(BiConsumer<LC48RotateImage, int[][]> rotate) {
    LC48RotateImage lc48RotateImage = new LC48RotateImage();
    int[][] ints = {
            {3, 6, 9},
            {2, 5, 8},
            {1, 4, 7}
    };
    rotate.accept(lc48RotateImage, ints);
    assertArrayEquals(ints, new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    });
    ints = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    rotate.accept(lc48RotateImage, ints);
    assertArrayEquals(ints, new int[][]{
            {7,4,1},
            {8,5,2},
            {9,6,3}
    });
    ints = new int[][]{
            {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
    };
    rotate.accept(lc48RotateImage, ints);
    assertArrayEquals(ints, new int[][]{
            {15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}
    });
  }

  @Test void testLC86PartitionList() {
    LC86PartitionList lc86PartitionList = new LC86PartitionList();
    ListNode head = new ListNode(new int[]{1,4,3,2,5,2});
    ListNode expected = new ListNode(new int[]{1,2,2,4,3,5});
    assertEquals(expected, lc86PartitionList.partition(head, 3));
    head = new ListNode(new int[]{2,1});
    expected = new ListNode(new int[]{1,2});
    assertEquals(expected, lc86PartitionList.partition(head, 2));
  }

  @Test void testLC876MiddleOfTheLinkedList() {
    LC876MiddleOfTheLinkedList lc876MiddleOfTheLinkedList = new LC876MiddleOfTheLinkedList();
    ListNode head = new ListNode(new int[]{1,2,3,4,5});
    ListNode expected = new ListNode(new int[]{3,4,5});
    assertEquals(expected, lc876MiddleOfTheLinkedList.middleNode(head));
    head = new ListNode(new int[]{1,2,3,4,5,6});
    expected = new ListNode(new int[]{4,5,6});
    assertEquals(expected, lc876MiddleOfTheLinkedList.middleNode(head));
  }

  @Test void testLC206ReverseLinkedList() {
    LC206ReverseLinkedList lc206ReverseLinkedList = new LC206ReverseLinkedList();
    ListNode head = new ListNode(new int[]{1,2,3,4,5});
    ListNode expected = new ListNode(new int[]{5,4,3,2,1});
    assertEquals(expected, lc206ReverseLinkedList.reverseList(head));
    head = new ListNode(new int[]{1,2,3,4,5,6});
    expected = new ListNode(new int[]{6,5,4,3,2,1});
    assertEquals(expected, lc206ReverseLinkedList.reverseList(head));
  }

  @Test void testLC92ReverseLinkedListII() {
    LC92ReverseLinkedListII lc92ReverseLinkedListII = new LC92ReverseLinkedListII();
    ListNode head = new ListNode(new int[]{1,2,3,4,5});
    ListNode expected = new ListNode(new int[]{5,4,3,2,1});
    assertEquals(expected, lc92ReverseLinkedListII.reverseBetween(head, 1, 5));
    head = new ListNode(new int[]{1,2,3,4,5,6});
    expected = new ListNode(new int[]{1,5,4,3,2,6});
    assertEquals(expected, lc92ReverseLinkedListII.reverseBetween(head, 2, 5));
  }

  @Test void testLC104MaximumDepthOfBinaryTree() {
    LC104MaximumDepthOfBinaryTree lc104MaximumDepthOfBinaryTree = new LC104MaximumDepthOfBinaryTree();
    TreeNode root = new TreeNode(3);
    root.addLeft(9);
    TreeNode right = root.addRight(20);
    right.addLeft(15);
    right.addRight(7);
    assertEquals(3, lc104MaximumDepthOfBinaryTree.maxDepth(root));
  }

  @Test void testLC543DiameterOfBinaryTree() {
    LC543DiameterOfBinaryTree lc543DiameterOfBinaryTree = new LC543DiameterOfBinaryTree();
    TreeNode root = new TreeNode(1);
    root.addLeft(2);
    assertEquals(1, lc543DiameterOfBinaryTree.diameterOfBinaryTree(root));
    root = new TreeNode(1);
    root.addLeft(2).addLeft(4);
    assertEquals(2, lc543DiameterOfBinaryTree.diameterOfBinaryTree(root));
    root = new TreeNode(3);
    root.addLeft(9);
    TreeNode right = root.addRight(20);
    right.addLeft(15);
    right.addRight(7);
    root.printTree();
    assertEquals(3, lc543DiameterOfBinaryTree.diameterOfBinaryTree(root));
    root = new TreeNode(3);
    root.addLeft(9).addLeft(1).addLeft(2).addLeft(3).addLeft(4);
    right = root.addRight(20);
    right.addLeft(15).addLeft(16).addLeft(17).addLeft(18);
    right.addRight(7).addRight(8).addRight(9).addRight(10);
    root.printTree();
    assertEquals(10, lc543DiameterOfBinaryTree.diameterOfBinaryTree(root));
  }
}
