package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Putting everything into a minHeap, then retrieve them in order.
 * <p>
 * TIME: O(N logN)
 * SPACE: O(N)
 * <p>
 * Version 2: TBD.
 */
@Slf4j
public class LC23MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;

    ListNode dummy = new ListNode(-1), scanner = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
    for (ListNode node : lists) {
      if (node != null)
        pq.add(node);
    }
    while (!pq.isEmpty()) {
      ListNode nextSmallest = pq.poll();
      if (nextSmallest.next != null)
        pq.add(nextSmallest.next);
      scanner.next = nextSmallest;
      scanner = scanner.next;
    }
    return dummy.next;
  }
}
