package com.lintcode.LinkedList;

import java.util.Objects;

/**
 * Author: Oliver
 */
public class RandomListNode {

  int label;
  public RandomListNode next;
  public RandomListNode random;

  public RandomListNode(int x) {
    this.label = x;
  }

  @Override
  public String toString() {
    return "RandomListNode{" +
        "label=" + label +
        ", next=" + next +
        ", random=" + (random == null ? null : random.label) +
        '}';
  }

  public RandomListNode addNext(int x) {
    next = new RandomListNode(x);
    return next;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    RandomListNode that = (RandomListNode) o;
    return label == that.label && Objects.equals(next, that.next) && Objects.equals(
        (random == null) ? null : random.label, (that.random == null) ? null : that.random.label);
  }

  @Override public int hashCode() {
    return Objects.hash(label, next, (random == null) ? null : random.label);
  }
}
