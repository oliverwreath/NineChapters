package com.ATemplates_DataStructures.MyIslands;

import com.ATemplates_DataStructures.UnionFind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class No305_NumberOfIslandsII {
    private final static Logger logger = LoggerFactory.getLogger(No305_NumberOfIslandsII.class);

    public static void main(String[] args) {
        testNo305_NumberOfIslandsII();
    }

    private static void testNo305_NumberOfIslandsII() {
        No305_NumberOfIslandsII No305_NumberOfIslandsII = new No305_NumberOfIslandsII();
        MyLogger.info("result 2 v.s. " + No305_NumberOfIslandsII.numIslands2(3, 3,
                new int[][]{
                        {0, 0},
                        {0, 1},
                        {1, 2},
                        {2, 1}
                }));
//        MyLogger.info("result 1 v.s. " + No305_NumberOfIslandsII.numIslands2("10"));
    }

    /**
     * @param m
     * @param n
     * @param positions
     * @return
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // filter abnormal cases
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();
        UnionFind unionFind = new UnionFind();
        int[][] islandMatrix = new int[m][n];
        int numberOfIslands = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            islandMatrix[x][y] = 1;
            unionFind.addNew(unionFind.convert2Id(x, y, n));
            numberOfIslands++;
            // up
            if (isValid(x - 1, y, m, n)) {
                if (islandMatrix[x - 1][y] == 1) {
                    boolean hasMerged = unionFind.union_Number_Of_Island2(unionFind.convert2Id(x, y, n), unionFind.convert2Id(x - 1, y, n));
                    if (hasMerged) {
                        numberOfIslands--;
                    }
                }
            }
            // down
            if (isValid(x + 1, y, m, n)) {
                if (islandMatrix[x + 1][y] == 1) {
                    boolean hasMerged = unionFind.union_Number_Of_Island2(unionFind.convert2Id(x, y, n), unionFind.convert2Id(x + 1, y, n));
                    if (hasMerged) {
                        numberOfIslands--;
                    }
                }
            }
            // left
            if (isValid(x, y - 1, m, n)) {
                if (islandMatrix[x][y - 1] == 1) {
                    boolean hasMerged = unionFind.union_Number_Of_Island2(unionFind.convert2Id(x, y, n), unionFind.convert2Id(x, y - 1, n));
                    if (hasMerged) {
                        numberOfIslands--;
                    }
                }
            }
            // right
            if (isValid(x, y + 1, m, n)) {
                if (islandMatrix[x][y + 1] == 1) {
                    boolean hasMerged = unionFind.union_Number_Of_Island2(unionFind.convert2Id(x, y, n), unionFind.convert2Id(x, y + 1, n));
                    if (hasMerged) {
                        numberOfIslands--;
                    }
                }
            }
            result.add(numberOfIslands);
        }

        // return the final result
        return result;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
