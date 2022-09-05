package com.AdvancedAlgorithms;

import com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearch.Lintcode75FindPeakElement;
import com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearchOnResult.Lintcode141Sqrtx;
import com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearchOnResult.Lintcode586SqrtxII;
import com.AdvancedAlgorithms.BinarySearchSweepLineHard.Deque.Lintcode362SlidingWindowMaximum;
import com.AdvancedAlgorithms.DP_I.GameDP.Lintcode394CoinsInALine;
import com.AdvancedAlgorithms.DP_I.GameDP.Lintcode395CoinsInALineII;
import com.AdvancedAlgorithms.DP_I.Interval.Lintcode168BurstBalloons;
import com.AdvancedAlgorithms.DP_I.Lintcode110MinimumPathSum;
import com.AdvancedAlgorithms.DP_I.Lintcode436MaximalSquare;
import com.AdvancedAlgorithms.DP_II.Backpack.Lintcode125BackpackII;
import com.AdvancedAlgorithms.DP_II.Backpack.Lintcode440BackpackIII;
import com.AdvancedAlgorithms.DP_II.Backpack.Lintcode92Backpack;
import com.AdvancedAlgorithms.DP_II.TwoSequence.Lintcode119EditDistance;
import com.AdvancedAlgorithms.DP_II.TwoSequence.Lintcode29InterleavingString;
import com.AdvancedAlgorithms.DP_II.TwoSequence.Lintcode77LongestCommonSubsequence;
import com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue.Lintcode360SlidingWindowMedian;
import com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue.Lintcode364TrappingRainWaterII;
import com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue.Lintcode81FindMedianFromDataStream;
import com.AdvancedAlgorithms.HeapStack.Stack.Lintcode12MinStack;
import com.AdvancedAlgorithms.HeapStack.Stack.Lintcode575DecodeString;
import com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack.Lintcode122LargestRectangleInHistogram;
import com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack.Lintcode510MaximalRectangle;
import com.AdvancedAlgorithms.Memoization.Lintcode398LongestContinuousIncreasingSubsequenceII;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.oneOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Oliver
 */
@Slf4j
class AdvancedAlgorithmsTest {
  @Test void test_Lintcode586SqrtxII() {
    Lintcode586SqrtxII lintcode586SqrtxII = new Lintcode586SqrtxII();
    assertEquals(0D, lintcode586SqrtxII.sqrt(0));
    assertEquals(1.4142135623733338D, lintcode586SqrtxII.sqrt(2));
    assertEquals(0.3162277660176187D, lintcode586SqrtxII.sqrt(0.1));
  }

  @Test void testSqrtx_141() {
    Lintcode141Sqrtx lintcode141Sqrtx = new Lintcode141Sqrtx();
    assertEquals(0, lintcode141Sqrtx.sqrt(0));
    assertEquals(1, lintcode141Sqrtx.sqrt(3));
    assertEquals(2, lintcode141Sqrtx.sqrt(4));
  }

  @Test void testLintcode394CoinsInALine() {
    Lintcode394CoinsInALine lintcode394CoinsInALine = new Lintcode394CoinsInALine();
    Assertions.assertTrue(lintcode394CoinsInALine.firstWillWin(1));
    Assertions.assertTrue(lintcode394CoinsInALine.firstWillWin(2));
    Assertions.assertFalse(lintcode394CoinsInALine.firstWillWin(3));
    Assertions.assertTrue(lintcode394CoinsInALine.firstWillWin(4));
    Assertions.assertTrue(lintcode394CoinsInALine.firstWillWin(5));
  }

  @Test void testLintcode92Backpack() {
    Lintcode92Backpack lintcode92Backpack = new Lintcode92Backpack();
    assertEquals(10, lintcode92Backpack.backPack(11, new int[]{2, 3, 5, 7}));
    assertEquals(12, lintcode92Backpack.backPack(12, new int[]{2, 3, 5, 7}));
    assertEquals(83, lintcode92Backpack.backPack(90, new int[]{12, 3, 7, 4, 5, 13, 2, 8, 4, 7, 6, 5, 7}));
  }

  @Test void testLintcode29InterleavingString() {
    Lintcode29InterleavingString lintcode29InterleavingString = new Lintcode29InterleavingString();
    Assertions.assertFalse(lintcode29InterleavingString.isInterleave("", "", "1"));
    Assertions.assertTrue(lintcode29InterleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    Assertions.assertFalse(lintcode29InterleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
  }

  @Test void testLintcode81FindMedianFromDataStream() {
    Lintcode81FindMedianFromDataStream lintcode81FindMedianFromDataStream = new Lintcode81FindMedianFromDataStream();
    assertArrayEquals(new int[]{1, 1, 2, 2, 3}, lintcode81FindMedianFromDataStream.medianII(new int[]{1, 2, 3, 4, 5}));
    assertArrayEquals(new int[]{4, 4, 4, 3, 3, 3, 3}, lintcode81FindMedianFromDataStream.medianII(new int[]{4, 5, 1, 3, 2, 6, 0}));
    assertArrayEquals(new int[]{2, 2, 20}, lintcode81FindMedianFromDataStream.medianII(new int[]{2, 20, 100}));
  }

  @Test void testLintcode12MinStack() {
    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
    Lintcode12MinStack.MinStack minStack = lintcode12MinStack.new MinStack();
    minStack.push(3);
    assertEquals(3, minStack.min());
    minStack.push(1);
    assertEquals(1, minStack.min());
    assertEquals(1, minStack.pop());
    assertEquals(3, minStack.min());
  }

  @Test void testLintcode75FindPeakElement() {
    Lintcode75FindPeakElement lintcode75FindPeakElement = new Lintcode75FindPeakElement();
    assertThat(lintcode75FindPeakElement.findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6}), is(oneOf(1, 6)));
  }

  @Test void testLintcode362SlidingWindowMaximum() {
    Lintcode362SlidingWindowMaximum lintcode362SlidingWindowMaximum = new Lintcode362SlidingWindowMaximum();
    assertEquals(List.of(7, 7, 8), lintcode362SlidingWindowMaximum.maxSlidingWindow(new int[]{1, 2, 7, 7, 8}, 3));
  }

  @Test void testLintcode436MaximalSquare() {
    Lintcode436MaximalSquare lintcode436MaximalSquare = new Lintcode436MaximalSquare();
    assertEquals(4, lintcode436MaximalSquare.maxSquare(new int[][]{
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
    }));
  }

  @Test void testLintcode119EditDistance() {
    Lintcode119EditDistance lintcode119EditDistance = new Lintcode119EditDistance();
    assertEquals(3, lintcode119EditDistance.minDistance("mart", "karma"));
    assertEquals(1, lintcode119EditDistance.minDistance("b", ""));
  }

  @Test void testLintcode122LargestRectangleInHistogram() {
    Lintcode122LargestRectangleInHistogram lintcode122LargestRectangleInHistogram = new Lintcode122LargestRectangleInHistogram();
    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }

  @Test void testLintcode510MaximalRectangle() {
    Lintcode510MaximalRectangle lintcode510MaximalRectangle = new Lintcode510MaximalRectangle();
    assertEquals(6, lintcode510MaximalRectangle.maximalRectangle(
            new boolean[][]{
                    {true, true, false, false, true},
                    {false, true, false, false, true},
                    {false, false, true, true, true},
                    {false, false, true, true, true},
                    {false, false, false, false, true}
            }
    ));
  }

  @Test void testLintcode575DecodeString() {
    Lintcode575DecodeString lintcode575DecodeString = new Lintcode575DecodeString();
    assertEquals("adadpfpfpfadadpfpfpfadadpfpfpfxyz", lintcode575DecodeString.expressionExpand("3[2[ad]3[pf]]xyz"));
  }

  @Test void testLintcode395CoinsInALineII() {
    Lintcode395CoinsInALineII lintcode395CoinsInALineII = new Lintcode395CoinsInALineII();
    assertTrue(lintcode395CoinsInALineII.firstWillWin(new int[]{1, 2, 2}));
    assertFalse(lintcode395CoinsInALineII.firstWillWin(new int[]{1, 2, 4}));
  }

  @Test void testLintcode168BurstBalloons() {
    Lintcode168BurstBalloons lintcode168BurstBalloons = new Lintcode168BurstBalloons();
    assertEquals(270, lintcode168BurstBalloons.maxCoins(new int[]{4, 1, 5, 10}));
  }

  @Test void testLintcode110MinimumPathSum() {
    Lintcode110MinimumPathSum lintcode110MinimumPathSum = new Lintcode110MinimumPathSum();
    assertEquals(7, lintcode110MinimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    assertEquals(6, lintcode110MinimumPathSum.minPathSum(new int[][]{{1, 3, 2}}));
  }

  @Test void testLintcode125BackpackII() {
    Lintcode125BackpackII lintcode125BackpackII = new Lintcode125BackpackII();
    assertEquals(9, lintcode125BackpackII.backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
  }

  @Test void testLintcode440BackpackIII() {
    Lintcode440BackpackIII lintcode440BackpackIII = new Lintcode440BackpackIII();
    assertEquals(15, lintcode440BackpackIII.backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
  }

  @Test void testLintcode77LongestCommonSubsequence() {
    Lintcode77LongestCommonSubsequence lintcode77LongestCommonSubsequence = new Lintcode77LongestCommonSubsequence();
    assertEquals(1, lintcode77LongestCommonSubsequence.longestCommonSubsequence("ABCD", "EDCA"));
    assertEquals(2, lintcode77LongestCommonSubsequence.longestCommonSubsequence("ABCD", "EACB"));
  }

  @Test void testLintcode360SlidingWindowMedian() {
    Lintcode360SlidingWindowMedian lintcode360SlidingWindowMedian = new Lintcode360SlidingWindowMedian();
    assertEquals(List.of(2,7,7), lintcode360SlidingWindowMedian.medianSlidingWindow(new int[]{1, 2, 7, 8, 5}, 3));
    assertEquals(List.of(1,2,7,2,2,3,3,4), lintcode360SlidingWindowMedian.medianSlidingWindow(new int[]{1, 2, 7, 7, 2, 10, 3, 4, 5}, 2));
  }

  @Test void testLintcode364TrappingRainWaterII() {
    Lintcode364TrappingRainWaterII lintcode364TrappingRainWaterII = new Lintcode364TrappingRainWaterII();
    assertEquals(14, lintcode364TrappingRainWaterII.trapRainWater(new int[][]{
            {12, 13, 0, 12},
            {13, 4, 13, 12},
            {13, 8, 10, 12},
            {12, 13, 12, 12},
            {13, 13, 13, 13}})
    );
  }

  @Test void testLintcode398LongestContinuousIncreasingSubsequenceII() {
    Lintcode398LongestContinuousIncreasingSubsequenceII lintcode398LongestContinuousIncreasingSubsequenceII = new Lintcode398LongestContinuousIncreasingSubsequenceII();
    assertEquals(25, lintcode398LongestContinuousIncreasingSubsequenceII.longestContinuousIncreasingSubsequence2(new int[][]{
            {1, 2, 3, 4, 5},
            {16, 17, 24, 23, 6},
            {15, 18, 25, 22, 7},
            {14, 19, 20, 21, 8},
            {13, 12, 11, 10, 9}
    }));
  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }

//  @Test void testLintcode12MinStack() {
//    Lintcode12MinStack lintcode12MinStack = new Lintcode12MinStack();
//    assertEquals(10, lintcode122LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//  }
}
