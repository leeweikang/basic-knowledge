package com.wakeup.算法.深搜广搜;

public class 被围绕的区域 {
    public void solve(char[][] board) {
        int height = board.length, wide = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == height - 1 || j == 0 || j == wide - 1) {
                        dps (board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dps(char[][] board, int i, int j) {
        int height = board.length, wide = board[0].length;
        if (i < 0 || i >= height || j < 0 || j >= wide || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'F';
        dps(board, i + 1, j);
        dps(board, i - 1, j);
        dps(board, i, j + 1);
        dps(board, i, j - 1);
    }

//    public void fps(char[][] board, int i, int j) {
//        int height = board.length, wide = board[0].length;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < wide; j++) {
//                if (board[i][j] == 'O') {
//                    if (i == 0 || i == height - 1 || j == 0 || j == wide - 1) {
//                        dps (board, i, j);
//                    }
//                }
//            }
//        }
//    }



}
