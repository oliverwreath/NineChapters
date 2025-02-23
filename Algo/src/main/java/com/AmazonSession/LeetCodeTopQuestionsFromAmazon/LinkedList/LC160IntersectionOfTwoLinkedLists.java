package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList;

import com.util.ListNode;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Single loop adding up digits and handle carry along the way.
 * <p>
 * TIME: O(N) SPACE: O(N)
 * <p>
 * Version 2: TBD. while loop and swap if reaching the end.
 * <p>
 * TIME: O(N) SPACE: O(1)
 */
@Slf4j
public class LC160IntersectionOfTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // filter abnormal cases
    if (headA == null || headB == null) {
      return null;
    }

    // dp logic
    ListNode a = headA;
    ListNode b = headB;
    HashSet<ListNode> set = new HashSet<>();
    while (a != null) {
      set.add(a);
      a = a.next;
    }
    while (b != null) {
      if (set.contains(b)) {
        return b;
      }
      b = b.next;
    }

    // return the final result
    return null;
  }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // filter abnormal cases
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        // dp logic
//        ListNode a = headA;
//        ListNode b = headB;
//        while (a != b) {
//            a = a.next == null ? headB : a.next;
//            b = b.next == null ? headA : b.next;
//        }
//
//        // return the final result
//        return a;
//    }

}
