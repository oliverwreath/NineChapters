package com.util;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public ListNode(int[] vals) {
    val = vals[0];
    ListNode cur = this;
    for (int i = 1; i < vals.length; i++) {
      cur.next = new ListNode(vals[i]);
      cur = cur.next;
    }
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }

  public ListNode addNext(int x) {
    this.next = new ListNode(x);
    return this.next;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ListNode listNode = (ListNode) o;
    return val == listNode.val && java.util.Objects.equals(next, listNode.next);
  }

  @Override public int hashCode() {
    return Objects.hash(val, next);
  }
}
