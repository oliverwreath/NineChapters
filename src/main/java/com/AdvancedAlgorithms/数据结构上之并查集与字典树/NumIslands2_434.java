package com.AdvancedAlgorithms.数据结构上之并查集与字典树;

import java.util.LinkedList;
import java.util.List;

public class NumIslands2_434 {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> result = new LinkedList<>();
        if (operators == null || n <= 0 || m <= 0) {
            return result;
        }

        UnionFind unionFind = new UnionFind(n, m);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] isIsland = new boolean[n][m];

        int count = 0;
        for (Point operator : operators) {
            int x = operator.x;
            int y = operator.y;
            if (!isIsland[x][y]) {
                count++;
                isIsland[x][y] = true;
                for (int t = 0; t < 4; t++) {
                    int nx = x + dx[t];
                    int ny = y + dy[t];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && isIsland[nx][ny]) {
                        int rootA = unionFind.find(x, y);
                        int rootB = unionFind.find(nx, ny);
                        if (rootA != rootB) {
                            unionFind.union(rootA, rootB);
                            count--;
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private class UnionFind {
        private int[] father;
        private int m;

        public UnionFind(int n, int m) {
            this.father = new int[n * m];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
            this.m = m;
        }

        private int getIndex(int x, int y) {
            return x * m + y;
        }

        private void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                father[rootX] = rootY;
            }
        }

        public int find(int i, int j) {
            return find(getIndex(i, j));
        }

        public int find(int x) {
            if (father[x] == x) {
                return x;
            } else {
                return father[x] = find(father[x]);
            }
        }
    }

    private class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
