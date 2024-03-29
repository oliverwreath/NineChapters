package com.lintcode.LinkedList;

import com.lintcode.ListNode;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Lintcode103LinkedListCycleII {

  public ListNode detectCycle(ListNode head) {
    if (head == null)
      return null;

    HashSet<ListNode> visited = new HashSet<>();
    ListNode iterator = head;
    while (iterator != null) {
      if (visited.contains(iterator))
        return iterator;

      visited.add(iterator);
      iterator = iterator.next;
    }

    return null;
  }
}
