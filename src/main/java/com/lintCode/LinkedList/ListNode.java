package com.lintCode.LinkedList;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                (next == null ? "" : ", next=" + next.val) +
                '}';
    }
}
