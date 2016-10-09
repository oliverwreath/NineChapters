package com.LeetCode.Weekly8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class PacificAtlanticWaterFlow_417 {
    private final static Logger logger = LoggerFactory.getLogger(PacificAtlanticWaterFlow_417.class);

    public static void main(String[] arg) {
        new PacificAtlanticWaterFlow_417().testLongestPalindrome_409();
    }

    private void testLongestPalindrome_409() {
//        logger.info("true = {}", pacificAtlantic(new int[][]{
//                {1, 2, 2, 3, 5},
//                {3, 2, 3, 4, 4},
//                {2, 4, 5, 3, 1},
//                {6, 7, 1, 4, 5},
//                {5, 1, 1, 2, 4}}));
        logger.info("true = {}", pacificAtlantic(new int[][]{
                {1, 2},
                {4, 3}}));
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new LinkedList<int[]>();
        }

        // up
//        System.out.println("up");
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] flag = new boolean[n][m];
        LinkedList<Cell> listUp = new LinkedList<Cell>();
        HashSet<Cell> setUp = new HashSet<Cell>();
        listUp.add(new Cell(0, 0));
        setUp.add(new Cell(0, 0));
        flag[0][0] = true;
        for (int i = 1; i < n; i++) {
            listUp.add(new Cell(i, 0));
            setUp.add(new Cell(i, 0));
            flag[i][0] = true;
        }
        for (int j = 1; j < m; j++) {
            listUp.add(new Cell(0, j));
            setUp.add(new Cell(0, j));
            flag[0][j] = true;
        }

        while (!listUp.isEmpty()) {
            Cell cell = listUp.poll();
            for (int t = 0; t < 4; t++) {
                int tmpX = cell.x + dx[t];
                int tmpY = cell.y + dy[t];
                if (tmpX >= 0 && tmpY >= 0 && tmpX < n && tmpY < m) {
                    if (!flag[tmpX][tmpY] && matrix[tmpX][tmpY] >= matrix[cell.x][cell.y]) {
                        listUp.add(new Cell(tmpX, tmpY));
                        setUp.add(new Cell(tmpX, tmpY));
                        flag[tmpX][tmpY] = true;
                    }
                }
            }
        }
        System.out.println("setUp = " + setUp);

        // down
//        System.out.println("down");
        flag = new boolean[n][m];
        LinkedList<Cell> listDown = new LinkedList<Cell>();
        HashSet<Cell> setDown = new HashSet<Cell>();
        listDown.add(new Cell(n - 1, m - 1));
        setDown.add(new Cell(n - 1, m - 1));
        flag[n - 1][m - 1] = true;
        for (int i = 0; i < n - 1; i++) {
            listDown.add(new Cell(i, m - 1));
            setDown.add(new Cell(i, m - 1));
            flag[i][m - 1] = true;
        }
        for (int j = 0; j < m - 1; j++) {
            listDown.add(new Cell(n - 1, j));
            setDown.add(new Cell(n - 1, j));
            flag[n - 1][j] = true;
        }

        while (!listDown.isEmpty()) {
            Cell cell = listDown.poll();
            for (int t = 0; t < 4; t++) {
                int tmpX = cell.x + dx[t];
                int tmpY = cell.y + dy[t];
                if (tmpX >= 0 && tmpY >= 0 && tmpX < n && tmpY < m) {
                    if (!flag[tmpX][tmpY] && matrix[tmpX][tmpY] >= matrix[cell.x][cell.y]) {
                        listDown.add(new Cell(tmpX, tmpY));
                        setDown.add(new Cell(tmpX, tmpY));
                        flag[tmpX][tmpY] = true;
                    }
                }
            }
        }
        System.out.println("setDown = " + setDown);

        // return answer
        LinkedList<int[]> answer = new LinkedList<int[]>();
        for (Cell cell : setDown) {
            if (setUp.contains(cell)) {
                answer.add(new int[]{cell.x, cell.y});
            }
        }
        for (int[] ints : answer) {
            System.out.println(Arrays.toString(ints));
        }

        return answer;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private class Cell {
        int x;
        int y;

        public Cell() {
        }

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    x +
                    ", " + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (x != cell.x) return false;
            return y == cell.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
