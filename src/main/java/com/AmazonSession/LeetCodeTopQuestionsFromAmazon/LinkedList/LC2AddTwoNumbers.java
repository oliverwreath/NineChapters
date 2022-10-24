package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Single loop adding up digits and handle carry along the way.
 * <p>
 * TIME: O(N) SPACE: O(N)
 * <p>
 * Version 2: TBD.
 */
@Slf4j
public class LC2AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // filter abnormal cases
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    // dp logic
    ListNode pre = new ListNode(-1);
    ListNode head = pre;
    short carry = 0;
    while (l1 != null || l2 != null) {
      head.next = new ListNode(-1);
      head = head.next;
      head.val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
      if (head.val > 9) {
        head.val -= 10;
        carry = 1;
      } else {
        carry = 0;
      }

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    // handle possible carry == 1
    if (carry == 1) {
      head.next = new ListNode(1);
    }

    // return the final result
    return pre.next;
  }

}
