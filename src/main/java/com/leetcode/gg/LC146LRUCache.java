package com.leetcode.gg;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. HashMap with Deque(LinkedList). But they are not integrated. 257 ms
 * TIME: O(N)
 * SPACE: O(N)
 * <p>
 * Version 2: TBD. Integrated customized DoublyLinkedList. 0 ms
 * TIME: O(1)
 * SPACE: O(N)
 */
@Slf4j
public class LC146LRUCache {
  public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> hashMap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.hashMap = new HashMap<>();
      this.head = new Node(-1, -1);
      this.tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      if (!hashMap.containsKey(key)) {
        return -1;
      } else {
        Node node = hashMap.get(key);
        refresh(node);
        return hashMap.get(key).val;
      }
    }

    public void put(int key, int value) {
      if (!hashMap.containsKey(key)) {
        // insert
        if (hashMap.size() == capacity) {
          Node node = tail.prev;
          node.prev.next = node.next;
          node.next.prev = node.prev;
          hashMap.remove(node.key);
        }
        Node node = new Node(key, value);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
        hashMap.put(key, node);
      } else {
        // update
        Node node = hashMap.get(key);
        node.val = value;
        refresh(node);
      }
    }

    private void refresh(Node node) {
      if (node.prev != head) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
      }
    }

    class Node {
      Node prev;
      Node next;
      int key;
      int val;

      public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
      }

      public Node(Node prev, Node next, int key, int val) {
        this.prev = prev;
        this.next = next;
        this.key = key;
        this.val = val;
      }

      @Override
      public String toString() {
        return "Node{" +
                "prev=" + prev +
                ", next=" + next +
                ", val=" + val +
                '}';
      }
    }
  }
}
