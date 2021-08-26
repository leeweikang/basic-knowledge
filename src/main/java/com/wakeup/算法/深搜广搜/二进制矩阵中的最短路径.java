package com.wakeup.算法.深搜广搜;

import java.util.LinkedList;
import java.util.Queue;

public class 二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = 0;
        return res;
    }

    public int bfs(int[][] grid) {
        int[] X = {0,1,1,1,0,-1,-1,-1};//方向数组
        int[] Y = {1,1,0,-1,-1,-1,0,1};
        int res = 1;
        int high = grid.length, wide = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        if (grid[0][0] != 0) {
            return -1;
        }
        queue.offer(0);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int temp = queue.poll();
                int x = temp / wide;
                int y = temp % wide;
                for(int j = 0; j < 8; j++){
                    int x1 = x + X[j];
                    int y1 = y + Y[j];
                    if(x1 >= 0 && x1 < high && y1 >= 0 && y1 < wide && grid[x1][y1] == 0){//数组不越界，值为1，//没有被访问过才能入队
                        queue.add(x1 * wide + y1);//入队
                        grid[x1][y1] = 2;//标记已访问！！！！！！！！！！！！不要忘记
                    }
                }
                if(x == high - 1 && y == wide - 1) {
                    return res;//终止条件
                }

            }
            res++;

        }
        return -1;
    }
}
