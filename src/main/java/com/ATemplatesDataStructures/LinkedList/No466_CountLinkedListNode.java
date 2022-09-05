package com.ATemplatesDataStructures.LinkedList;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No466_CountLinkedListNode {
  public static void main(String[] args) {
    No466_CountLinkedListNode No466_CountLinkedListNode = new No466_CountLinkedListNode();
    No466_CountLinkedListNode.testNo466_CountLinkedListNode();
  }

  private void testNo466_CountLinkedListNode() {
    log.info("result 0 v.s. " + countNodes(null));
    log.info("result 1 v.s. " + countNodes(new ListNode(1)));
  }

  int countNodes(ListNode head) {
    // filter abnormal cases
    if (head == null) {
      return 0;
    }

    int count = 1;
    while (head.next != null) {
      count++;
      head = head.next;
    }

    // return the final result
    return count;
  }

}
