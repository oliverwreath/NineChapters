package com.lintcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.lintcode.Advanced.Heap.DataStreamMedian;
import com.lintcode.BinarySearch1.Lintcode460KClosestNumbers;
import com.lintcode.LinkedList.Lintcode103LinkedListCycleII;
import com.lintcode.LinkedList.Lintcode105CopyListWithRandomPointer;
import com.lintcode.LinkedList.RandomListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class LintcodeTest {

  @Test void testLintcode460KClosestNumbers() {
    Lintcode460KClosestNumbers lintcode460KClosestNumbers = new Lintcode460KClosestNumbers();
    assertArrayEquals(new int[]{2, 1, 3}, lintcode460KClosestNumbers.kClosestNumbers(new int[]{1, 2, 3}, 2, 3));
    assertArrayEquals(new int[]{4, 1, 6}, lintcode460KClosestNumbers.kClosestNumbers(new int[]{1, 4, 6, 8}, 3, 3));
    assertArrayEquals(new int[]{2, 4, 1, 6},
        lintcode460KClosestNumbers.kClosestNumbers(new int[]{1, 2, 4, 6, 8}, 3, 4));
  }

  @Test void testDataStreamMedian() {
    DataStreamMedian dataStreamMedian = new DataStreamMedian();
    assertArrayEquals(new int[]{1, 1, 2, 2, 3}, dataStreamMedian.medianII(new int[]{1, 2, 3, 4, 5}));
    assertArrayEquals(new int[]{4, 4, 4, 3, 3, 3, 3}, dataStreamMedian.medianII(new int[]{4, 5, 1, 3, 2, 6, 0}));
    assertArrayEquals(new int[]{2, 2, 20}, dataStreamMedian.medianII(new int[]{2, 20, 100}));
  }

  @Test void testBinarySearch() {
    searchInsertTest();
    searchMatrixTest();
    binarySearchTest();
    findMinTest();
    testSearchBigSortedArray();
    testSearchRange();
    testTotalOccurrence();
  }

  private void searchInsertTest() {
    int[] A = {1, 3, 5, 6};
    assertEquals(2, BinarySearch.searchInsert(A, 5));
    assertEquals(1, BinarySearch.searchInsert(A, 2));
    assertEquals(4, BinarySearch.searchInsert(A, 7));
    assertEquals(0, BinarySearch.searchInsert(A, 0));
  }

  private static void searchMatrixTest() {
    int[][] matrix = {{1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}};
    int target = 3;
    assertEquals(-1, BinarySearch.searchMatrix(matrix, target));
  }

  private void binarySearchTest() {
    int[] ints = {1, 2, 3, 3, 4, 5, 10};
    for (int i = 1; i < 11; i++) {
      log.debug("{}", BinarySearch.binarySearch(ints, i));
//      assertEquals(0, BinarySearch.binarySearch(ints, i));
    }
    int[] ints2 = {1, 3, 5, 7};
    assertEquals(1, BinarySearch.binarySearch(ints2, 3));
  }

  private void findMinTest() {
    assertArrayEquals(new int[]{4, 0}, BinarySearch.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    assertArrayEquals(new int[]{3, -1}, BinarySearch.findMin(new int[]{4, 5, 6, -1, 0, 1, 2}));
    assertArrayEquals(new int[]{2, -2}, BinarySearch.findMin(new int[]{4, 5, -2, -1, 0, 1, 2}));
    assertArrayEquals(new int[]{8, 999},
        BinarySearch.findMin(new int[]{999, 999, 1000, 1000, 10000, 0, 999, 999, 999}));
  }

  private void testSearchBigSortedArray() {
    for (int i = 0; i < 10; i++) {
      log.debug(i + ": " + BinarySearch.searchBigSortedArray(new BinarySearch.ArrayReader(), i));
    }
  }

  private void testSearchRange() {
    assertArrayEquals(new int[]{3, 4}, BinarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
  }

  private void testTotalOccurrence() {
    assertEquals(2, BinarySearch.totalOccurrence(new int[]{5, 7, 7, 8, 8, 10}, 8));
  }

  @Test void testLintcode105CopyListWithRandomPointer() {
    Lintcode105CopyListWithRandomPointer lintcode105CopyListWithRandomPointer = new Lintcode105CopyListWithRandomPointer();
    RandomListNode head = new RandomListNode(1);
    head.addNext(2).addNext(3);
    head.random = head.next.next;
    head.next.random = head;
    head.next.next.random = head.next;
    log.info("result = {}", lintcode105CopyListWithRandomPointer.copyRandomList(head));

    head = new RandomListNode(-1);
    head.addNext(0).addNext(2);
    RandomListNode expected = new RandomListNode(-1);
    expected.addNext(0).addNext(2);
    assertEquals(expected, lintcode105CopyListWithRandomPointer.copyRandomList(head));
  }

  @Test void testLintcode103LinkedListCycleII() {
    Lintcode103LinkedListCycleII lintcode103LinkedListCycleII = new Lintcode103LinkedListCycleII();
    ListNode head = new ListNode(-1);
    head.addNext(0).addNext(2);
    assertNull(lintcode103LinkedListCycleII.detectCycle(head));

    head = new ListNode(-21);
    ListNode last = head.addNext(10).addNext(4).addNext(5);
    last.next = head.next;//point tail to 1, creating a cycle
    assertNotNull(lintcode103LinkedListCycleII.detectCycle(head));

    head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = head.next;
    assertEquals(head.next, lintcode103LinkedListCycleII.detectCycle(head));
  }
}
