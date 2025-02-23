package com.lintcode.DataStructures;

import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

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
