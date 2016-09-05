package com.lintCode.LinkedList;

/**
 * Created by yanli on 9/5/2016.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
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
}
