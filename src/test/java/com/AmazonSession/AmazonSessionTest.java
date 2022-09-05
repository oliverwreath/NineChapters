package com.AmazonSession;

import com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming.LC121BestTimeToBuyAndSellStock;
import com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming.LC53MaximumSubarray;
import com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming.LC70ClimbingStairs;
import com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList.LC160IntersectionOfTwoLinkedLists;
import com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList.LC23MergeKSortedLists;
import com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList.LC2AddTwoNumbers;
import com.AmazonSession.leetcode.algorithms.LC21MergeTwoSortedLists;
import com.AmazonSession.leetcode.algorithms.LC223RectangleArea;
import com.AmazonSession.leetcode.algorithms.LC234PalindromeLinkedList;
import com.AmazonSession.leetcode.algorithms.LC396RotateFunction;
import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Oliver
 */
@Slf4j
class AmazonSessionTest {
  @Test void testLC121BestTimeToBuyAndSellStock() {
    LC121BestTimeToBuyAndSellStock lintcode12MinStack = new LC121BestTimeToBuyAndSellStock();
    assertEquals(5, lintcode12MinStack.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    assertEquals(0, lintcode12MinStack.maxProfit(new int[]{7, 6, 4, 3, 1}));
  }

  @Test void testLC70ClimbingStairs() {
    LC70ClimbingStairs lc70ClimbingStairs = new LC70ClimbingStairs();
    assertEquals(2, lc70ClimbingStairs.climbStairs(2));
    assertEquals(3, lc70ClimbingStairs.climbStairs(3));
  }

  @Test void testLC53MaximumSubarray() {
    LC53MaximumSubarray lc53MaximumSubarray = new LC53MaximumSubarray();
    assertEquals(6, lc53MaximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  @Test void testLC2AddTwoNumbers() {
    LC2AddTwoNumbers lc2AddTwoNumbers = new LC2AddTwoNumbers();
    ListNode node = new ListNode(0);
    ListNode node2 = new ListNode(0);
    ListNode expected = new ListNode(0);
    assertEquals(expected, lc2AddTwoNumbers.addTwoNumbers(node, node2));

    node = new ListNode(new int[]{2,4,3});
    node2 = new ListNode(new int[]{5,6,4});
    expected = new ListNode(new int[]{7,0,8});
    assertEquals(expected, lc2AddTwoNumbers.addTwoNumbers(node, node2));

    node = new ListNode(new int[]{2,4,3});
    node2 = new ListNode(new int[]{5,6,6});
    expected = new ListNode(new int[]{7,0,0,1});
    assertEquals(expected, lc2AddTwoNumbers.addTwoNumbers(node, node2));

    node = new ListNode(new int[]{9,9,9,9,9,9,9});
    node2 = new ListNode(new int[]{9,9,9,9});
    expected = new ListNode(new int[]{8,9,9,9,0,0,0,1});
    assertEquals(expected, lc2AddTwoNumbers.addTwoNumbers(node, node2));
  }

  @Test void testLC160IntersectionOfTwoLinkedLists() {
    LC160IntersectionOfTwoLinkedLists lc160IntersectionOfTwoLinkedLists = new LC160IntersectionOfTwoLinkedLists();
    ListNode node = new ListNode(new int[]{2,4,3});
    ListNode node2 = new ListNode(5);
    node2.addNext(6).next = node.next.next;
    ListNode expected = new ListNode(3);
    assertEquals(expected, lc160IntersectionOfTwoLinkedLists.getIntersectionNode(node, node2));
  }

  @Test void testLC23MergeKSortedLists() {
    LC23MergeKSortedLists lc23MergeKSortedLists = new LC23MergeKSortedLists();
    assertNull(lc23MergeKSortedLists.mergeKLists(new ListNode[0]));

    assertNull(lc23MergeKSortedLists.mergeKLists(new ListNode[]{null}));

    ListNode expected = new ListNode(3);
    assertEquals(expected, lc23MergeKSortedLists.mergeKLists(new ListNode[]{expected}));

//    Output: [1,1,2,3,4,4,5,6]
    ListNode node = new ListNode(new int[]{1,4,5});
    ListNode node2 = new ListNode(new int[]{1,3,4});
    ListNode node3 = new ListNode(new int[]{2,6});
    expected = new ListNode(new int[]{1,1,2,3,4,4,5,6});
    assertEquals(expected, lc23MergeKSortedLists.mergeKLists(new ListNode[]{node, node2, node3}));

    node = new ListNode(new int[]{2,4,3});
    node2 = new ListNode(new int[]{5,6,6});
    expected = new ListNode(new int[]{2,4,3,5,6,6});
    assertEquals(expected, lc23MergeKSortedLists.mergeKLists(new ListNode[]{node, node2}));
  }

  @Test void testLC21MergeTwoSortedLists() {
    LC21MergeTwoSortedLists lc21MergeTwoSortedLists = new LC21MergeTwoSortedLists();
    assertNull(lc21MergeTwoSortedLists.mergeTwoLists(null, null));
    ListNode l1 = new ListNode(1);
    l1.addNext(3);
    ListNode l2 = new ListNode(2);
    l2.addNext(4);
    ListNode expected = new ListNode(1);
    expected.addNext(2).addNext(3).addNext(4);
    assertEquals(expected, lc21MergeTwoSortedLists.mergeTwoLists(l1, l2));
  }

  @Test void testLC234PalindromeLinkedList() {
    LC234PalindromeLinkedList lc234PalindromeLinkedList = new LC234PalindromeLinkedList();
    ListNode head = new ListNode(3);
    head.next = new ListNode(5);
    head.next.next = new ListNode(4);
    assertFalse(lc234PalindromeLinkedList.isPalindrome(head));
  }

  @Test void testLC223RectangleArea() {
    LC223RectangleArea lc223RectangleArea = new LC223RectangleArea();
    assertEquals(45, getLc223RectangleArea(lc223RectangleArea, new int[]{-3, 0, 3, 4, 0, -1, 9, 2}));
    assertEquals(4, getLc223RectangleArea(lc223RectangleArea, new int[]{0, 0, 0, 0, -1, -1, 1, 1}));
    assertEquals(16, getLc223RectangleArea(lc223RectangleArea, new int[]{-2, -2, 2, 2, -2, -2, 2, 2}));
    assertEquals(2, getLc223RectangleArea(lc223RectangleArea, new int[]{-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1}));
    assertEquals(19, getLc223RectangleArea(lc223RectangleArea, new int[]{-2, -2, 2, 2, 1, -3, 3, -1}));
  }

  private static int getLc223RectangleArea(LC223RectangleArea lc223RectangleArea, int[] a) {
    return lc223RectangleArea.computeArea(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]);
  }

  @Test void testLC396RotateFunction() {
    LC396RotateFunction lc396RotateFunction = new LC396RotateFunction();
    assertEquals(26, lc396RotateFunction.maxRotateFunction(new int[]{4, 3, 2, 6}));
  }
}
