package com.lintCode.DataStructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanli on 9/18/2016.
 */
public class QueueByList {
    List<Integer> list;

    public QueueByList() {
        // do initialize if necessary
        list = new LinkedList<Integer>();
    }

    public void enqueue(int item) {
        // Write your code here
        list.add(item);
    }

    public int dequeue() {
        // Write your code here
        return list.remove(0);
    }
}
