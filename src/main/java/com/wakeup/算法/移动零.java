package com.wakeup.算法;

public class 移动零 {
    public static void main(String[] args) {
        int[][] image = new int[][]{{0,0,0},{0,1,1}};
        floodFill(image, 1,1, 1);
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int cul = image[0].length;
        return floodFillPlus(image, sr, sc, newColor, image[sr][sc]);
    }

    public static int[][] floodFillPlus(int[][] image, int sr, int sc, int newColor,int tar) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
                || image[sr][sc] != tar ) {
            return image;
        }
        image[sr][sc] = newColor;
        floodFillPlus(image ,sr - 1, sc, newColor ,tar);
        floodFillPlus(image ,sr + 1, sc, newColor ,tar);
        floodFillPlus(image ,sr, sc - 1, newColor ,tar);
        floodFillPlus(image ,sr, sc + 1, newColor ,tar);
        return image;
    }
}
