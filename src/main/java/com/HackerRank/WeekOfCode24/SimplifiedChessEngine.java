package com.HackerRank.WeekOfCode24;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class SimplifiedChessEngine {
    private static final Logger logger = LoggerFactory.getLogger(SimplifiedChessEngine.class);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        new SimplifiedChessEngine().play(in);
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

            boolean hasWon = playOne(piecesWhite, piecesBlack, true, m);
            if (hasWon) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private boolean playOne(Map<Integer, Piece> piecesWhite, Map<Integer, Piece> piecesBlack, boolean isWhiteTurn, int m) {
        if (m == 0) {
            return false;
        }
        if (isWhiteTurn) {
            // initialize the board
            boolean[][] flag = getFlagMatrix(piecesWhite, piecesBlack);

            // each piece tried every possible move
            Iterator<Piece> valueIterator = piecesWhite.values().iterator();
            while (valueIterator.hasNext()) {
                Piece piece = valueIterator.next();
                if (piece.type == 'N') {
                    for (int k = 0; k < dxN.length; k++) {
                        int X = piece.x + dxN[k];
                        int Y = piece.y + dyN[k];
                        executeMove(piecesWhite, piecesBlack, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                } else if (piece.type == 'R') {
                    for (int k = 0; k < dxR.length; k++) {
                        int X = piece.x + dxR[k];
                        int Y = piece.y + dyR[k];
                        executeMove(piecesWhite, piecesBlack, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                } else if (piece.type == 'B') {
                    for (int k = 0; k < dxB.length; k++) {
                        int X = piece.x + dxB[k];
                        int Y = piece.y + dyB[k];
                        executeMove(piecesWhite, piecesBlack, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                } else if (piece.type == 'Q') {
                    for (int k = 0; k < dxQ.length; k++) {
                        int X = piece.x + dxQ[k];
                        int Y = piece.y + dyQ[k];
                        executeMove(piecesWhite, piecesBlack, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                }
            }
        } else {
            // initialize the board
            boolean[][] flag = getFlagMatrix(piecesWhite, piecesBlack);

            // each piece tried every possible move
            Iterator<Piece> valueIterator = piecesWhite.values().iterator();
            while (valueIterator.hasNext()) {
                Piece piece = valueIterator.next();
                if (piece.type == 'N') {
                    for (int k = 0; k < dxN.length; k++) {
                        int X = piece.x + dxN[k];
                        int Y = piece.y + dyN[k];
                        executeMove(piecesBlack, piecesWhite, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                } else if (piece.type == 'R') {
                    for (int k = 0; k < dxR.length; k++) {
                        int X = piece.x + dxR[k];
                        int Y = piece.y + dyR[k];
                        executeMove(piecesBlack, piecesWhite, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                } else if (piece.type == 'B') {
                    for (int k = 0; k < dxB.length; k++) {
                        int X = piece.x + dxB[k];
                        int Y = piece.y + dyB[k];
                        executeMove(piecesBlack, piecesWhite, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                } else if (piece.type == 'Q') {
                    for (int k = 0; k < dxQ.length; k++) {
                        int X = piece.x + dxQ[k];
                        int Y = piece.y + dyQ[k];
                        executeMove(piecesBlack, piecesWhite, X, Y, piece, flag, m - 1, isWhiteTurn);
                    }
                }
            }
        }

        return false;
    }

    private boolean executeMove(Map<Integer, Piece> piecesWhite, Map<Integer, Piece> piecesBlack, int X, int Y, Piece piece, boolean[][] flag, int m, boolean isWhiteTurn) {
        if (valideXY(X, Y)) {
            // every valid move
            if (!flag[X][Y]) {
                piecesWhite.remove(piece.x * 10 + piece.y);
                piecesWhite.put(X * 10 + Y, new Piece(piece.type, true, X, Y));
                boolean hasWon = playOne(piecesWhite, piecesBlack, true, m);
                if (hasWon) {
                    return true;
                }
                piecesWhite.put(piece.x * 10 + piece.y, piece);
                piecesWhite.remove(X * 10 + Y);
            } else {
                // step into something
                // find the piece
                Piece pieceEaten = findPiece(piecesWhite, piecesBlack, X * 10 + Y);
                if (isWhiteTurn && pieceEaten.isWhite || !isWhiteTurn && !pieceEaten.isWhite) {
                    return false;
                } else {
                    if (isWhiteTurn && pieceEaten.type == 'Q') {
                        return true;
                    } else if (!isWhiteTurn && pieceEaten.type == 'Q') {
                        return false;
                    }
                    piecesWhite.remove(piece.x * 10 + piece.y);
                    piecesWhite.put(X * 10 + Y, new Piece(piece.type, true, X, Y));
                    Piece removedTmp1 = piecesBlack.remove(X * 10 + Y);
                    boolean hasWon = playOne(piecesWhite, piecesBlack, true, m);
                    if (hasWon) {
                        return true;
                    }
                    piecesWhite.put(piece.x * 10 + piece.y, piece);
                    piecesWhite.remove(X * 10 + Y);
                    piecesBlack.put(X * 10 + Y, removedTmp1);
                }
            }
        }
        return false;
    }

    static int[] dxQ = new int[]{1, 2, 3, -1, -2, -3, 0, 0, 0, 0, 0, 0, 1, 2, 3, 1, 2, 3, -1, -2, -3, -1, -2, -3};
    static int[] dyQ = new int[]{0, 0, 0, 0, 0, 0, 1, 2, 3, -1, -2, -3, 1, 2, 3, -1, -2, -3, 1, 2, 3, -1, -2, -3};

    static int[] dxB = new int[]{1, 2, 3, 1, 2, 3, -1, -2, -3, -1, -2, -3};
    static int[] dyB = new int[]{1, 2, 3, -1, -2, -3, 1, 2, 3, -1, -2, -3};

    static int[] dxR = new int[]{1, 2, 3, -1, -2, -3, 0, 0, 0, 0, 0, 0};
    static int[] dyR = new int[]{0, 0, 0, 0, 0, 0, 1, 2, 3, -1, -2, -3};

    static int[] dxN = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dyN = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

    private boolean[][] getFlagMatrix(Map<Integer, Piece> piecesWhite, Map<Integer, Piece> piecesBlack) {
        boolean[][] flag = new boolean[4][4];
        for (Piece piece : piecesWhite.values()) {
            flag[piece.x][piece.y] = true;
        }
        for (Piece piece : piecesBlack.values()) {
            flag[piece.x][piece.y] = true;
        }
        return flag;
    }

    private boolean valideXY(int X, int Y) {
        return X >= 0 && X < 4 && Y >= 0 && Y < 4;
    }

    private Piece findPiece(Map<Integer, Piece> piecesWhite, Map<Integer, Piece> piecesBlack, int KEY) {
        if (piecesWhite.containsKey(KEY)) {
            return piecesWhite.get(KEY);
        }
        if (piecesBlack.containsKey(KEY)) {
            return piecesBlack.get(KEY);
        }
        return null;
    }

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
