package com.lintcode.LinkedList;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Lintcode105CopyListWithRandomPointer {

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }

    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newPre = new RandomListNode(-1);
    {
      RandomListNode nodeIterator = head;
      RandomListNode newPreIterator = newPre;
      while (nodeIterator != null) {
        newPreIterator.next = new RandomListNode(nodeIterator.label);
        newPreIterator.next.random = nodeIterator.random;
        map.put(nodeIterator, newPreIterator.next);
        newPreIterator = newPreIterator.next;
        nodeIterator = nodeIterator.next;
      }
    }

    RandomListNode newIterator = newPre.next;
    while (newIterator != null) {
      newIterator.random = map.get(newIterator.random);
      newIterator = newIterator.next;
    }

    return newPre.next;
  }
}
