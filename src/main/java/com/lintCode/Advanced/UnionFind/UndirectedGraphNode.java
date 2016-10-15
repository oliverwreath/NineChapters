package com.lintCode.Advanced.UnionFind;

import java.util.ArrayList;

/**
 * Created by yanli on 2016-10-15.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
