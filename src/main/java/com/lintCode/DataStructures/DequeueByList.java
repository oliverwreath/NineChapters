package com.lintCode.DataStructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanli on 9/18/2016.
 */
public class DequeueByList {
    List<Integer> list;

    public DequeueByList() {
        // do initialize if necessary
        list = new LinkedList<Integer>();
    }

    public void push_front(int item) {
        // Write your code here
        list.add(0, item);
    }

    public void push_back(int item) {
        // Write your code here
        list.add(item);
    }

    public int pop_front() {
        // Write your code here
        return list.remove(0);
    }

    public int pop_back() {
        // Write your code here
        return list.remove(list.size() - 1);
    }
}