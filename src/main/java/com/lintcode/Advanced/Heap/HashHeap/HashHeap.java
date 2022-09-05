package com.lintcode.Advanced.Heap.HashHeap;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: Oliver
 */
@Slf4j
public class HashHeap {
  ArrayList<Integer> heap;
  String mode;
  int size_t;
  HashMap<Integer, Node> hash;

  public static void main(String[] args) {
    log.debug("Hello!");
  }

  public HashHeap(String mod) {
    heap = new ArrayList<>();
    mode = mod;
    hash = new HashMap<>();
    size_t = 0;
  }

  public int peek() {
    return heap.get(0);
  }

  public int size() {
    return size_t;
  }

  public Boolean isEmpty() {
    return (heap.isEmpty());
  }

  int parent(int id) {
    if (id == 0) {
      return -1;
    }
    return (id - 1) / 2;
  }

  int lson(int id) {
    return id * 2 + 1;
  }

  int rson(int id) {
    return id * 2 + 2;
  }

  boolean comparesmall(int a, int b) {
    if (a <= b) {
      return mode.equals("min");
    } else {
      return !mode.equals("min");
    }

  }

  void swap(int idA, int idB) {
    int valA = heap.get(idA);
    int valB = heap.get(idB);

    int numA = hash.get(valA).num;
    int numB = hash.get(valB).num;
    hash.put(valB, new Node(idA, numB));
    hash.put(valA, new Node(idB, numA));
    heap.set(idA, valB);
    heap.set(idB, valA);
  }

  public Integer poll() {
    size_t--;
    Integer now = heap.get(0);
    Node hashnow = hash.get(now);
    if (hashnow.num == 1) {
      swap(0, heap.size() - 1);
      hash.remove(now);
      heap.remove(heap.size() - 1);
      if (!heap.isEmpty()) {
        siftdown(0);
      }
    } else {
      hash.put(now, new Node(0, hashnow.num - 1));
    }
    return now;
  }

  public void add(int now) {
    size_t++;
    if (hash.containsKey(now)) {
      Node hashnow = hash.get(now);
      hash.put(now, new Node(hashnow.id, hashnow.num + 1));

    } else {
      heap.add(now);
      hash.put(now, new Node(heap.size() - 1, 1));
    }

    siftup(heap.size() - 1);
  }

  public boolean delete(int now) {
    if (hash.containsKey(now)) {
      size_t--;
      Node hashnow = hash.get(now);
      int id = hashnow.id;
      int num = hashnow.num;
      if (hashnow.num == 1) {
        swap(id, heap.size() - 1);
        hash.remove(now);
        heap.remove(heap.size() - 1);
        if (heap.size() > id) {
          siftup(id);
          siftdown(id);
        }
      } else {
        hash.put(now, new Node(id, num - 1));
      }
      return true;
    } else {
      return false;
    }
  }

  void siftup(int id) {
    while (parent(id) > -1) {
      int parentId = parent(id);
      if (comparesmall(heap.get(parentId), heap.get(id))) {
        break;
      } else {
        swap(id, parentId);
      }
      id = parentId;
    }
  }

  void siftdown(int id) {
    while (lson(id) < heap.size()) {
      int leftId = lson(id);
      int rightId = rson(id);
      int son;
      if (rightId >= heap.size() || (comparesmall(heap.get(leftId), heap.get(rightId)))) {
        son = leftId;
      } else {
        son = rightId;
      }
      if (comparesmall(heap.get(id), heap.get(son))) {
        break;
      } else {
        swap(id, son);
      }
      id = son;
    }
  }

  @Override
  public String toString() {
    return "HashHeap{" +
            "heap=" + heap +
            ", mode='" + mode + '\'' +
            ", size_t=" + size_t +
            ", hash=" + hash +
            '}';
  }

  private class Node {
    public Integer id;
    public Integer num;

    Node(Node now) {
      id = now.id;
      num = now.num;
    }

    Node(Integer first, Integer second) {

      this.id = first;
      this.num = second;
    }

    @Override
    public String toString() {
      return "Node{" +
              "id=" + id +
              ", num=" + num +
              '}';
    }
  }
}
