package com.lintCode.Advanced.UnionFind;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-14.
 */
public class NumberOfIslandsII {
    private final static Logger logger = LoggerFactory.getLogger(NumberOfIslandsII.class);

    public static void main(String[] arg) {
        new NumberOfIslandsII().testNumberOfIslands();
    }

    private void testNumberOfIslands() {
        Point[] operators = new Point[4];
        operators[0] = new Point(0, 0);
        operators[1] = new Point(0, 1);
        operators[2] = new Point(2, 2);
        operators[3] = new Point(2, 1);
        logger.info("{}", numIslands2(3, 3, operators));

        logger.info("{}", numIslands2(1, 1, new Point[0]));
    }

    /**
     * @param n         an integer
     * @param m         an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        // handle extreme cases
        if (n == 0 || m == 0 || operators == null || operators.length == 0) {
            return new ArrayList<Integer>();
        }

        // init the UnionFindQuiz
        UnionFind unionFind = new UnionFind(n, m);
        boolean[][] grid = new boolean[n][m];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int numberOfIslands = 0;
        for (Point operator : operators) {
            grid[operator.x][operator.y] = true;
            numberOfIslands++;
            for (int t = 0; t < 4; t++) {
                int X = operator.x + dx[t];
                int Y = operator.y + dy[t];
                if (valid(X, Y, n, m) && grid[X][Y]) {
                    if (unionFind.union(convert2Id(operator.x, operator.y, m), convert2Id(X, Y, m))) {
                        numberOfIslands--;
                    }
                }
            }
            ans.add(numberOfIslands);
        }

        return ans;
    }

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    private boolean valid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private int convert2Id(int x, int y, int m) {
        return x * m + y;
    }
}
