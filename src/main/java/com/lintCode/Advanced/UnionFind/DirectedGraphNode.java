package com.lintCode.Advanced.UnionFind;

import java.util.ArrayList;

/**
 * Created by yanli on 2016-10-15.
 */
class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}