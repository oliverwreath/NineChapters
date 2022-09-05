package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class QueueByList {
  List<Integer> list;

  public QueueByList() {
    // do initialize if necessary
    list = new LinkedList<Integer>();
  }

  public void enqueue(int item) {

    list.add(item);
  }

  public int dequeue() {

    return list.remove(0);
  }
}
