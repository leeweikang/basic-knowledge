package com.wakeup.算法.深搜广搜;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {

    public int numIslands(char[][] grid) {
        int res = 0;
        int xlen = grid.length, ylen = grid[0].length;
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                res += dps(grid, i, j);
            }
        }
        return res;
    }

    public int dps(char[][] grid, int x, int y) {
        int xlen = grid.length, ylen = grid[0].length;
        if (x < 0 || x >= xlen || y < 0 || y >= ylen || grid[x][y] != '1') {
            return 0;
        }
        grid[x][y] = '2';
        dps(grid, x + 1, y);
        dps(grid, x - 1, y);
        dps(grid, x, y - 1);
        dps(grid, x, y + 1);
        return 1;
    }

    public int fps(char[][] grid) {

        int xlen = grid.length, ylen = grid[0].length;
        int res = 0;

        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    res++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * ylen + j);
                    while (!queue.isEmpty()) {
                        int site = queue.poll();
                        int x = site / ylen;
                        int y = site % ylen;
                        if (x + 1 < xlen && grid[x + 1][y] == '1') {
                            queue.offer((x + 1) * ylen + y);
                            grid[x + 1][y] = '0';
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.offer((x - 1) * ylen + y);
                            grid[x - 1][y] = '0';
                        }
                        if (y + 1 < ylen && grid[x][y + 1] == '1') {
                            queue.offer(x  * ylen + y + 1);
                            grid[x][y + 1] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.offer(x  * ylen + y - 1);
                            grid[x][y - 1] = '0';
                        }
                    }
                }
            }
        }


        return res;
    }



}
