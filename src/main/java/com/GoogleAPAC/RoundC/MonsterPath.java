package com.GoogleAPAC.RoundC;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/18/2016.
 */
public class MonsterPath {
    private static final Logger logger = LoggerFactory.getLogger(MonsterPath.class);

    public static void main(String[] arg) {
        testMonsterPath();
    }

    private static void testMonsterPath() {
        long startTime = System.currentTimeMillis();
        monsterPath();
        logger.info("time elapsed: {}ms", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static double P;
    private static double Q;
    private static boolean[][] booleanGrid;
    private static int R;
    private static int C;

    static void monsterPath() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            // input
            R = scan.nextInt();
            C = scan.nextInt();
            int r = scan.nextInt();
            int c = scan.nextInt();
            int S = scan.nextInt();
            P = scan.nextDouble();
            Q = scan.nextDouble();
            double[][] grid = new double[R][C];
            booleanGrid = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    String string = scan.next();
//                    System.out.print(string + " ");
                    if (string.equals("A")) { // A got attractor P, (1-P) * P = P - P^2, (1-((1-P) * P)) * P= P - P^2 + P^3
                        grid[i][j] = P;
                        booleanGrid[i][j] = true;
                    } else {
                        grid[i][j] = Q;
                    }
                }
//                System.out.println();
            }

//            for (int i = 0; i < R; i++) {
//                System.out.println(Arrays.toString(grid[i]));
//            }

            // process
            double ret = move(grid, r, c, S, 0.0);

            System.out.format("Case #%d: %.9f\n", t + 1, ret);
        }
    }

    static double move(double[][] grid, int x, int y, int remainS, double currentPoint) {
        if (remainS == 0.0) {
            return currentPoint;
        }

        double ret = Double.MIN_VALUE;
        if (x + 1 < R) {
            double oldValue = grid[x + 1][y];
            if (booleanGrid[x + 1][y]) {
                grid[x + 1][y] *= (1 - P);
            } else {
                grid[x + 1][y] = 0;
            }
            ret = Math.max(ret, move(grid, x + 1, y, remainS - 1, oldValue + currentPoint));
            grid[x + 1][y] = oldValue;
        }
        if (y + 1 < C) {
            double oldValue = grid[x][y + 1];
            if (booleanGrid[x][y + 1]) {
                grid[x][y + 1] *= (1 - P);
            } else {
                grid[x][y + 1] = 0;
            }
            ret = Math.max(ret, move(grid, x, y + 1, remainS - 1, oldValue + currentPoint));
            grid[x][y + 1] = oldValue;
        }
        if (x - 1 >= 0) {
            double oldValue = grid[x - 1][y];
            if (booleanGrid[x - 1][y]) {
                grid[x - 1][y] *= (1 - P);
            } else {
                grid[x - 1][y] = 0;
            }
            ret = Math.max(ret, move(grid, x - 1, y, remainS - 1, oldValue + currentPoint));
            grid[x - 1][y] = oldValue;
        }
        if (y - 1 >= 0) {
            double oldValue = grid[x][y - 1];
            if (booleanGrid[x][y - 1]) {
                grid[x][y - 1] *= (1 - P);
            } else {
                grid[x][y - 1] = 0;
            }
            ret = Math.max(ret, move(grid, x, y - 1, remainS - 1, oldValue + currentPoint));
            grid[x][y - 1] = oldValue;
        }
//        System.out.println(ret);
        return ret;
    }

}
