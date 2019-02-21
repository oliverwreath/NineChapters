package com.HackerRank.WeekOfCode24;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class RandomTmp {
    private static final Logger logger = LoggerFactory.getLogger(RandomTmp.class);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        new RandomTmp().play(in);
    }

    private void play(Scanner in) {
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int w = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();

            Map<Integer, Piece> piecesWhite = new HashMap<Integer, Piece>();
            Map<Integer, Piece> piecesBlack = new HashMap<Integer, Piece>();
            for (int i = 0; i < w; i++) {
                Character type = in.next().charAt(0);
                int x = in.next().charAt(0) - 'A';
                int y = in.nextInt() - 1;
                Piece piece = new Piece(type, true, x, y);
                piecesWhite.put(x * 10 + y, piece);
                System.out.println("piece = " + piece);
            }
            for (int i = 0; i < b; i++) {
                Character type = in.next().charAt(0);
                int x = in.next().charAt(0) - 'A';
                int y = in.nextInt() - 1;
                Piece piece = new Piece(type, false, x, y);
                piecesBlack.put(x * 10 + y, piece);
                System.out.println("piece = " + piece);
            }

            Random random = new Random();
            if (random.nextInt(2) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int[] ret = new int[]{};

    private class Piece {
        Character type;
        boolean isWhite;
        int x;
        int y;

        public Piece() {
        }

        public Piece(Character type, boolean isWhite, int x, int y) {
            this.type = type;
            this.isWhite = isWhite;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Piece{" +
                    "type=" + type +
                    ", isWhite=" + isWhite +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
