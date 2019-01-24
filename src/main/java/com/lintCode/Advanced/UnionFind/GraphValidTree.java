package com.lintCode.Advanced.UnionFind;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-14.
 */
public class GraphValidTree {
    private final static Logger logger = LoggerFactory.getLogger(GraphValidTree.class);

    public static void main(String[] arg) {
        new GraphValidTree().testNumberOfIslands();
    }

    private void testNumberOfIslands() {
        logger.info("{}", validTree(5,
                new int[][]{
                        {0, 1},
                        {0, 2},
                        {0, 3},
                        {1, 4}
                }
        ));
        logger.info("{}", validTree(5,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {1, 3},
                        {1, 4}
                }
        ));
    }

    /**
     * @param n     an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        // handle extreme cases
        if (n < 2) {
            return true;
        }
        if (edges == null || edges.length == 0) {
            return false;
        }

        // init UnionFindQuiz
        int m = edges.length;
        UnionFind unionFind = new UnionFind(n, 1);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }

        // count how many bigBrother
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(unionFind.compressed_find(i));
        }
        return set.size() == 1;
    }
}
