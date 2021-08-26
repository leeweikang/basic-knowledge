package com.wakeup.算法.深搜广搜;

import java.util.LinkedList;
import java.util.Queue;

public class 省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int xlen = isConnected.length;
        int res = 0;
        int[] isVisited = new int[xlen];

        for (int i = 0; i < xlen; i++) {
            if (isConnected[i][i] == 1 && isVisited[i] == 0) {
                res ++;
                dps(isConnected, i, isVisited);
            }
        }
        return res;

    }
    public void dps (int[][] isConnected, int x, int[] isVisited) {
        int ylen = isConnected[0].length;

        if (isVisited[x] == 1) {
            return;
        }

        isVisited[x] = 1;

        for (int i = 0; i < ylen; i++) {

            if (isConnected[x][i] == 1) {
                dps(isConnected, i, isVisited);
            }
            
        }
    }

    public int fps (int[][] isConnected) {
        int res = 0;
        int xlen = isConnected.length;
        int ylen = isConnected[0].length;
        int[] isVisited = new int[xlen];

        for (int i = 0; i < xlen; i++) {
            if (isConnected[i][i] == 1 && isVisited[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                res++;
                isVisited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    for (int j = 0; j < ylen; j++) {
                        if (isConnected[k][j] == 1 && isVisited[j] == 0) {
                            queue.offer(j);
                            isVisited[j] = 1;
                        }
                    }
                }
            }
        }
        return res;
    }
}
