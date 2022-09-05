package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class DequeueByList {
  List<Integer> list;

  public DequeueByList() {
    // do initialize if necessary
    list = new LinkedList<Integer>();
  }

  public void push_front(int item) {

    list.add(0, item);
  }

  public void push_back(int item) {

    list.add(item);
  }

  public int pop_front() {

    return list.remove(0);
  }

  public int pop_back() {

    return list.remove(list.size() - 1);
  }
}
